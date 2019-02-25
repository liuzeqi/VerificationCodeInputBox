package com.liuzq.library

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText

/**
 * <pre>
 *      屏蔽EditText的长按事件
 *      @author liuZQ
 *      @date 2019/2/25 4:02 PM
 * </pre>
 */
class MyEditText : EditText {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)

    override fun performLongClick(): Boolean {
        return false
    }

}