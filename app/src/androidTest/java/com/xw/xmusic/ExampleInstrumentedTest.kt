package com.xw.xmusic

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.xw.lib_common.R
import com.xw.lib_common.ext.getString
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun te(){
        Log.d("aa", getString(
            R.string.data_error_playing_track,
            "ddd"
        ))
    }
}