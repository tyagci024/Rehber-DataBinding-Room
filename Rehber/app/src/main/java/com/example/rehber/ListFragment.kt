package com.example.rehber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rehber.ViewModel.ContactViewModel
import com.example.rehber.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var adapterContact : ContactAdapter
    private lateinit var binding:FragmentListBinding
    private val viewModel: ContactViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list,container, false)
        binding!!.listFragmentNesnesi=this


        viewModel.readAllData.observe(viewLifecycleOwner,{
            it?.let {
                adapterContact = ContactAdapter(viewModel)
                binding!!.adapterNesnesi=adapterContact

                adapterContact.updateData(it)
                if (it.size==0){
                    Toast.makeText(context,"liste boş", Toast.LENGTH_LONG).show()

                }

            }
        })
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    fun newPersonAdd (){
        val action =ListFragmentDirections.actionListFragmentToAddFragment()
        findNavController().navigate(action)
    }
}