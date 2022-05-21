package com.example.taskahmedali.presentation.baseActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.taskahmedali.R
import com.example.taskahmedali.databinding.ActivityBaseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaseActivity : AppCompatActivity() {

  lateinit var binding: ActivityBaseBinding
  lateinit var navController: NavController
  val viewModel: NewsViewModel by viewModel()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityBaseBinding.inflate(layoutInflater)
    setContentView(binding.root)
    val hostFragment =
      supportFragmentManager.findFragmentById(R.id.fHostContainer) as NavHostFragment
    navController = hostFragment.navController
    // new line
  }
}