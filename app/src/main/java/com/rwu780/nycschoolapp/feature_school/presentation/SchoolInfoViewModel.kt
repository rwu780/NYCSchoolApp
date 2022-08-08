package com.rwu780.nycschoolapp.feature_school.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rwu780.nycschoolapp.Screen
import com.rwu780.nycschoolapp.feature_school.data.local.model.SchoolEntity
import com.rwu780.nycschoolapp.feature_school.domain.usecases.GetSchoolWithDbn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSchoolWithDbn: GetSchoolWithDbn
) : ViewModel() {

    var schoolInfo by mutableStateOf<SchoolEntity?>(null)
        private set

    init {
        val dbn = savedStateHandle.get<String>("dbn")!!
        if (dbn.isNotEmpty()){
            viewModelScope.launch {
                getSchoolWithDbn(dbn)?.let {
                    schoolInfo = it
                }
            }
        }
    }
}