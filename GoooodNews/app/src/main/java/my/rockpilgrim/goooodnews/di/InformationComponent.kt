package my.rockpilgrim.goooodnews.di

import dagger.Subcomponent
import my.rockpilgrim.goooodnews.ui.information.InformationActivity

@Subcomponent(modules = [InformationModule::class])
@InformationScope
interface InformationComponent {

    fun inject(activity: InformationActivity)
}