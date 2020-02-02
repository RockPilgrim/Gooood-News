package my.rockpilgrim.goooodnews.di

import android.app.Application
import my.rockpilgrim.goooodnews.data.base.AppDatabase

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        appComponent=initAppComponent()
        appDatabase=initAppDatabase()
    }

    private fun initAppDatabase(): AppDatabase {
        return AppDatabase.buildDatabase(applicationContext)
    }

    private fun initAppComponent(): AppComponent {
        return DaggerAppComponent.builder().build()
    }
}
