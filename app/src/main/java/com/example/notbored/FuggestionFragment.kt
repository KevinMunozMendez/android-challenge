package com.example.notbored

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notbored.databinding.FragmentFuggestionBinding

class FuggestionFragment : Fragment() {

    private lateinit var mBinding: FragmentFuggestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentFuggestionBinding.inflate(inflater,container,false)
        return mBinding.root
    }

}