package com.xw.lib_coremodel.database.dao

import androidx.room.*
import com.xw.lib_coremodel.database.entities.RecentHistory

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
@Dao
interface RecentHistoryDao {
    @Query("SELECT * FROM recent_history WHERE songId = :songId")
    fun getRecentSong(songId: Long): RecentHistory?

    @Query("SELECT * FROM recent_history")
    fun getAllRecent(): List<RecentHistory>

    @Insert
    fun insertSong(recentHistory: RecentHistory)

    @Update
    fun updateRecent(recentHistory: RecentHistory)

    @Delete
    fun deleteRecent(recentHistory: RecentHistory)

    @Delete
    fun deleteAll(recentHistory: List<RecentHistory>)
}