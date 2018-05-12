# ActivityRecognitionTransitionApI

1. Introduction
Phones are our most personal devices we bring with us everywhere, but until now it's been hard for apps to adjust their experience to a user's continually changing environment and activity. We've heard from developer after developer that they're spending valuable engineering time to combine various signals like location and sensor data just to determine when the user has started or ended an activity like walking or driving. Even worse, when apps are independently and continuously checking for changes in user activity, battery life suffers.

Activity Recognition Transition API helps in solving these problems by providing a simple API that does all the processing for you and just tells you what you actually care about: when a user's activity has changed. Your app subscribes to a transition in activities of interest and the API notifies your app only when needed.

As an example, a messaging app can ask - tell me when the user has entered or exited the vehicle to set the user's status to busy. Similarly, a parking detection app can ask - tell me when the user has exited a vehicle and started walking.

2. Reference
https://codelabs.developers.google.com/codelabs/activity-recognition-transition/index.html?index=..%2F..%2Findex#0
