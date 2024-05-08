package com.awb.flowtest.ui.sign

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.awb.flowtest.FeatureFlags
import com.awb.flowtest.R
import com.awb.flowtest.databinding.FragmentSignInBinding
import com.awb.flowtest.ui.UserData
import com.awb.flowtest.ui.activityNavController
import com.awb.flowtest.ui.navigateSafely

/**
 * A Fragment for user authentication that provides interfaces for signing in and navigating to the registration page if necessary.
 *
 * The fragment allows existing users to authenticate and access the main application flow.
 * It also provides a registration option through the Sign Up button, visibility of which is controlled by feature flags.
 *
 * ## Functions
 * - [clickSignIn] - Handles the sign-in process and transitions to the main application flow.
 * - [clickSignUp] - Manages navigation to the sign-up page based on feature flags.
 *
 * ## Usage
 * This fragment is used as part of the authentication flow in the application. It is accessed when a user needs to sign in.
 *
 * @constructor Creates an instance of [SignInFragment].
 */
class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
    }

    /**
     * Sets up click listeners for the sign-in and sign-up processes.
     */
    private fun setupListeners() {
        clickSignIn()
        clickSignUp()
    }

    /**
     * Sets the click listener for the sign-in button.
     * Marks the user as authorized and navigates to the main flow of the application.
     */
    private fun clickSignIn() {
        binding.buttonSignIn.setOnClickListener {
            UserData.isAuthorized = true
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }
    }

    /**
     * Sets the click listener for the sign-up button based on feature flag availability.
     * If the sign-up feature is disabled, the button is hidden.
     */
    private fun clickSignUp() {
        if (!FeatureFlags.isFeatureEnabled("SignUp")) {
            binding.buttonSignUp.visibility = View.GONE
        } else {
            binding.buttonSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
            }
        }
    }

}
