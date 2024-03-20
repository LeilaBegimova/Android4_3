package com.example.android4_1.presentation.ui.fragments

import com.example.android4_1.presentation.ui.viewModels.MangaViewModel
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4_1.R
import com.example.android4_1.databinding.FragmentMangaBinding
import com.example.android4_1.presentation.ui.adapter.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.fragment_manga) {

    private val binding by viewBinding(FragmentMangaBinding::bind)
    private val viewModel by viewModels<MangaViewModel>()
    private val mangaAdapter = MangaAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
        viewLifecycleOwner.lifecycleScope.launch {
            delay(3000)
            if (binding.progressBar.isVisible) {
                binding.progressBar.isVisible = false
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mangaAdapter.loadStateFlow.collect {
                }
            }
        }
    }

    private fun initialize() = with(binding) {
        recyclerView.apply {
            adapter = mangaAdapter
        }
    }

    private fun setupObserver() {

        viewModel.fetchManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }
}