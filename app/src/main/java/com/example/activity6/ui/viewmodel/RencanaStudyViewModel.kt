package com.example.praktikum6.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class RencanaStudi(
    val namaMK: String = "",
    val kelas: String = ""
)


class RencanaStudyViewModel : ViewModel() {
    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsStateUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String) {
        _krsState.update { stateMK -> stateMK.copy(namaMK = mkPilihan) }
    }

    fun setKelas(kelasPilihan: String) {
        _krsState.update { stateKelas -> stateKelas.copy(kelas = kelasPilihan) }
    }


    fun saveDataKRS(ls: MutableList<String>) {
        if (ls.size >= 2) {
            _krsState.update { status ->
                status.copy(
                    namaMK = ls[0],
                    kelas = ls[1]
                )
            }
        } else {
            throw IllegalArgumentException("List must contain at least 2 elements")
        }
    }
}

