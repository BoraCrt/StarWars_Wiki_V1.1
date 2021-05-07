package tr.edu.medipol.starwars_koin.network


sealed class DataState<out T> {
    //object Loading:DataState<Nothing>()
    data class Success<T>(val data:T?):DataState<T>() //dönüş tiplerini bak (inhertaion)(Dönüş tipleri iki noktadan sonra gelmektedir,unit dönüş tipinin kullanılması dönüş yapılmayacağı anlamına gelir.)//
    data class Exception(val exception:String):DataState<Nothing>()
}
//generic ne olduğuna bakılacak...