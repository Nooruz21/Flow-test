package com.awb.flowtest

/**
 * Feature flags
 *
 * @constructor Создает feature флаг
 */
object FeatureFlags {
    private val flags = mutableMapOf<String, Boolean>()

    init {
        flags["SignIn"] = false
        flags["SingUp"] = false
    }

    fun enableFeature(featureName: String) {
        flags[featureName] = true
    }

    /**
     * ```mermaid
     * graph LR
     *   A --> B
     *   B --> C
     *   C --> A
     * ```
     */
    fun disableFeature(featureName: String) {
        flags[featureName] = false
    }

    /**
     * кликабельная или не кликабельная
     *
     * @param featureName - ожидания ключа
     * @return true if feature enabled
     */
    fun isFeatureEnabled(featureName: String): Boolean {
        return flags[featureName] ?: false
    }
}
