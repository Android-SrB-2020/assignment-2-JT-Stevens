package com.nbcc.assignmnet2_richardandmortimertrivia


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.nbcc.assignmnet2_richardandmortimertrivia.databinding.FragmentMainBinding
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.navigation.ui.NavigationUI

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

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            navController
        ) || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()

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

        binding.question = questionBank[questionIndex]

        binding.apply {
            cheatBtn.setOnClickListener{
                navController.navigate(MainFragmentDirections.actionMainFragmentToCheatFragment(question!!))
            }

            nextButton.setOnClickListener{
                nextQuestion()
            }

            previousButton.setOnClickListener{
                previousQuestion()
            }

            trueButton.setOnClickListener{
                isTrue()
            }

            falseButton.setOnClickListener{
                isFalse()
            }
        }
    }

    /**
     * Changes the text view to the next question.
     */
    private fun nextQuestion(){
        binding.apply {
            questionIndex++
            question = questionBank[questionIndex % questionBank.count()]
        }
    }

    /**
     * Changes the tet view to the previous question
     */
    private fun previousQuestion(){
        binding.apply {
            questionIndex += 19
            question = questionBank[questionIndex % questionBank.count()]
        }
    }

    /**
     * Shows a Correct or Wrong toast if the answer to the current question is true.
     */
    private fun isTrue(){
        if (question.answer){
            Toast.makeText(activity, "Correct!", LENGTH_SHORT).show()
        } else{
            Toast.makeText(activity, "Wrong!", LENGTH_SHORT).show()
        }
    }

    /**
     * Shows a Correct or Wrong toast if the answer to the current question is false.
     */
    private fun isFalse(){
        if (!question.answer){
            Toast.makeText(activity, "Correct!", LENGTH_SHORT).show()

        } else{
            Toast.makeText(activity, "Wrong!", LENGTH_SHORT).show()
        }
    }
}
