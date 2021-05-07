package tr.edu.medipol.starwars_koin.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable //serializiable,parseable bakılacak..(class'a göre)
data class PeopleModel(val name:String,val height:String,@SerialName("hair_color") val hairColor:String)

