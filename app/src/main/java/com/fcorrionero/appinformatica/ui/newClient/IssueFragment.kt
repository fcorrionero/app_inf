package com.fcorrionero.appinformatica.ui.newClient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fcorrionero.appinformatica.R
import com.fcorrionero.appinformatica.databinding.FragmentIssueBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [IssueFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IssueFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentIssueBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIssueBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnIssueNext.setOnClickListener {
            val view = this@IssueFragment.view
            val issueType = view?.findViewById<EditText>(R.id.editTextIssueType)?.text.toString()
            val issueSolution = view?.findViewById<EditText>(R.id.editTextIssueSolution)?.text.toString()
            val issueObservations = view?.findViewById<EditText>(R.id.editTextIssueObservations)?.text.toString()
            this@IssueFragment.arguments?.putString("issueType",issueType)
            this@IssueFragment.arguments?.putString("issueSolution",issueSolution)
            this@IssueFragment.arguments?.putString("issueObservations",issueObservations)
            findNavController().navigate(R.id.action_issueFragment_to_budgetFragment, this@IssueFragment.arguments)
        }
        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment IssueFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IssueFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}