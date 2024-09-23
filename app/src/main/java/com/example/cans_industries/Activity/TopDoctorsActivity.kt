package com.example.cans_industries.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cans_industries.Adapter.TopDoctorAdapter
import com.example.cans_industries.Adapter.TopDoctorAdapter2
import com.example.cans_industries.R
import com.example.cans_industries.ViewModel.MainViewModel
import com.example.cans_industries.databinding.ActivityMainBinding
import com.example.cans_industries.databinding.ActivityTopDoctorsBinding

class TopDoctorsActivity : BaseActivity() {
    private lateinit var binding:ActivityTopDoctorsBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTopDoctorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTopDoctors()

    }

    private fun initTopDoctors() {
        binding.apply {
            progressBarTopDoctor.visibility = View.VISIBLE
            viewModel.doctors.observe(this@TopDoctorsActivity, Observer {
                viewTopDoctorList.layoutManager = LinearLayoutManager(this@TopDoctorsActivity,
                    LinearLayoutManager.VERTICAL,false)
                viewTopDoctorList.adapter = TopDoctorAdapter2(it)
                progressBarTopDoctor.visibility = View.GONE
            })
            viewModel.loadDoctors()

            backBtn.setOnClickListener { finish() }
        }
    }
}