package my.rockpilgrim.goooodnews.di

import android.app.Application

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent=initAppComponent()
    }

    private fun initAppComponent(): AppComponent {
        return DaggerAppComponent.builder().build()
    }
}
