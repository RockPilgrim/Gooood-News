package my.rockpilgrim.goooodnews.information

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import my.rockpilgrim.goooodnews.data.DataInformation
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

@InjectViewState
class InformationPresenter : MvpPresenter<InfoMvpView>(),InfoPresenter {

    val TAG = "InformationPresenter"

    @Inject
    lateinit var data: DataInformation

    init {
        App.appComponent.inject(this)
        Log.i(TAG, "init")
    }

    override fun getTitle(position: Int): String {
        return "Title"
    }

    override fun getDate(position: Int): String {
        Log.i(TAG, "getDate")
        return "Date"
    }

    override fun getFullText(position: Int): String {
        return "FullText"
    }

    override fun getImage(position: Int): String {
        return "Image"
    }

}