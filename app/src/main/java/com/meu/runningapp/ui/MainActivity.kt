package com.meu.runningapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.meu.runningapp.R
import com.meu.runningapp.data.db.RunDao
import com.meu.runningapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    @Inject
    lateinit var runDao: RunDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("runDao", "RUNDAO : ${runDao.hashCode()}")
    }
}