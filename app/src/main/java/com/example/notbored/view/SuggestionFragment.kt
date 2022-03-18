package com.example.notbored.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notbored.databinding.FragmentSuggestionBinding

class SuggestionFragment : Fragment() {

    private lateinit var mBinding: FragmentSuggestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSuggestionBinding.inflate(inflater,container,false)
        return mBinding.root
    }

}