package com.xw.xmusic

import android.util.Log
import com.xw.lib_common.R
import com.xw.lib_common.ext.getString
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun tes() {
        Log.d(
            "aa", getString(
                R.string.data_error_playing_track,
                "ddd"
            )
        )
    }

}