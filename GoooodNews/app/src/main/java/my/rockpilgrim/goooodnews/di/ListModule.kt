package my.rockpilgrim.goooodnews.di

import dagger.Module
import dagger.Provides
import my.rockpilgrim.goooodnews.data.Model
import my.rockpilgrim.goooodnews.ui.list.ItemRequest
import my.rockpilgrim.goooodnews.ui.list.ListAdapter
import my.rockpilgrim.goooodnews.ui.list.ListPresenter

@Module
class ListModule {

    @Provides
    @ListScope
    fun provideListAdapter(): ListAdapter {
        return ListAdapter()
    }

    @Provides
    @ListScope
    fun provideListPresenter(model: Model): ListPresenter {
        return ListPresenter(model)
    }

    @Provides
    @ListScope
    fun provideItemRequest(listPresenter: ListPresenter): ItemRequest {
        return listPresenter
    }
}