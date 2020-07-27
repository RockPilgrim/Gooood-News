package my.rockpilgrim.goooodnews.ui.information

import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.information_activity.*
import my.rockpilgrim.goooodnews.R
import my.rockpilgrim.goooodnews.di.App
import javax.inject.Inject

class InformationActivity : MvpAppCompatActivity(),
    InfoMvpView {

    val TAG = "InformationActivity"

    @Inject
    @InjectPresenter
    lateinit var presenter: InformationPresenter

    @ProvidePresenter
    fun provideInformationPresenter(): InformationPresenter = presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        App.getInformationComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information_activity)
        Log.i(TAG, "onCreate")

        val position = intent.getIntExtra(TAG, -1)

        initView(position)
        initToolBar()
    }

    private fun initView(position:Int) {
        infoTitleTextView.text = presenter.getTitle(position)
        infoFullTextView.text = presenter.getFullText(position)
        if (presenter.getImage(position) != "") {
            Picasso.get().load(presenter.getImage(position)).into(infoImageView)
        }
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

    override fun onDestroy() {
        super.onDestroy()
        App.clearInformationComponent()
    }
}