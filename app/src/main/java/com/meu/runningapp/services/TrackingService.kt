package com.meu.runningapp.services

import android.content.Intent
import androidx.lifecycle.LifecycleService
import com.meu.runningapp.other.TrackingUtility.ActionServiceTracking
import timber.log.Timber

class TrackingService : LifecycleService() {

    //Essa função é chamada sempre que chamamos o serviço "TrackingService".
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action){
                ActionServiceTracking.ACTION_START_OR_RESUME_SERVICE.toString() -> {
                    Timber.d("Started or Resume service")
                }
                ActionServiceTracking.ACTION_PAUSE_SERVICE.toString() -> {
                    Timber.d("Paused service")
                }
                ActionServiceTracking.ACTION_STOP_SERVICE.toString() -> {
                    Timber.d("Stopped service")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
}