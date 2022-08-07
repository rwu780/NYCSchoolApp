package com.rwu780.nycschoolapp.feature_school.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rwu780.nycschoolapp.feature_school.domain.model.SAT
import com.rwu780.nycschoolapp.feature_school.domain.usecases.GetSATList
import com.rwu780.nycschoolapp.feature_school.domain.usecases.InsertSATList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SATViewModel @Inject constructor(
    private val getSATList: GetSATList,
    private val insertSATList: InsertSATList
) : ViewModel() {

    private val _state = mutableStateOf<List<SAT>>(emptyList())
    val state: State<List<SAT>> = _state

    private var getSATJob: Job? = null

    init {

        viewModelScope.launch {
            insertSATList()
        }
        getSAT("")

    }

    private fun getSAT(keyword: String) {
        getSATJob?.cancel()

        getSATJob = getSATList(keyword).onEach { SATs ->
            _state.value = SATs


        }.launchIn(viewModelScope)
    }

}