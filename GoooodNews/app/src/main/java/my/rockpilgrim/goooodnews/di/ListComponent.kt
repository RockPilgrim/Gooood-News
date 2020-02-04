package my.rockpilgrim.goooodnews.di

import dagger.Subcomponent
import my.rockpilgrim.goooodnews.ui.list.ListActivity
import my.rockpilgrim.goooodnews.ui.list.ListItemHolder

@Subcomponent(modules = [ListModule::class])
@ListScope
interface ListComponent {

    fun inject(activity: ListActivity)
    fun inject(viewHolder: ListItemHolder)
}