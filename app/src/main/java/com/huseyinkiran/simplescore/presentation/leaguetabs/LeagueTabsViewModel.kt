package com.huseyinkiran.simplescore.presentation.leaguetabs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LeagueTabsViewModel @Inject constructor() : ViewModel() {

    var selectedTabIndex by mutableIntStateOf(0)
        private set

    fun selectTab(index: Int) {
        selectedTabIndex = index
    }
}