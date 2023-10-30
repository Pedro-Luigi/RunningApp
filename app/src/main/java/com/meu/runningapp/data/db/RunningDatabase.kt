package com.meu.runningapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.meu.runningapp.domain.Run

@Database(entities = [Run::class], version = 1)
@TypeConverters(Converters::class)
abstract class RunningDatabase : RoomDatabase() {
    abstract class getRunDao(): RunDao

}