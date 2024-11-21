package com.example.activity6.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.activity6.model.Mahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MahasiswaViewModel : ViewModel() {
    private val mahasiswaStateUI = MutableStateFlow(Mahasiswa())

    val mahasiswaState: StateFlow<Mahasiswa> = mahasiswaStateUI.asStateFlow()
    fun saveDataMahasiswa(ls: MutableList<String>){
        mahasiswaStateUI.value = Mahasiswa(
            nim = ls[0],
            nama = ls[1],
            email = ls[2]


        )

    }

}