package com.xw.lib_common.view.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import com.orhanobut.logger.Logger
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.xw.lib_common.R

/**
 * @author: xingwei
 * @email: 654206017@qq.com
 *
 * Desc:
 */
class MusicRefreshLayout(context: Context, attrs: AttributeSet?) :
    SmartRefreshLayout(context, attrs) {

    init {
        if (attrs != null) {
            val typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.MusicRefreshLayout)
            try {
                val needHeader =
                    typedArray.getBoolean(R.styleable.MusicRefreshLayout_needHeader, false)
                if (needHeader) {
                    val layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    val headerView =
                        com.xw.lib_common.view.recyclerview.MusicRefreshHeaderView(
                            context
                        )
                    headerView.layoutParams = layoutParams
                    addView(headerView, 0)
                }
            } catch (e: Exception) {
                Logger.e(e.localizedMessage)
            } finally {
                typedArray.recycle()
            }
        }
    }

}