package ljie.coolweather

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    companion object {
        const val TOKEN = ""

        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}