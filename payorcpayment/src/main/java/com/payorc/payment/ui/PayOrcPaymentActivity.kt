package com.payorc.payment.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.payorc.payment.App
import com.payorc.payment.R
import com.payorc.payment.databinding.ActivityPayOrcPaymentBinding
import com.payorc.payment.service.MyViewModelFactory

class PayOrcPaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPayOrcPaymentBinding

    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayOrcPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Access MyRepository from Application class
        val myRepository = (application as App).myRepository

        // Initialize ViewModel with MyRepository
        val viewModelFactory = MyViewModelFactory(myRepository)
        myViewModel = ViewModelProvider(this, viewModelFactory).get(MyViewModel::class.java)
        myViewModel.checkKeysSecret()
        myViewModel.data.observe(this) { data ->
            // Update UI with API data
            Log.e(
                "Reposnse",""+data
            )
        }

    }

}