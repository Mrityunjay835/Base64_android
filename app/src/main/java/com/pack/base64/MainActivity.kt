package com.pack.base64

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pack.base64.databinding.ActivityMainBinding
import java.util.Base64

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEncode.setOnClickListener {
            binding.tvInput.setText(binding.etEDInput.text.toString())
            binding.tvEncodedValue.setText(encode(binding.etEDInput.text.toString()))
        }
        binding.btnDecode.setOnClickListener {
            binding.tvInput.setText(binding.etEDInput.text.toString())
            binding.tvDecodedValue.setText(decode(binding.etEDInput.text.toString()))
        }

    }
    private fun encode(inputText:String):String{
        Log.i("Input :","$inputText")
        var res =String(
            Base64.getEncoder().encode(inputText.toByteArray())
        )
        Log.i("Encoded output : ","$res")
        return res
    }
    private fun decode(inputText: String):String{
//        Log.i("Input :","$inputText")

        var res = ""
        try{
           res = String(
                Base64.getDecoder().decode(inputText.toByteArray())
            )
            binding.tvDecodedValue.setTextColor(getColor(R.color.white))

        }catch (e: IllegalArgumentException){
            binding.tvDecodedValue.setTextColor(getColor(R.color.red))
            res = e.toString()
        }
        Log.i("Decoded output : ","$res")
        return res
    }

}