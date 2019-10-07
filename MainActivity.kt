package com.example.clockoftheuniverse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView



class MainActivity : AppCompatActivity() {
companion object{
    var das: LottieAnimationView?= null

    fun display(koin: String) {
        when (koin) {

            "clear-day"  -> {
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("hello.json")
                    das?.loop(true)
                }
            }
            "clear-night"  -> {
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("2801-night-moon.json")
                    das?.loop(true)
                }
            }
            "partly-cloudy-night"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4796-weather-cloudynight.json")
                    das?.loop(true)
                }
            }
            "partly-cloudy-day"->{

                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("7420-clouds-opening.json")
                    das?.loop(true)
                }
            }
            "nightcloudy"-> {
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4796-weather-cloudynight.json")
                    das?.loop(true)
                }
            }
            "daycloudy"->{

                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("2594-a-simple-sun-day.json")
                    das?.loop(true)
                }
            }
            "dayrain"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4803-weather-storm.json")
                    das?.loop(true)
                }

            }
            "nightrain"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4797-weather-rainynight.json")
                    das?.loop(true)
                }

            }
            "nightfog"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("7707-fog.json")
                    das?.loop(true)
                }
            }
            "dayfog"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4791-foggy.json")
                    das?.loop(true)
                }
            }
            "nightsnow"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4798-weather-snownight.json")
                    das?.loop(true)
                }
            }
            "daysnow"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4798-weather-snownight.json")
                    das?.loop(true)
                }
            }
            "nightsleet"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4798-weather-snownight.json")
                    das?.loop(true)
                }
            }
            "daysleet"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4798-weather-snownight.json")
                    das?.loop(true)
                }
            }
            "nightwind"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("7720-windy.json.json")
                    das?.loop(true)
                }
            }
           "daywind"->{
               if (das!!.isAnimating) {
                   das?.clearAnimation()


               } else {
                   das?.clearAnimation()
                   das?.setAnimation("7720-windy.json.json")
                   das?.loop(true)
               }
           }
            "dayhail"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4801-weather-partly-shower.json")
                    das?.loop(true)
                }
            }
            "nighthail"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4801-weather-partly-shower.json")
                    das?.loop(true)
                }
            }
            "daythunder"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4792-weather-stormshowersday.json")
                    das?.loop(true)
                }
            }
            "nightthunder"->{
                if (das!!.isAnimating) {
                    das?.clearAnimation()


                } else {
                    das?.clearAnimation()
                    das?.setAnimation("4805-weather-thunder.json")
                    das?.loop(true)
                }
            }
        }

    }
}



      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)
          das = findViewById<LottieAnimationView>(R.id.av_from_code)


      }

  }


