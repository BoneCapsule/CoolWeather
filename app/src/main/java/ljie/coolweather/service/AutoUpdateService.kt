package ljie.coolweather.service

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.preference.PreferenceManager
import android.util.Log
import ljie.coolweather.model.Weather
import ljie.coolweather.util.HttpUtil
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import java.util.*

class AutoUpdateService : Service() {

    private val WEATHER_KEY = "23ba7284d202491db698d3bad403241f"

    override fun onBind(intent: Intent): IBinder? {
        return null
    }


    private fun updateWeather() {
        
    }

    /**
     * 更新必应一图
     */
    private fun updateBingPic() {
        val url = "http://guolin.tech/api/bing_pic"
        HttpUtil().sendOkHttpRequest(url, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("AutoUpdateService", "onFailure: fail to update picture", IOException())
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val bingPic = response.body?.string()
                val editor =
                    PreferenceManager.getDefaultSharedPreferences(this@AutoUpdateService).edit()
                editor.putString("bing_pic", bingPic)
                editor.apply()
            }
        })
    }


}
