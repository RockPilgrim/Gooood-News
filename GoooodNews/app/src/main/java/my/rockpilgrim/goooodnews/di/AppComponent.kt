package my.rockpilgrim.goooodnews.di

import dagger.Component
import my.rockpilgrim.goooodnews.ui.information.InformationActivity
import my.rockpilgrim.goooodnews.ui.information.InformationPresenter
import my.rockpilgrim.goooodnews.ui.list.ListActivity
import my.rockpilgrim.goooodnews.ui.list.ListItemHolder
import my.rockpilgrim.goooodnews.ui.list.ListPresenter
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun addListComponent(listModule: ListModule): ListComponent
    fun addInformationComponent(informationModule: InformationModule): InformationComponent

    /// Presenters
    fun inject(presenter: ListPresenter)
    fun inject(presenter: InformationPresenter)
}