package inc.ahmedmourad.cinematics.mvvm.model.sync

import android.app.IntentService
import android.content.Intent

class SyncIntentService : IntentService("SyncIntentService") {

    override fun onHandleIntent(intent: Intent?) {

        SyncTask.sync(baseContext)
    }
}