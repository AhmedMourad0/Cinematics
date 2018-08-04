package inc.ahmedmourad.cinematics.mvvm.model.sync

import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService

class SyncJobService : JobService() {

    override fun onStartJob(jobParameters: JobParameters): Boolean {

        SyncTask.sync(baseContext)

        jobFinished(jobParameters, false)

        return true
    }

    override fun onStopJob(jobParameters: JobParameters?): Boolean {


        return true
    }
}
