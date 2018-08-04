package inc.ahmedmourad.cinematics.mvvm.model.sync

import android.content.Context
import android.content.Intent

import com.firebase.jobdispatcher.Constraint
import com.firebase.jobdispatcher.FirebaseJobDispatcher
import com.firebase.jobdispatcher.GooglePlayDriver
import com.firebase.jobdispatcher.Lifetime
import com.firebase.jobdispatcher.RetryStrategy
import com.firebase.jobdispatcher.Trigger
import inc.ahmedmourad.cinematics.mvvm.model.room.database.CinematicsDatabase
import inc.ahmedmourad.cinematics.utils.KEY_IS_SYNC_SCHEDULED
import inc.ahmedmourad.cinematics.utils.defaultPrefs
import inc.ahmedmourad.cinematics.utils.get
import inc.ahmedmourad.cinematics.utils.set
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

object SyncUtils {

    private const val SYNC_INTERVAL = 60 * 60 * 24
    private const val SYNC_FLEXTIME = SYNC_INTERVAL / 3

    private const val SYNC_TAG = "sync"

    @Synchronized
    fun initialize(context: Context) {

        val prefs = defaultPrefs(context)

        if (!prefs[KEY_IS_SYNC_SCHEDULED, false]) {

            scheduleSync(context)

            prefs[KEY_IS_SYNC_SCHEDULED] = true
        }

        launch(CommonPool) {

            if (CinematicsDatabase.getInstance(context).needsSync(context))
                syncImmediately(context)
        }
    }

    private fun syncImmediately(context: Context) {

        context.startService(Intent(context, SyncIntentService::class.java))
    }

    private fun scheduleSync(context: Context) {

        val dispatcher = FirebaseJobDispatcher(GooglePlayDriver(context))

        val syncJob = dispatcher.newJobBuilder()
                .setService(SyncJobService::class.java)
                .setTag(SYNC_TAG)
                .setConstraints(Constraint.DEVICE_IDLE, Constraint.ON_UNMETERED_NETWORK)
                .setLifetime(Lifetime.FOREVER)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                .setRecurring(true)
                .setTrigger(Trigger.executionWindow(SYNC_INTERVAL, SYNC_INTERVAL + SYNC_FLEXTIME))
                .setReplaceCurrent(false)
                .build()

        dispatcher.schedule(syncJob)
    }
}
