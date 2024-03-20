package com.example.android4_1.presentation.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.android4_1.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel
@Inject constructor(
    private val repositories: MangaRepository,
) : ViewModel() {

    fun fetchManga() = repositories.fetchManga()
}