package com.meu.runningapp.di

import android.content.Context
import androidx.room.Room
import com.meu.runningapp.data.db.RunningDatabase
import com.meu.runningapp.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    //This annotation "Singleton" is to instance same database on different places on app.
    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db:RunningDatabase) = db.getRunDao()
}