package ljie.coolweather.util

import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request

class HttpUtil {

    fun sendOkHttpRequest(address: String?, callback: Callback?) {
        val client = OkHttpClient()
        val request = Request.Builder().url(address!!).build()
        client.newCall(request).enqueue(callback!!)
    }
}