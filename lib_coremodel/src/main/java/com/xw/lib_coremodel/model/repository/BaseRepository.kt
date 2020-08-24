package com.xw.lib_coremodel.model.repository

import android.content.Context
import com.xw.lib_coremodel.database.AppDatabaseBuilder
import com.xw.lib_coremodel.model.bean.BaseHttpResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
open class BaseRepository(val context: Context) {

    protected val loginUserDao by lazy {
        AppDatabaseBuilder.getInstance(context).loginUserDao()
    }

    @Suppress("UNCHECKED_CAST")
    suspend fun <T : Any> apiCall(call: suspend () -> BaseHttpResponse): T {
        return call.invoke() as T
    }

    fun getLoginUser() = loginUserDao.getLoginUser()

    suspend fun launch(block: suspend CoroutineScope.() -> Unit) {
        withContext(Dispatchers.IO) { block() }
    }

}