package com.example.mvvmrecipeapp.di

import android.content.Context
import com.example.mvvmrecipeapp.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication{
        return app as BaseApplication
    }
}