package my.rockpilgrim.goooodnews.di

import dagger.Module
import dagger.Provides
import my.rockpilgrim.goooodnews.data.Model
import my.rockpilgrim.goooodnews.ui.information.InformationPresenter

@Module
class InformationModule {

    @Provides
    @InformationScope
    fun provideInformationPresenter(model: Model): InformationPresenter {
        return InformationPresenter(model)
    }
}