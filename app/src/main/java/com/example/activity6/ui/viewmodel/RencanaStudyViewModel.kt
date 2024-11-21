package com.example.activity6.ui.viewmodel

import com.example.activity6.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RencanaStudyViewModel() {
    private  val _krsState = MutableStateFlow(RencanaStudi())
    val krsStudi: StateFlow<RencanaStudi> = _krsState.asStateFlow()

}