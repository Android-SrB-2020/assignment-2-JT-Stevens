package com.nbcc.assignmnet2_richardandmortimertrivia


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.nbcc.assignmnet2_richardandmortimertrivia.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    private var questionIndex = 0
    private lateinit var question : Question

    private lateinit var questionBank: List<Question>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

        binding.apply {
            cheatBtn.setOnClickListener{
                navController.navigate(R.id.action_mainFragment_to_cheatFragment)
            }
        }

        questionBank = listOf(
            Question(getString(R.string.question_1), false),
            Question(getString(R.string.question_2), true),
            Question(getString(R.string.question_3), true),
            Question(getString(R.string.question_4), false),
            Question(getString(R.string.question_5), false),
            Question(getString(R.string.question_6), true),
            Question(getString(R.string.question_7), false),
            Question(getString(R.string.question_8), true),
            Question(getString(R.string.question_9), false),
            Question(getString(R.string.question_10), false),
            Question(getString(R.string.question_11), false),
            Question(getString(R.string.question_12), true),
            Question(getString(R.string.question_13), false),
            Question(getString(R.string.question_14), true),
            Question(getString(R.string.question_15), false),
            Question(getString(R.string.question_16), false),
            Question(getString(R.string.question_17), true),
            Question(getString(R.string.question_18), false),
            Question(getString(R.string.question_19), false),
            Question(getString(R.string.question_20), true)
        )

        question = questionBank[questionIndex]

    }


}
