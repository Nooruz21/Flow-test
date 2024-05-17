package com.awb.flowtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.awb.flowtest.databinding.ActivityMainBinding
import com.awb.flowtest.ui.UserData
/**
 * MainActivity является точкой входа в приложение, которое обрабатывает настройку навигации
 * и определяет начальное назначение на основе статуса авторизации пользователя.
 *
 * @property binding Объект привязки для макета активности.
 * @property navController Контроллер навигации для управления навигацией в приложении.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    /**
     * Вызывается при запуске активности. Здесь происходит инициализация.
     *
     * @param savedInstanceState Если активность пересоздается после предыдущего завершения работы,
     *                           то этот Bundle содержит данные, которые были сохранены ранее.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    /**
     * Настраивает навигацию путем инициализации NavController и установки начального назначения
     * на основе статуса авторизации пользователя.
     *
     * Если пользователь авторизован, начальное назначение устанавливается на `mainFlowFragment`.
     * Если пользователь не авторизован, начальное назначение устанавливается на `signFlowFragment`.
     */
    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when {
            UserData.isAuthorized -> {
                navGraph.setStartDestination(R.id.mainFlowFragment)
            }

            !UserData.isAuthorized -> {
                navGraph.setStartDestination(R.id.signFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}
