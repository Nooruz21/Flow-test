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

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private val binding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        clickSignIn()
        clickSignUp()
    }

    private fun clickSignIn() {
        binding.buttonSignIn.setOnClickListener {
            UserData.isAuthorized = true
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }
        //большой фикс локализация
        //большая фича логике
    }

    private fun clickSignUp() {
        if (!FeatureFlags.isFeatureEnabled("SingUp")) {
            binding.buttonSignUp.visibility = View.GONE
        } else {
            binding.buttonSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
            }
        }
    }

}