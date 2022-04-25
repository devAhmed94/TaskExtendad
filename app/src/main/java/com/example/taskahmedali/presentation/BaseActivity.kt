package com.example.taskahmedali.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.taskahmedali.R
import com.example.taskahmedali.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

  lateinit var binding: ActivityBaseBinding
  lateinit var navController: NavController
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityBaseBinding.inflate(layoutInflater)
    setContentView(binding.root)
    val hostFragment =
      supportFragmentManager.findFragmentById(R.id.fHostContainer) as NavHostFragment
    navController = hostFragment.navController


  }
}