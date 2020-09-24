package com.xw.lib_coremodel.model.bean.home

import com.xw.lib_coremodel.database.entities.PlayListCat
import com.xw.lib_coremodel.model.bean.BaseHttpResponse

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
data class PlayListCatListResponse(
    val sub: List<PlayListCat>,
    val categories: Map<Int, String>
) : BaseHttpResponse()