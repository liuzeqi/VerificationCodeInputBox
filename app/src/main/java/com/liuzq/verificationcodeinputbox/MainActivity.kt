package com.liuzq.verificationcodeinputbox

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.liuzq.library.VerificationCodeInputBox

class MainActivity : AppCompatActivity() {

    lateinit var inputBox: VerificationCodeInputBox
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        inputBox = findViewById(R.id.input_box)

        inputBox.setOnInputCompleteListener { string -> Toast.makeText(context, "输入的验证码为：$string", Toast.LENGTH_SHORT).show() }
    }
}
