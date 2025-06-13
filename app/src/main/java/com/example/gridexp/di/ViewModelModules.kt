package com.example.gridexp.di

import com.example.gridexp.features.grid.presentation.viewmodel.GridViewModel
import com.example.gridexp.features.grid.presentation.viewmodel.IGridViewModel
import com.example.gridexp.features.history.presentation.viewmodel.HistoryViewModel
import com.example.gridexp.features.history.presentation.viewmodel.IHistoryViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface GridViewModelModule {
    @Binds
    fun bindGridViewModel(
        impl: GridViewModel
    ): IGridViewModel


}

@Module
@InstallIn(ViewModelComponent::class)
interface HistoryViewModelModule {
    @Binds
    fun bindGridViewModel(
        impl: HistoryViewModel
    ): IHistoryViewModel
}
