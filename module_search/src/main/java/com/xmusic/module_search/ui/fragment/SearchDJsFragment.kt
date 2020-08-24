package com.xmusic.module_search.ui.fragment

import android.os.Bundle
import com.xmusic.module_search.adapter.BaseSearchAdapter
import com.xmusic.module_search.adapter.SearchDJsAdapter
import com.xw.lib_coremodel.database.entities.SearchType
import com.xw.lib_coremodel.model.bean.dj.DjRadioInfo

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc: 搜索结果：单曲
 */
class SearchDJsFragment : SearchResultVpFragment<DjRadioInfo>() {

    override val adapter: BaseSearchAdapter<DjRadioInfo> = SearchDJsAdapter()

    companion object {
        fun newInstance(searchType: SearchType): SearchDJsFragment {
            return SearchDJsFragment().apply {
                arguments = Bundle().apply { putSerializable(SEARCH_TYPE, searchType) }
            }
        }
    }
}