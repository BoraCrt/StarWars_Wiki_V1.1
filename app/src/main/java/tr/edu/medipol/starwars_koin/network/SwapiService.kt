package tr.edu.medipol.starwars_koin.network

import kotlinx.serialization.json.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import tr.edu.medipol.starwars_koin.model.PeopleModel

interface SwapiService {
    @GET("people/{peopleId}")
    suspend fun getPeople(@Path("peopleId") peopleId: Int) :Response<PeopleModel> //Response
}