package my.rockpilgrim.goooodnews.di

import dagger.Component
import my.rockpilgrim.goooodnews.information.InformationActivity
import my.rockpilgrim.goooodnews.information.InformationPresenter
import my.rockpilgrim.goooodnews.list.ListActivity
import my.rockpilgrim.goooodnews.list.ListItemHolder
import my.rockpilgrim.goooodnews.list.ListPresenter
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {

    /// Activities
    fun inject(activity:ListActivity)
    fun inject(activity: InformationActivity)
    fun inject(viewHolder:ListItemHolder)

    /// Presenters
    fun inject(presenter:ListPresenter)
    fun inject(presenter: InformationPresenter)
}