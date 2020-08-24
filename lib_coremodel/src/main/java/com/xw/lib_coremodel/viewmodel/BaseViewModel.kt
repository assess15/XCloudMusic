package com.xw.lib_coremodel.viewmodel

import androidx.lifecycle.*
import com.orhanobut.logger.Logger
import com.xw.lib_coremodel.data.LoginUserInfo
import com.xw.lib_coremodel.model.bean.BaseHttpResponse
import com.xw.lib_coremodel.model.repository.BaseRepository
import kotlinx.coroutines.*

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
open class BaseViewModel(val baseRepository: BaseRepository? = null) : ViewModel() {

    val mException: MutableLiveData<Throwable> = MutableLiveData()

    private val loginUser = baseRepository?.getLoginUser()

    open suspend fun executeResponse(
        response: BaseHttpResponse, successBlock: suspend CoroutineScope.() -> Unit,
        errorBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            if (response.isSuccess()) {
                successBlock()
            } else {
                Logger.e("code = ${response.code}  msg = ${response.getResponseMsg()}")
                errorBlock()
            }
        }
    }

    fun loginUser(owner: LifecycleOwner, observer: Observer<LoginUserInfo?>) {
        this.loginUser!!.observe(owner, observer)
    }

    private fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }

    fun launch(tryBlock: suspend CoroutineScope.() -> Unit) {
        launchOnUI {
            tryCatch(tryBlock)
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                tryBlock()
            } catch (e: Throwable) {
                Logger.e(e.toString())
                if (e !is CancellationException) {
                    mException.value = e
                }
            }
        }
    }
}