package com.nbcc.assignmnet2_richardandmortimertrivia


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.nbcc.assignmnet2_richardandmortimertrivia.databinding.FragmentCheatBinding
import com.nbcc.assignmnet2_richardandmortimertrivia.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 */
class CheatFragment : Fragment() {

    private lateinit var binding: FragmentCheatBinding
    private lateinit var navController: NavController
    private lateinit var question: Question


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_cheat, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_cheat,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        var args = CheatFragmentArgs.fromBundle(arguments!!)
        binding.question = args.question


        binding.showAnswer = false


        binding.apply {
            cancelBtn.setOnClickListener {
                activity!!.onBackPressed()
            }

            cheatBtn.setOnClickListener {
                binding.showAnswer = true
            }
        }
    }


}
