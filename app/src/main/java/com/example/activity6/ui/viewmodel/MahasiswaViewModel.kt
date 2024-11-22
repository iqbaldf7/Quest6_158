package com.example.praktikum6.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class Mahasiswa(
    val nim: String = "",
    val nama: String = "",
    val email: String = ""
)


class MahasiswaViewModel : ViewModel() {
    private val _mhsState = MutableStateFlow(Mahasiswa())
    val mhsStateUi: StateFlow<Mahasiswa> = _mhsState.asStateFlow()

    fun setNim(inputNim: String) {
        _mhsState.update { state ->
            state.copy(nim = inputNim)
        }
    }


    fun setNama(inputNama: String) {
        _mhsState.update { state ->
            state.copy(nama = inputNama)
        }
    }


    fun setEmail(inputEmail: String) {
        _mhsState.update { state ->
            state.copy(email = inputEmail)
        }
    }


    fun saveDataMhs(ls: MutableList<String>) {
        if (ls.size >= 3) { // Validasi panjang list
            _mhsState.update { state ->
                state.copy(
                    nim = ls[0],
                    nama = ls[1],
                    email = ls[2]
                )
            }

        } else {
            throw IllegalArgumentException("List must have at least 3 elements")
        }
    }
}

