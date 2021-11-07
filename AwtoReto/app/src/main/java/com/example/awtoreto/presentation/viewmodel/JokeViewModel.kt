package com.example.awtoreto.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.awtoreto.core.DataNotFound
import com.example.awtoreto.core.Event
import com.example.awtoreto.domain.model.Joke
import com.example.awtoreto.domain.usecases.GetJokes
import com.example.awtoreto.presentation.JokeFlags
import com.example.awtoreto.presentation.model.JokeState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Job

class JokeViewModel @ViewModelInject constructor(
    private val getJokes: GetJokes, private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    val state: LiveData<JokeState>
        get() = _state

    private val _state: MutableLiveData<JokeState> = MutableLiveData()

    private var runningJobs = mutableListOf<Job>()

    init {
        setUpJokeSubscription()
        _state.value = JokeState()
    }

    private fun setUpJokeSubscription() {
        getJokes().toObservable().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { runningJobs.map { it.cancel() } }
            .subscribe(
                { onJokesResults(it) },
                { onFailure(it) }
            )
            .addTo(compositeDisposable)
    }

    private fun onFailure(throwable: Throwable) {
        _state.value = if (throwable is DataNotFound) {
            state.value!!.copy(noResultsState = true)
        } else {
            state.value!!.copy(failure = Event(throwable))
        }
    }

    private fun onJokesResults(joke: Joke) {
        bindJoke(joke)
    }

    private fun bindJoke(joke: Joke) {
        _state.value = state.value!!.copy(
            joke = joke,
            isAJokeState = joke.type != JOKE_TYPE
        )
    }

    fun onUpdateData() {
        setUpJokeSubscription()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    companion object {
        const val JOKE_TYPE = "twopart"
    }

    fun getFlag(joke: Joke?): String {

        val builder = StringBuilder()

        if (joke?.flag?.religious == true) {
            builder.append(JokeFlags.RELIGIOUS.toString()).append(" ")
        }

        if (joke?.flag?.political == true) {
            builder.append(
                JokeFlags.POLITICAL.toString()
            ).append(" ")
        }
        if (joke?.flag?.racist == true) {
            builder.append(JokeFlags.RACIST.toString()).append(" ")
        }

        if (joke?.flag?.nsfw == true) {
            builder.append(JokeFlags.NSFW.toString()).append(" ")
        }

        if (joke?.flag?.explicit == true) {
            builder.append(JokeFlags.EXPLICIT.toString()).append(" ")
        }

        if (joke?.flag?.sexist == true) {
            builder.append(JokeFlags.SEXIST.toString()).append(" ")
        }

        if (builder.toString().isBlank()) {
            return JokeFlags.NONE.toString()
        }

        return builder.toString()
    }

}