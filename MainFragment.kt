package com.example.clockoftheuniverse


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.clockoftheuniverse.databinding.MainfragmentBinding
import com.example.clockoftheuniverse.time.TimeViewModel
import java.util.*
import android.R.attr.x
import androidx.core.view.ViewCompat.setX
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import com.airbnb.lottie.LottieAnimationView
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


class MainFragment:Fragment() {
    private lateinit var viewModel: TimeViewModel
    lateinit var textview4: TextView
    var isred = true

    lateinit var textview2:TextView
    private lateinit var binding: MainfragmentBinding
    lateinit var cal: Calendar
     var mHandler: Handler? =Handler()
    var sec:Int = 0
    var runnable: Runnable? = null
var isfred:Boolean = true
    lateinit var t:Thread
    lateinit var  f:Thread
    private val interval = 5000
    lateinit var localTime:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(
            inflater,
            R.layout.mainfragment,
            container,
            false
        )



        viewModel = ViewModelProviders.of(this).get(TimeViewModel::class.java)

       binding.timeViewModel =viewModel

        binding.setLifecycleOwner(this)

        viewModel.status.observe(this, androidx.lifecycle.Observer { status ->


                Toast.makeText(activity,
                    "success", Toast.LENGTH_LONG).show();
            })


        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {

                viewModel.updatetime()
                if(isfred) {
                    isfred =false
                    viewModel.fetchadd(activity!!)
                }
                handler.postDelayed(this,  180000)
            }
        }


        handler.postDelayed(runnable, 1000)












    // activity?.runOnUiThread {
    //


    //}






















        return binding.root
    }




}