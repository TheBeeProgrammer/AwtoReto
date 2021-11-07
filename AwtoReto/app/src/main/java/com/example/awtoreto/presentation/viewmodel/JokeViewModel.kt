package com.example.awtoreto.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.awtoreto.domain.usecases.GetJokes
import io.reactivex.disposables.CompositeDisposable

class JokeViewModel @ViewModelInject constructor(
    private val getJokes: GetJokes, private val compositeDisposable: CompositeDisposable
) : ViewModel() {
}