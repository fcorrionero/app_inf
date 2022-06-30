package com.fcorrionero.appinformatica.ui.newClient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.room.Room
import com.fcorrionero.appinformatica.R
import com.fcorrionero.appinformatica.databinding.FragmentBudgetBinding
import com.fcorrionero.appinformatica.domain.Device
import com.fcorrionero.appinformatica.infrastructure.persistence.DeviceDatabase
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BudgetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BudgetFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentBudgetBinding ? = null
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
        // Inflate the layout for this fragment

        _binding =  FragmentBudgetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnSaveDevice.setOnClickListener {
            saveDevice()
        }

        return root
    }

    private fun saveDevice() {
        val budgetQuantity =
            this@BudgetFragment.view?.findViewById<EditText>(R.id.editTextBudgetQuantity)?.text.toString()
        val budgetAcceptation =
            this@BudgetFragment.view?.findViewById<CheckBox>(R.id.checkBoxBudgetAcceptation)?.isChecked

        val db = Room.databaseBuilder(
            this@BudgetFragment.context!!,
            DeviceDatabase::class.java, "device-db"
        ).build()

        val arg = this@BudgetFragment.arguments
        val id = UUID.randomUUID()
        val date = Date()
        val device = Device(
            id,
            arg?.get("name").toString(),
            arg?.get("phone").toString(),
            arg?.get("dni").toString(),
            arg?.get("address").toString(),
            arg?.get("deviceBrandModel").toString(),
            arg?.get("deviceAccessories").toString(),
            arg?.get("deviceSerialImei").toString(),
            arg?.get("issueType").toString(),
            arg?.get("issueSolution").toString(),
            arg?.get("issueObservations").toString(),
            budgetQuantity.toInt(),
            budgetAcceptation,
            date,
            date
        )
        db.deviceDao().insertAll(device)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BudgetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BudgetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}