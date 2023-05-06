package com.jason.catalarm.ui.home

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jason.catalarm.R
import com.jason.catalarm.databinding.ActivityAddClockBinding
import java.util.*

class AddClockActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddClockBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_clock)
        binding = ActivityAddClockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "add clock"

        val timePicker = binding.tpAddClock
        val btn = binding.btnConfirm
        btn.setOnClickListener{
//            Toast.makeText(this, "选择时间是：" + timePicker.hour + timePicker.minute, 3000).show()
            addClock(timePicker.hour, timePicker.minute)
        }

    }

    private fun addClock(hour: Int, minute: Int) {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR, hour)
        calendar.set(Calendar.MINUTE, minute)
        val intent = Intent()
        val pi: PendingIntent = PendingIntent.getActivity(this, 1000, intent,0)
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pi)
    }

}