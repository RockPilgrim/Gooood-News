package my.rockpilgrim.goooodnews.ui.list

import com.arellomobile.mvp.MvpView

interface ListMvpView : MvpView {
    fun dataSuccess()
    fun dataError()
    fun update()
}