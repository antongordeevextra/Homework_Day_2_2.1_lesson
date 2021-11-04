package com.example.homework21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.example.homework21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if(savedInstanceState != null){
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if(isVisible){
                binding.textHeaderReply.visibility = View.VISIBLE
                binding.textMessageReply.text = savedInstanceState.getString("reply_text")
                binding.textMessageReply.visibility = View.VISIBLE

            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(binding.textHeaderReply.visibility == View.VISIBLE){
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", binding.textMessageReply.text.toString())

        }
    }

    fun launchSecondActivity(view: android.view.View) {
        Log.d(LOG_TAG, "Button clicked!")

        val intent = Intent(this, SecondActivity::class.java)
        val text = binding.editTextMain.text.toString()
        intent.putExtra(EXTRA_MESSAGE, text)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                val replyMessage = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                binding.textHeaderReply.visibility = View.VISIBLE
                binding.textMessageReply.text = replyMessage
                binding.textMessageReply.visibility = View.VISIBLE

            }
        }
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
        const val TEXT_REQUEST = 1

    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")

    }
}