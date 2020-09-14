package ljie.coolweather.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import ljie.coolweather.logic.model.PlaceResponse
import ljie.coolweather.logic.network.CoolWeatherNetwork
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = CoolWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
//            Result.failure(e)
            e.printStackTrace()
        }
        emit(result as Result<*>)
    }
}