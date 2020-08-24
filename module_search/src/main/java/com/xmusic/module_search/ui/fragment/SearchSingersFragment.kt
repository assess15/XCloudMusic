package com.xmusic.module_search.ui.fragment

import android.os.Bundle
import com.xmusic.module_search.adapter.BaseSearchAdapter
import com.xmusic.module_search.adapter.SearchSingersAdapter
import com.xw.lib_coremodel.database.entities.SearchType
import com.xw.lib_coremodel.model.bean.home.ArtistInfo

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc: 搜索结果：单曲
 */
class SearchSingersFragment : SearchResultVpFragment<ArtistInfo>() {

    override val adapter: BaseSearchAdapter<ArtistInfo> = SearchSingersAdapter()

    companion object {
        fun newInstance(searchType: SearchType): SearchSingersFragment {
            return SearchSingersFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(SEARCH_TYPE,searchType)
                }
            }
        }
    }
}