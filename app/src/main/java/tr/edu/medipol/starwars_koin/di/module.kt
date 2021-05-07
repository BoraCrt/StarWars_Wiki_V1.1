package tr.edu.medipol.starwars_koin.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import tr.edu.medipol.starwars_koin.network.SwapiService
import tr.edu.medipol.starwars_koin.ui.MainViewModel
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val client = OkHttpClient.Builder()
                .writeTimeout(20L,TimeUnit.SECONDS)
                .readTimeout(20L,TimeUnit.SECONDS)
                .connectTimeout(20L,TimeUnit.SECONDS)
                .build()
        Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .client(client)
                .addConverterFactory(Json {ignoreUnknownKeys = true}.asConverterFactory("application/json".toMediaType()
                ))
            .build()

    }
    single {
        val retrofit:Retrofit=get() //1.ci metod
        //(get()as Retrofit).create() //2.ci metod
        retrofit.create(SwapiService::class.java)
    }
}
val viewModelModule= module {
    viewModel { MainViewModel(get()) }

}
//State yapısı yapılacak
//Flow LiveData bakılacak
//Sealed Class bakılacak retrofit coroutinesde kullanmak
//veri alıp vermemizi sağlar okhttp client(asıl işi üstlenmektedir) -retrofit tool olarak kullanıldı.
//Yapılacaklar 5.05.2021
