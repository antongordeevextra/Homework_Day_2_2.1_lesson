package com.example.homework21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homework21.MainActivity.Companion.EXTRA_MESSAGE
import com.example.homework21.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val LOG_TAG = SecondActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")

        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        binding.textMessage.text = message

    }

    fun returnReply(view: android.view.View) {
        val replyIntent = Intent()
        val reply = binding.editTextSecond.text.toString()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "End SecondActivity")
        finish()
    }

    companion object {
        const val EXTRA_REPLY = "extra_reply"
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