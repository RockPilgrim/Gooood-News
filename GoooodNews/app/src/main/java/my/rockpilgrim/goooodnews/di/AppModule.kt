package my.rockpilgrim.goooodnews.di

import dagger.Module
import dagger.Provides
import my.rockpilgrim.goooodnews.data.DataCard
import my.rockpilgrim.goooodnews.data.Model
import my.rockpilgrim.goooodnews.list.ItemRequest
import my.rockpilgrim.goooodnews.list.ListAdapter
import my.rockpilgrim.goooodnews.list.ListPresenter
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideListAdapter(): ListAdapter {
        return ListAdapter()
    }
    /// Models
    @Provides
    @Singleton
    fun provideModel():Model {
        return Model()
    }

    @Provides
    fun provideDataCard(model: Model): DataCard {
        return model
    }

    /// Presenters
    @Provides
    @Singleton
    fun provideListPresenter(): ListPresenter {
        return ListPresenter()
    }
    @Provides
    fun provideItemRequest(listPresenter: ListPresenter): ItemRequest {
        return listPresenter
    }
}