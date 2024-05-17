package com.awb.flowtest.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
/**
 * Абстрактный класс `BaseFlowFragment`, используемый для базовой реализации фрагментов,
 * которые используют навигацию.
 *
 * @author Nooruz
 * @constructor Создает базовый фрагмент с указанным макетом и идентификатором NavHostFragment.
 * @param layoutId Идентификатор макета ресурса, используемого для этого фрагмента.
 * @since 1.0.0
 * @property layoutId- это id моего макета
 * @param navHostFragmentId Идентификатор NavHostFragment, используемого для управления навигацией внутри фрагмента.
 */
abstract class BaseFlowFragment(
    @LayoutRes layoutId: Int,
    @IdRes private val navHostFragmentId: Int
) : Fragment(layoutId) {

    /**
     * NavController, используемый для управления навигацией в этом фрагменте.
     */
    protected lateinit var navController: NavController
    /**
     * Вызывается при создании представления фрагмента.
     *
     * @param view Представление, созданное для фрагмента.
     * @param savedInstanceState Состояние, сохраненное в предыдущем экземпляре фрагмента, если таковое имеется.
     */
    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment =
            childFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        navController = navHostFragment.navController

        setupNavigation()
    }
    /**
     * Метод для настройки навигации. Может быть переопределен в подклассах для предоставления
     * конкретной логики настройки навигации.
     *
     * @see [toString]
     * @exception возможно ошибки например
     * @sample navigation - в другие экраны
     * @suppress не использовать это для deprecated
     * @throws IllegalArgumentException эта ошибка может выйти
     */
    protected open fun setupNavigation() {
    }
}