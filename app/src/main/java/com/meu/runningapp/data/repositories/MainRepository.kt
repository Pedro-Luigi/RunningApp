package com.meu.runningapp.data.repositories

import com.meu.runningapp.data.db.RunDao
import com.meu.runningapp.domain.FilterRunBy
import com.meu.runningapp.domain.FilterSumTotalBy
import com.meu.runningapp.domain.Run
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedBy(filter: FilterRunBy) = runDao.getAllRunsSortedBy(filter)

    fun getSumTotalBy(filter: FilterSumTotalBy) = runDao.getSumTotalBy(filter)
}