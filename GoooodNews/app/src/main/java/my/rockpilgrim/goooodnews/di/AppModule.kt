package my.rockpilgrim.goooodnews.di

import dagger.Module
import dagger.Provides
import my.rockpilgrim.goooodnews.data.DataCard
import my.rockpilgrim.goooodnews.data.DataInformation
import my.rockpilgrim.goooodnews.data.Model
import javax.inject.Singleton

@Module
class AppModule {

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
}