package com.example.my_gpt_impl.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.my_gpt_impl.databinding.FragmentHomeBinding
import io.ktor.client.*
import com.example.my_gpt_impl.BuildConfig

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val sendButton: Button = binding.sendButton
        val inputText: EditText = binding.inputText
        sendButton.setOnClickListener {
            sendMessageToAI(inputText.text.toString())
        }
        return root
    }

    private fun sendMessageToAI(toString: String) {
        val key = BuildConfig.OPENAI_KEY

//        val openai = OpenAI(
//            token = "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",
//            timeout = Timeout(socket = 60.seconds),
//            // additional configurations...
//        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
