package tr.edu.medipol.starwars_koin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.liveData
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Response
import tr.edu.medipol.starwars_koin.R
import tr.edu.medipol.starwars_koin.network.DataState
import tr.edu.medipol.starwars_koin.network.networkCall

class MainActivity : AppCompatActivity() {
    val mainViewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getPeople().observe(this) {
            if (it is DataState.Success){

            }
        }

        //lifecycleScope.launch {
            //networkCall {test()}
       // }

    }
     //fun test()= liveData { networkCall {  }}
}

fun main() {
    print(bora(1))
}
fun bora(number:Int):Int{
    return number*5
}
//datastate yapısı bnakılacak,kendin ui yap,farklı bir endpoint,data çekilecek ve gösterilecek ,reclylerview kullan,news api kullanılacak , p.tesi bakılacak