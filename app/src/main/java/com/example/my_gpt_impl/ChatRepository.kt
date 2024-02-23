package com.example.my_gpt_impl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aallam.openai.api.chat.ChatMessage
import javax.inject.Inject

class ChatRepository @Inject constructor() {
    private val currentChat: String = ""

    fun sendMessage(message: String) {
        // Voeg het bericht toe aan de chat en communiceer met OpenAI
        Log.d("repo", message)
    }

    fun getMessages(): LiveData<List<ChatMessage>> {
        return MutableLiveData<List<ChatMessage>>()
    }
}
