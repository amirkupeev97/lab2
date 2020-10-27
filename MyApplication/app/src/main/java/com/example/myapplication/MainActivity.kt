package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener { SetTextField("0") }
        btn_1.setOnClickListener { SetTextField("1") }
        btn_2.setOnClickListener { SetTextField("2") }
        btn_3.setOnClickListener { SetTextField("3") }
        btn_4.setOnClickListener { SetTextField("4") }
        btn_5.setOnClickListener { SetTextField("5") }
        btn_6.setOnClickListener { SetTextField("6") }
        btn_7.setOnClickListener { SetTextField("7") }
        btn_8.setOnClickListener { SetTextField("8") }
        btn_9.setOnClickListener { SetTextField("9") }
        btn_plus.setOnClickListener { SetTextField("+") }
        btn_min.setOnClickListener { SetTextField("-") }
        btn_x.setOnClickListener { SetTextField("*") }
        btn_div.setOnClickListener { SetTextField("/") }
        btn_perc.setOnClickListener { SetTextField("%") }
        btn_clear.setOnClickListener { math_operation.text=""
            result.text=""}
        btn_back.setOnClickListener { val str = math_operation.text.toString()
        if(str.isNotEmpty()){math_operation.text=str.substring(0, str.length-1)}}
        btn_eq.setOnClickListener {
            try {
             val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val endresult = ex.evaluate()
               result.text =endresult.toString()
            }
            catch (e:Exception) {
                Log.d("Error" , "${e.message}")
            }
        }


    }
    fun SetTextField(str:String) {
        math_operation.append(str)


    }
}