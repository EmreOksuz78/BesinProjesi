package com.emreoksuz.besinprojesi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.emreoksuz.besinprojesi.databinding.FragmentBesinDetayBinding
import com.emreoksuz.besinprojesi.util.gorselIndir
import com.emreoksuz.besinprojesi.util.placeHolderYap
import com.emreoksuz.besinprojesi.viewmodel.BesinDetayiViewModel


class BesinDetayFragment : Fragment() {

    private var _binding: FragmentBesinDetayBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel :BesinDetayiViewModel
    var besinId=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBesinDetayBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[BesinDetayiViewModel::class.java]

        arguments?.let {
            besinId = BesinDetayFragmentArgs.fromBundle(it).besinId
        }

        viewModel.roomVerisiniAl(besinId)

        observeLiveData()

    }

    private fun observeLiveData(){
        viewModel.besinLiveData.observe(viewLifecycleOwner){
            binding.besinIsim.text=it.isim
            binding.besinKalori.text=it.kalori
            binding.besinProtein.text=it.protein
            binding.besinKarbonhidrat.text=it.karbonhidrat
            binding.besinYag.text=it.yag
            binding.besinImage.gorselIndir(it.gorsel, placeHolderYap(requireContext()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}