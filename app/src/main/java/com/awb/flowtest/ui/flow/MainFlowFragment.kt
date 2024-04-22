package com.awb.flowtest.ui.flow

import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.awb.flowtest.R
import com.awb.flowtest.databinding.FlowFragmentMainBinding
import com.awb.flowtest.ui.base.BaseFlowFragment

class MainFlowFragment : BaseFlowFragment(
    R.layout.flow_fragment_main, R.id.nav_host_fragment_main
) {

    private val binding by viewBinding(FlowFragmentMainBinding::bind)

    override fun setupNavigation() {
        binding.bottomNavigation.setupWithNavController(navController)
    }
}