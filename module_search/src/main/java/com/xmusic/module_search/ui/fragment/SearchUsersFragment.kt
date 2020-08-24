package com.xmusic.module_search.ui.fragment

import android.os.Bundle
import com.xmusic.module_search.adapter.BaseSearchAdapter
import com.xmusic.module_search.adapter.SearchUsersAdapter
import com.xw.lib_coremodel.database.entities.SearchType
import com.xw.lib_coremodel.model.bean.UserInfo

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc: 搜索结果：单曲
 */
class SearchUsersFragment : SearchResultVpFragment<UserInfo>() {

    override val adapter: BaseSearchAdapter<UserInfo> = SearchUsersAdapter()

    companion object {
        fun newInstance(searchType: SearchType): SearchUsersFragment {
            return SearchUsersFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(SEARCH_TYPE,searchType)
                }
            }
        }
    }
}