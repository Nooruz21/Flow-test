package com.awb.flowtest

object FeatureFlags {
    private val flags = mutableMapOf<String, Boolean>()

    init {
        flags["SignIn"] = false
        flags["SingUp"] = false
    }

    fun enableFeature(featureName: String) {
        flags[featureName] = true
    }

    fun disableFeature(featureName: String) {
        flags[featureName] = false
    }

    fun isFeatureEnabled(featureName: String): Boolean {
        return flags[featureName] ?: false
    }
}
