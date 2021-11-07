package com.example.awtoreto.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.awtoreto.R
import com.example.awtoreto.core.DataNotFound
import com.example.awtoreto.core.Event
import com.example.awtoreto.databinding.ActivityJokeBinding
import com.example.awtoreto.presentation.model.JokeState
import com.example.awtoreto.presentation.viewmodel.JokeViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.HttpException
import java.io.IOException

@AndroidEntryPoint
class JokeActivity : AppCompatActivity() {

    private val viewModel: JokeViewModel by viewModels()
    private val binding get() = _binding!!
    private var _binding: ActivityJokeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AwtoReto)
        super.onCreate(savedInstanceState)
        _binding = ActivityJokeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeViewStateUpdates()
        listeners()
    }

    private fun observeViewStateUpdates() {
        viewModel.state.observe(this) {
            updateScreenState(it)
        }
    }

    private fun updateScreenState(jokeState: JokeState) {
        updateInitialStateViews(jokeState)
        handleFailures(jokeState.failure)
    }

    private fun updateInitialStateViews(jokeState: JokeState) {
        binding.tvDelivery.text = jokeState.joke?.delivery
        binding.tvJoke.text =
            if (jokeState.isAJokeState) jokeState.joke?.joke else jokeState.joke?.setup

        binding.tvFlag.text = viewModel.getFlag(jokeState.joke)
    }

    private fun handleFailures(failure: Event<Throwable>?) {
        val unhandledFailure = failure?.getContentIfNotHandled() ?: return
        handleThrowable(unhandledFailure)
    }

    private fun handleThrowable(exception: Throwable) {
        val fallbackMessage = "An error occurred. Please try again later."
        val snackbarMessage = when (exception) {
            is DataNotFound -> exception.message ?: fallbackMessage
            is IOException, is HttpException -> fallbackMessage
            else -> ""
        }

        if (snackbarMessage.isNotEmpty()) {
            Snackbar.make(
                findViewById(android.R.id.content),
                snackbarMessage,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun listeners() {
        binding.btnRefresh.setOnClickListener {
            binding.tvDelivery.text = ""
            binding.tvJoke.text = ""
            viewModel.onUpdateData()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}