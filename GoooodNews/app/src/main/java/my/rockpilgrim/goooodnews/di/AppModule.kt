package my.rockpilgrim.goooodnews.di

import dagger.Module
import dagger.Provides
import my.rockpilgrim.goooodnews.data.DataCard
import my.rockpilgrim.goooodnews.data.DataInformation
import my.rockpilgrim.goooodnews.data.Model
import my.rockpilgrim.goooodnews.ui.information.InformationPresenter
import my.rockpilgrim.goooodnews.ui.list.ItemRequest
import my.rockpilgrim.goooodnews.ui.list.ListAdapter
import my.rockpilgrim.goooodnews.ui.list.ListPresenter
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
    fun provideModel(): Model {
        return Model()
    }

    @Provides
    fun provideDataCard(model: Model): DataCard {
        return model
    }

    @Provides
    fun provideDataInformation(model: Model): DataInformation {
        return model
    }

    /// Presenters
    @Provides
    @Singleton
    fun provideListPresenter(model: Model): ListPresenter {
        return ListPresenter(model)
    }

    @Provides
    fun provideItemRequest(listPresenter: ListPresenter): ItemRequest {
        return listPresenter
    }

    @Provides
    @Singleton
    fun provideInformationPresenter(model: Model): InformationPresenter {
        return InformationPresenter(model)
    }
}