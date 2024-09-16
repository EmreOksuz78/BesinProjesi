package com.emreoksuz.besinprojesi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.emreoksuz.besinprojesi.databinding.BesinRecyclerRowBinding
import com.emreoksuz.besinprojesi.model.Besin
import com.emreoksuz.besinprojesi.util.gorselIndir
import com.emreoksuz.besinprojesi.util.placeHolderYap
import com.emreoksuz.besinprojesi.view.BesinListeFragmentDirections

class BesinRecyclerAdapter(val besinListesi : ArrayList<Besin>) : RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {

    class BesinViewHolder(val binding  : BesinRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val binding=BesinRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BesinViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }


    fun besinListesiniGuncelle(yeniBesinListesi: List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {

        holder.binding.Besinisim.text=besinListesi[position].isim
        holder.binding.Besinkalori.text=besinListesi[position].kalori

        holder.itemView.setOnClickListener {
            val action = BesinListeFragmentDirections.actionBesinListeFragmentToBesinDetayFragment(besinListesi.get(position).uuid)
            Navigation.findNavController(it).navigate(action)
        }

        holder.binding.imageView.gorselIndir(besinListesi[position].gorsel, placeHolderYap(holder.itemView.context))

    }


}