package my.rockpilgrim.goooodnews.ui.list

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface ListMvpView : MvpView {
    fun dataSuccess()
    fun dataError()
    fun update()
}