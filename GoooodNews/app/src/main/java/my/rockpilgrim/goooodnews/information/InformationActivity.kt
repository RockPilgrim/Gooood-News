package my.rockpilgrim.goooodnews.information

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.information_activity.*
import my.rockpilgrim.goooodnews.R
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

class InformationActivity : MvpAppCompatActivity(),InfoMvpView {

    val TAG = "InformationActivity"

    @Inject
    @InjectPresenter
    lateinit var presenter: InformationPresenter

    @ProvidePresenter
    fun provideInformationPresenter(): InformationPresenter = presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information_activity)

        Log.i(TAG, "onCreate")

        presenter.getDate(4)

        val position = intent.getIntExtra(TAG, -1)

        initView(position)
        initToolBar()
    }

    private fun initView(position:Int) {
        infoTitleTextView.setText(presenter.getTitle(position))
    }

    private fun initToolBar() {
        val toolbar = listToolbar
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    /// On back pressed on toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}