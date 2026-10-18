package com.example.droidmentor

import androidx.navigation.NavController

fun NavController.safePopBackStack() {
    if (previousBackStackEntry != null) popBackStack()
}