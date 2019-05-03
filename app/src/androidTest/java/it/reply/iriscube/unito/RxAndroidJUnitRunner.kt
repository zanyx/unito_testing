package it.reply.iriscube.unito

import android.support.test.runner.AndroidJUnitRunner
import com.squareup.rx2.idler.Rx2Idler
import io.reactivex.plugins.RxJavaPlugins

/**
 * Created by Reply on 03/11/2018.
 */
@Suppress("unused")
class RxAndroidJUnitRunner : AndroidJUnitRunner() {

    override fun onStart() {
        // Initializing Rx schedulers with idling resources.
        RxJavaPlugins.setInitComputationSchedulerHandler(
            Rx2Idler.create("RxJava 2.x computation scheduler")
        )
        super.onStart()
    }
}