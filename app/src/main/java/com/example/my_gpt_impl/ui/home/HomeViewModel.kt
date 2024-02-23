package com.example.my_gpt_impl.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aallam.openai.api.chat.ChatMessage
import com.example.my_gpt_impl.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val chatRepository: ChatRepository)
    : ViewModel() {

    fun sendMessage(messageText: String) {
        chatRepository.sendMessage(messageText)
    }

    val messages: LiveData<List<ChatMessage>> = chatRepository.getMessages()
}
