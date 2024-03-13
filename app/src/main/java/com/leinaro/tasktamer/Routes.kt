package com.leinaro.tasktamer

sealed class Routes(val route: String) {
    object ActivitiesList: Routes("activities-list")
    object Login: Routes("login")
    object PasswordRecover: Routes("password-recover")
    object CodeVerify: Routes("code-verifiy")
    object Register: Routes("register")
    object Profile: Routes("profile")
    object Info: Routes("info")
    object CreateActivity: Routes("create-activity")
    object Alarma: Routes("alarma")
    object CompleteActivity: Routes("complete-activity")
    object PosponerActivity: Routes("porponer-activity")
}