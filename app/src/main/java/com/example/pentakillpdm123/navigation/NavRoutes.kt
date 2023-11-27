package com.example.pentakillpdm123.navigation


sealed class NavRoutes (val route: String) {
    object positionchamps : NavRoutes("positionchamps")
    object homemainview : NavRoutes("homemainview")
    object news : NavRoutes("news")
    object stream : NavRoutes("stream")
    object social : NavRoutes("social")
    object profile : NavRoutes("profileroute")
    object onboarding : NavRoutes("onboarding")
    object login : NavRoutes("loginscreenview")
    object register : NavRoutes("registerscreenview")
    object SplashView : NavRoutes("splashview")

}

