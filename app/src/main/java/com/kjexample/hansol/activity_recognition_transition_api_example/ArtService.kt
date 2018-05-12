package com.kjexample.hansol.activity_recognition_transition_api_example

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.google.android.gms.location.ActivityTransitionResult

class ArtService : IntentService("ArtService") {

    override fun onHandleIntent(intent: Intent?) {
        if (ActivityTransitionResult.hasResult(intent)) {
            val result = ActivityTransitionResult.extractResult(intent)
            result?.let {
                for (event in it.transitionEvents) {
                    Log.d(this.toString(), """#### Activity Type : ${event.activityType}""")
                    Log.d(this.toString(), """#### Transition Type :  ${event.transitionType}""")
                    Log.d(this.toString(), """#### ElapsedRealTime Nanos :  ${event.elapsedRealTimeNanos}""")
                }
            }
        }
    }
}
