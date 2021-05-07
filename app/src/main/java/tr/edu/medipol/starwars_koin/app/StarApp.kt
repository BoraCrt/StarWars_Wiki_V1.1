package tr.edu.medipol.starwars_koin.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import tr.edu.medipol.starwars_koin.di.networkModule
import tr.edu.medipol.starwars_koin.di.viewModelModule

class StarApp : Application() {
    override fun onCreate() {
        super.onCreate()
    startKoin {
        androidContext(this@StarApp)
        androidLogger(Level.ERROR)
        modules(networkModule, viewModelModule)
    }

    }
}