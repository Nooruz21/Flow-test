package com.awb.flowtest.ui

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.awb.flowtest.R

/**
 * Activity nav controller
 *
 */
fun Fragment.activityNavController() = requireActivity().findNavController(R.id.nav_host_fragment)

/**
 * Navigate safely for sdadfsadfasdf
 *
 * @param actionId
 */
fun NavController.navigateSafely(@IdRes actionId: Int) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}

fun NavController.navigateSafely(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}