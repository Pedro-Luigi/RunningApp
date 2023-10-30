package com.meu.runningapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meu.runningapp.domain.FilterRunBy
import com.meu.runningapp.domain.FilterSumTotalBy
import com.meu.runningapp.domain.Run
import kotlinx.coroutines.DelicateCoroutinesApi

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY :filter DESC")
    fun getAllRunsSortedBy(filter:FilterRunBy): LiveData<List<Run>>

    @Query("SELECT SUM(:filter) FROM running_table")
    fun getSumTotal(filter: FilterSumTotalBy): LiveData<Any>
}