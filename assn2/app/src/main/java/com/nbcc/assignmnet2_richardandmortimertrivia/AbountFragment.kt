package com.nbcc.assignmnet2_richardandmortimertrivia


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.nbcc.assignmnet2_richardandmortimertrivia.databinding.FragmentAbountBinding
import com.nbcc.assignmnet2_richardandmortimertrivia.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class AbountFragment : Fragment() {

    private lateinit var binding: FragmentAbountBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_abount, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_abount,
            container,
            false
        )

        return binding.root
    }


}
