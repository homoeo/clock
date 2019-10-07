package com.example.clockoftheuniverse.time
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.storage.FirebaseStorage
import java.util.*
import android.net.Uri
import android.graphics.drawable.Drawable
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.Task
import java.net.URL
import android.location.Geocoder
import android.os.Build
import android.os.Handler
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.clockoftheuniverse.BuildConfig
import com.example.clockoftheuniverse.MainActivity
import com.example.clockoftheuniverse.api.DarkskyService
import com.example.clockoftheuniverse.model.DarkskyModel
import com.google.firebase.storage.StorageReference
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter


open class TimeViewModel : ViewModel() {



    val darkSkyApiResponseLiveData = MutableLiveData<DarkskyModel.Darksky>()

    var okk:Boolean =true
    var count:Int = 0
     var nwdata: DarkskyModel.Darksky? = null

var time= MutableLiveData<String>()
    val tim:LiveData<String>
       get() = time


     var latitude:Double = 0.0
    var mandler: Handler? = Handler()
    val c = Calendar.getInstance()
   lateinit var  storageRef:StorageReference
    var longitude:Double = 0.0

    private val forecastAdi by lazy { DarkskyService.create() }

    fun getpic(ho: Int, i: String?) {

        when (i) {

            "clear-day", "clear-night" -> {
                if ((ho <=6) || (ho >=18)) {
                    MainActivity.display(   "clear-night" )

                 //   MainActivity.das.setAnimation("2594-a-simple-sun-day.json")
                 //   MainActivity.das.loop(true)
                } else {
                    MainActivity.display(  "clear-day" )
               //     MainActivity.das.setAnimation("2801-night-moon.json")
              //      MainActivity.das.loop(true)



                }

            }
            "rain" -> {

                if ((ho <= 6) || (ho >= 18)) {

                    MainActivity.display( "nightrain" )
                 //   MainActivity.das.setAnimation("4797-weather-rainynight.json")
                 //   MainActivity.das.loop(true)

                } else {
                    MainActivity.display( "dayrain" )
                 //   MainActivity.das.setAnimation("4792-weather-stormshowersday.json")
              //      MainActivity.das.loop(true)


                }


            }

            "snow" -> {
                if ((ho <= 6) || (ho >= 18)) {
                    MainActivity.display( "nightsnow" )
                }
                else
                {
                    MainActivity.display( "daysnow" )
                }


            }
            "sleet" -> {
                if ((ho < 6) || (ho > 18)) {
                    MainActivity.display( "nightsleet" )
                }
                else
                {
                    MainActivity.display( "daysleet" )
                }


            }


            "wind" -> {
                if ((ho <= 6) || (ho >= 18)) {

                    MainActivity.display( "nightwind" )
                }
                else{
                    MainActivity.display( "daywind" )
                }


            }
            "fog" -> {

                if ((ho <= 6) || (ho >= 18)) {

                    MainActivity.display( "nightfog" )
                }
                else {
                    MainActivity.display( "dayfog" )
                }


            }
            "cloudy" -> {
                if ((ho <= 6) || (ho >= 18)) {
                    MainActivity.display( "nightcloudy" )

                  //  MainActivity.das.setAnimation("4796-weather-cloudynight.json")
                //    MainActivity.das.loop(true)

                }
                else
                {
                    MainActivity.display( "daycloudy" )
                //    MainActivity.das.setAnimation("4796-weather-cloudynight.json")
                 //   MainActivity.das.loop(true)
                }


            }
            "partly-cloudy-night", "partly-cloudy-day" -> {

                    if ((ho <= 6) || (ho >= 18)) {
                      MainActivity.display("partly-cloudy-night")
                     //   MainActivity.das.setAnimation("4801-weather-partly-shower.json")
                     //   MainActivity.das.loop(true)

                    } else {
                        MainActivity.display( "partly-cloudy-day")
                    //    MainActivity.das.setAnimation("4801-weather-partly-shower.json")
                     //   MainActivity.das.loop(true)

                    }


            }
            "hail" -> {
                if ((ho <= 6) || (ho >= 18)) {
                    MainActivity.display( "nighthail")

                } else {
                    MainActivity.display( "dayhail")


                }

            }
            "thunderstorm" -> {
                if ((ho <= 6) || (ho >= 18)) {
                    MainActivity.display( "nighthunde")



                } else {
                    MainActivity.display( "daythunder")


                }

            }


        }

    }






    var a = 0

    var jit:Boolean = true
    var git:Boolean = true
    var status = MutableLiveData<Boolean>()
       val statuss:LiveData<Boolean>
            get() = status
    var  formattedDate =MutableLiveData<String>()
    val formatteddDate:LiveData<String>
    get() = formattedDate
    var sec = MutableLiveData<String>()
    val secc:LiveData<String>
        get() = sec
    var summary = MutableLiveData<String>()
        val summuone:LiveData<String>
    get() = summary

    init {

latitude =  17.4785
        longitude = 78.5506






    }
    fun uptime(timezone: String,icon:String?) {


        c.setTimeZone(TimeZone.getTimeZone(timezone))
        val date = c.getTime()
        val df = SimpleDateFormat("dd/MM/yyyy")
        val strDate = df.format(date)
        var gh:String =  c.getTime().toString()
        var hour = c.get(Calendar.HOUR_OF_DAY)
        getpic(hour,icon)
    }



    fun updatetime(){


             forecastAdi.forecast(BuildConfig.DARKSKY_KEY,latitude,longitude,"us",arrayListOf("").toString()).enqueue(object : Callback<DarkskyModel.Darksky> {
                 @RequiresApi(Build.VERSION_CODES.O)
                 override fun onResponse(call: Call<DarkskyModel.Darksky>, response: Response<DarkskyModel.Darksky>) {


                     // Pass information to the view
                     darkSkyApiResponseLiveData.value = response.body()
                     nwdata = response.body()
                     sec.value = darkSkyApiResponseLiveData.value?.currently?.icon.toString()


                         uptime(nwdata!!.timezone,nwdata!!.currently.icon).toString()
                     val formatter:DateTimeFormatter=
                         DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


                     var formattedDtm: String = Instant.ofEpochSecond(
                         nwdata!!.currently.time)
                         .atZone(ZoneId.of("Asia/Kolkata"))
                         .format(formatter)
                     time.value = formattedDtm

                     if(a<=19) {
                       a= a+1
                         summary.value   =  nwdata?.hourly?.summary


                     }
                     else{
                         a=0

                         summary.value =  nwdata?.daily?.summary
                     }

                 }


                 override fun onFailure(call: Call<DarkskyModel.Darksky>, throwable: Throwable) {

                 }
             })
         }



























    fun fetchadd(con:FragmentActivity){

        if (okk == true) {
            val geocoder = Geocoder(con, Locale.getDefault())
            val list = geocoder.getFromLocation(
                latitude, longitude, 1
            )
            if (list != null && list.size > 0) {
                val address = list[0]
                // sending back first address line and locality
                var result = address.adminArea

               formattedDate.value = result

            }
        }

    }



}