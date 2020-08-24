package com.xw.lib_coremodel.viewmodel.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.xw.lib_coremodel.ext.isLogined
import com.xw.lib_coremodel.model.bean.home.AlbumsAndSongs
import com.xw.lib_coremodel.model.bean.home.Banner
import com.xw.lib_coremodel.model.bean.home.HomeMoreItem
import com.xw.lib_coremodel.model.repository.home.HomeRepository
import com.xw.lib_coremodel.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class HomeViewModel internal constructor(private val homeRepository: HomeRepository) :
    BaseViewModel(homeRepository) {

    companion object {
        const val TYPE_TITLE = 100
        const val TYPE_PLAY_LIST = 101
        const val TYPE_TITLE_ALBUM_SONG = 102
    }

    private val mBanners: MutableLiveData<List<Banner>> = MutableLiveData()
    private val mHomeMoreData: MutableLiveData<List<HomeMoreItem>> = MutableLiveData()

    fun banner(owner: LifecycleOwner, observer: Observer<List<Banner>>) {
        this.mBanners.observe(owner, observer)
    }

    fun moreData(owner: LifecycleOwner, observer: Observer<List<HomeMoreItem>>) {
        this.mHomeMoreData.observe(owner, observer)
    }

    fun getBanners() {
        launch {
            val data = homeRepository.getBanners("1")
            executeResponse(data, { mBanners.postValue(data.banners) }, {})
        }
    }

    fun getHomePlayList() {
        launch {
            val list = mutableListOf<HomeMoreItem>()
            list.add(HomeMoreItem(TYPE_TITLE, id = "-1"))

            val data = if (isLogined()) {
                withContext(Dispatchers.IO) { homeRepository.getHomeRecommendPlayListLogin() }.apply {
                    recommend?.subList(0, if (recommend.size >= 6) 6 else recommend.size)
                        ?.forEach {
                            list.add(
                                HomeMoreItem(
                                    TYPE_PLAY_LIST,
                                    playListSimpleInfo = it,
                                    id = it.id
                                )
                            )
                        }
                }
            } else {
                withContext(Dispatchers.IO) { homeRepository.getHomeRecommendPlayList() }.apply {
                    result?.forEach { listSimpleInfo ->
                        list.add(
                            HomeMoreItem(
                                TYPE_PLAY_LIST,
                                playListSimpleInfo = listSimpleInfo,
                                id = listSimpleInfo.id
                            )
                        )
                    }
                }
            }

            val albumListData =
                withContext(Dispatchers.IO) { homeRepository.getHomeRecommendAlbum(0, 3) }

            val newSongData =
                withContext(Dispatchers.IO) { homeRepository.getNewSongRecommend() }

            list.add(
                HomeMoreItem(
                    TYPE_TITLE_ALBUM_SONG,
                    albumAndSong = AlbumsAndSongs(albumListData.albums, newSongData.result),
                    id = "-2"
                )
            )

            executeResponse(data, { mHomeMoreData.postValue(list) }, {})
        }
    }
}