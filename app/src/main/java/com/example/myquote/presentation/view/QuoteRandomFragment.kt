package com.example.myquote.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.myquote.databinding.FragmentQuoteRandomBinding
import com.example.myquote.presentation.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteRandomFragment : Fragment() {
    //private val quoteViewModel: QuoteViewModel by viewModels()
    private var binding: FragmentQuoteRandomBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuoteRandomBinding.inflate(inflater, container, false)
        val quoteViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)
        quoteViewModel.randomQuote()
        quoteViewModel.viewModelScope.launch {
            quoteViewModel.quoteModel.collect {
                binding!!.tvQuote.text = it.quote
                binding!!.tvAuthor.text= it.author
            }
        }
        //quoteViewModel.randomQuote()
        //observer(quoteViewModel)
        binding?.viewContainer?.setOnClickListener {
            quoteViewModel.randomQuote()
        }

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*this.quoteViewModel.randomQuote()
        observer(quoteViewModel)
        binding?.viewContainer?.setOnClickListener {
            quoteViewModel.randomQuote()
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun observer(quoteViewModel: QuoteViewModel) {
        lifecycleScope.launch {
            quoteViewModel.quoteModel.collect {
                binding!!.tvQuote.text = it.quote
                binding!!.tvAuthor.text= it.author
            }
        }
    }
}