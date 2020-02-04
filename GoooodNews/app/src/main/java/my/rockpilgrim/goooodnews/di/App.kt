package my.rockpilgrim.goooodnews.di

import android.app.Application
import my.rockpilgrim.goooodnews.data.base.AppDatabase

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent

        lateinit var appDatabase: AppDatabase

        /// ListComponent
        private var listComponent: ListComponent? = null

        fun getListComponent(): ListComponent {
            if (listComponent == null) {
                listComponent = appComponent.addListComponent(ListModule())
            }
            return listComponent as ListComponent
        }
        fun clearListComponent() {
            listComponent = null
        }
        /// InformationComponent
        private var informationComponent: InformationComponent? = null

        fun getInformationComponent(): InformationComponent {
            if (informationComponent == null) {
                informationComponent = appComponent.addInformationComponent(InformationModule())
            }
            return informationComponent as InformationComponent
        }
        fun clearInformationComponent() {
            informationComponent = null
        }
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
