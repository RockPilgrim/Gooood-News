package my.rockpilgrim.goooodnews.di

import dagger.Component
import my.rockpilgrim.goooodnews.list.ListActivity
import my.rockpilgrim.goooodnews.list.ListItemHolder
import my.rockpilgrim.goooodnews.list.ListPresenter
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {

    fun inject(activity:ListActivity)
    fun inject(viewHolder:ListItemHolder)

    /// Presenters
    fun inject(presenter:ListPresenter)
}