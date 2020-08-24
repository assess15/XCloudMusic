package com.xmusic.module_search.ui.fragment

import android.os.Bundle
import com.xmusic.module_search.adapter.BaseSearchAdapter
import com.xmusic.module_search.adapter.SearchSongsAdapter
import com.xw.lib_coremodel.database.entities.SearchType
import com.xw.lib_coremodel.model.bean.Song

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc: 搜索结果：单曲
 */
class SearchSongsFragment : SearchResultVpFragment<Song>() {

    override val adapter: BaseSearchAdapter<Song>  =  SearchSongsAdapter()

    companion object {
        fun newInstance(searchType: SearchType): SearchSongsFragment {
            return SearchSongsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(SEARCH_TYPE,searchType)
                }
            }
        }
    }
}