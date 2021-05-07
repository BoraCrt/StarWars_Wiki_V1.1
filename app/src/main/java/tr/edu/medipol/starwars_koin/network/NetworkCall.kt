package tr.edu.medipol.starwars_koin.network

import kotlinx.coroutines.flow.flow
import retrofit2.Response
import kotlin.Exception

/*suspend fun<T> networkCall(call:suspend()->Response<T>)= flow {
    try  {
        emit(DataState.Loading)
     val response=call.invoke()
     if (response.isSuccessful) {
         emit(DataState.Success(response.body()))

     }else
         emit(DataState.Exception(response.message())) //response.errorbody bakılacak
    } catch (exception:Exception) {
        emit(DataState.Exception(exception.localizedMessage?:"HATA!!!"))
    }

}
Handle etmek:
Exception:Program çalıştığı esnada hata veya istisnai bir durum karşısısnda yapması gereken işleme verilen  genel addır.
//response.errorbody bakılacak (retrofit için serileştirilmiş hata yanıtı , bu sayede hata mesajlarının yazdırılabilmesini sağlar.)
*/

suspend fun<T:Any> networkCall(call:suspend()->Response<T>):DataState<T> {
   return try  {

        val response=call.invoke()
        if (response.isSuccessful) {
            DataState.Success(response.body())

        }else DataState.Exception(response.message())
    } catch (exception:Exception) {
        DataState.Exception(exception.localizedMessage?:"HATA!!!")
    }

}
//flow veya livedata dönmeyi araştır...