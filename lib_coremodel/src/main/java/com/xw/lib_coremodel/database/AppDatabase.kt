package com.xw.lib_coremodel.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xw.lib_coremodel.database.dao.*
import com.xw.lib_coremodel.database.entities.*
import com.xw.lib_coremodel.model.bean.home.PlayListCat

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
@Database(
    entities = [PlaybackList::class, PlaybackHistory::class, RecentHistory::class,
        SongLrc::class, LoginUserInfo::class, PlayListCat::class, SearchHistory::class,
        SearchType::class],
    version = 6,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playbackListDao(): PlaybackListDao
    abstract fun playbackHistoryDao(): PlaybackHistoryDao
    abstract fun recentDao(): RecentHistoryDao
    abstract fun urlAndLrc(): SongUrlAndLrcDao
    abstract fun loginUserDao(): LoginUserInfoDao
    abstract fun myPlayListCatDao(): MyPlayListCatDao
    abstract fun searchHistoryDao(): SearchHistoryDao
    abstract fun searchTypeDao(): SearchTypeDao
}