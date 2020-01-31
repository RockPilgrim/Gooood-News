package my.rockpilgrim.goooodnews.di

import dagger.Component
import my.rockpilgrim.goooodnews.ui.information.InformationActivity
import my.rockpilgrim.goooodnews.ui.information.InformationPresenter
import my.rockpilgrim.goooodnews.ui.list.ListActivity
import my.rockpilgrim.goooodnews.ui.list.ListItemHolder
import my.rockpilgrim.goooodnews.ui.list.ListPresenter
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {

    /// Activities
    fun inject(activity: ListActivity)
    fun inject(activity: InformationActivity)
    fun inject(viewHolder: ListItemHolder)

    /// Presenters
    fun inject(presenter: ListPresenter)
    fun inject(presenter: InformationPresenter)
}