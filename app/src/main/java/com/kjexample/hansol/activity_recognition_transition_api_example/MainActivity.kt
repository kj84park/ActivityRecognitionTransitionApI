package com.kjexample.hansol.activity_recognition_transition_api_example

import android.app.PendingIntent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.location.ActivityRecognition
import com.google.android.gms.location.ActivityTransition
import com.google.android.gms.location.ActivityTransitionRequest
import com.google.android.gms.location.DetectedActivity
import android.content.Intent
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    val transitions = ArrayList<ActivityTransition>()
    lateinit var transitionPendingIntent: PendingIntent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        transitions.add(ActivityTransition.Builder()
                .setActivityType(DetectedActivity.WALKING)
                .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                .build())
        transitions.add(ActivityTransition.Builder()
                .setActivityType(DetectedActivity.WALKING)
                .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                .build())
        transitions.add(ActivityTransition.Builder()
                .setActivityType(DetectedActivity.STILL)
                .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                .build())
        transitions.add(ActivityTransition.Builder()
                .setActivityType(DetectedActivity.STILL)
                .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                .build())

        val request = ActivityTransitionRequest(transitions)

        val intent = Intent(this,ArtReceiver::class.java)
        transitionPendingIntent = PendingIntent.getService(this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val task = ActivityRecognition.getClient(this).requestActivityTransitionUpdates(request, transitionPendingIntent)

        task.addOnSuccessListener {
            Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
        }

        task.addOnFailureListener {
            Toast.makeText(this, "fail", Toast.LENGTH_LONG).show()
        }

    }
}
