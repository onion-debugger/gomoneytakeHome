package com.example.gomoneytakehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.gomoneytakehome.databinding.ActivityMainBinding
import com.example.gomoneytakehome.local.FootballDatabase
import com.example.gomoneytakehome.ui.viewmodels.CompetitionVM
import com.example.gomoneytakehome.ui.viewmodels.VMFactory
import com.example.gomoneytakehome.util.NetworkResult

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CompetitionVM
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setSupportActionBar(binding!!.toolbar)

        val application = this.application
        val dao = FootballDatabase.getInstance(application).competitionDao

        viewModel = ViewModelProvider(this, VMFactory(dao))[CompetitionVM::class.java]

        requestCompetitionData()

    }

    private fun requestCompetitionData() {
        viewModel.response.observe(this) {
            it?.let { response ->
                when (response) {
                    is NetworkResult.Success -> {
                        response.data.let { result ->
                            Toast.makeText(this, "${result.competitions}", Toast.LENGTH_LONG).show()
                        }
                    }

                    is NetworkResult.Error -> {
                        Toast.makeText(this, "${response.message}", Toast.LENGTH_LONG).show()
                    }

                    is NetworkResult.Exception -> {

                    }
            }
        }

    } }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}