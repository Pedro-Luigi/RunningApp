package com.meu.runningapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.meu.runningapp.data.repositories.MainRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
):ViewModel() {

}