package com.example.my_gpt_impl.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.my_gpt_impl.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var vm: HomeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vm = ViewModelProvider(this)[HomeViewModel::class.java]
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
        vm?.sendMessage("hi")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
