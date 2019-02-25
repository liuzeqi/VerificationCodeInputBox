package com.liuzq.library

import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * <pre>
 *      @author liuZQ
 *      @date 2019/2/25 12:47 PM
 * </pre>
 */
class VerificationCodeInputBox : RelativeLayout {

    private lateinit var mEditText: EditText

    var mTextViewList: MutableList<TextView> = mutableListOf()

    lateinit var mOnInputCompleteListener: (String) -> Unit

    constructor(context : Context) : this(context, null)

    constructor(context: Context, attributeSet: AttributeSet?) :super(context, attributeSet){

        val view = View.inflate(context, R.layout.view_input_box, this)
        init(view)
    }

    private fun init(view: View) {

        mEditText = view.findViewById(R.id.edit_text)

        mTextViewList.add(view.findViewById(R.id.tv_1))
        mTextViewList.add(view.findViewById(R.id.tv_2))
        mTextViewList.add(view.findViewById(R.id.tv_3))
        mTextViewList.add(view.findViewById(R.id.tv_4))
        mTextViewList.add(view.findViewById(R.id.tv_5))
        mTextViewList.add(view.findViewById(R.id.tv_6))

        mEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val inputLength: Int = s!!.length
                if (inputLength == 6) {
                    mTextViewList[inputLength - 1].text = s[inputLength - 1].toString()
                    mOnInputCompleteListener.invoke(s.toString())
                } else {
                    if (!TextUtils.isEmpty(mTextViewList[inputLength].text)) {
                        mTextViewList[inputLength].text = ""
                        mTextViewList[inputLength].setBackgroundResource(R.drawable.bg_input_box_selected)
                        if (inputLength < 5)
                        mTextViewList[inputLength + 1].setBackgroundResource(R.drawable.bg_input_box)
                    } else {
                        mTextViewList[inputLength - 1].text = s[inputLength - 1].toString()
                        mTextViewList[inputLength - 1].setBackgroundResource(R.drawable.bg_input_box)
                        mTextViewList[inputLength].setBackgroundResource(R.drawable.bg_input_box_selected)
                    }
                }
            }

        })
    }

    fun setOnInputCompleteListener(listener: (String) -> Unit){
        this.mOnInputCompleteListener = listener
    }
}