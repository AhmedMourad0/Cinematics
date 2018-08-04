package inc.ahmedmourad.cinematics.paging

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

internal class UiThreadExecutor : Executor {

    private val mHandler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mHandler.post(command)
    }
}

internal class BackgroundThreadExecutor : Executor {

    private val executorService = Executors.newFixedThreadPool(3)

    override fun execute(command: Runnable) = executorService.execute(command)
}