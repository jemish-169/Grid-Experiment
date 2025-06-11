package com.example.gridexp.di

import com.example.gridexp.features.grid.presentation.viewmodel.GridViewModel
import com.example.gridexp.features.grid.presentation.viewmodel.IGridViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface ViewModelModules {
    @Binds
    fun bindGridViewModel(
        impl: GridViewModel
    ): IGridViewModel
}
