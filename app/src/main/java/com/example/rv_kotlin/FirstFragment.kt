package com.example.rv_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv_kotlin.adapter.ItemAdapter
import com.example.rv_kotlin.databinding.FragmentFirstBinding
import com.example.rv_kotlin.model.Item

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() , ItemAdapter.SendItem{

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        // referencia elementos del Rv
        val mRecyclerView = binding!!.rvItem
        val adapter = ItemAdapter(returnItemList(), requireContext(),this)
        mRecyclerView.adapter = adapter
        mRecyclerView.layoutManager= LinearLayoutManager(context)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    //Generamos un listado de datos del tipo Item.
    private fun returnItemList(): List<Item> {
        val listItem: MutableList<Item> = ArrayList()
        val item01 = Item(
            "Zhuo Cheng you",
            "https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640"
        )
        listItem.add(item01)
        val item02 =
            Item("billow926", "https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640")
        listItem.add(item02)
        val item03 = Item(
            "Philipp Deiß",
            "https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640"
        )
        listItem.add(item03)
        val item04 = Item(
            "Huper by Joshua Earle",
            "https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640"
        )
        listItem.add(item04)
        val item05 = Item(
            "Melnychuk Nataliya",
            "https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640"
        )
        listItem.add(item05)
        val item06 = Item(
            "Teagan Maddux",
            "https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640"
        )
        listItem.add(item06)
        val item07 =
            Item("Chen Liu", "https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640")
        listItem.add(item07)
        val item08 = Item(
            "John Fornander",
            "https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640"
        )
        listItem.add(item08)
        val item09 = Item(
            "Parker Coffman",
            "https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640"
        )
        listItem.add(item09)
        val item10 =
            Item("XPS", "https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640")
        listItem.add(item10)
        val item11 = Item(
            "Daniel J. Schwarz",
            "https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640"
        )
        listItem.add(item11)
        val item12 = Item(
            "Wesley Armstrong",
            "https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640"
        )
        listItem.add(item12)
        return listItem
    }

    override fun sendItem(item: Item?) {

        val bundle = Bundle()
        bundle.putString("name",item!!.itemDescription)
        bundle.putString("url", item.urlImage)
        Navigation.findNavController(binding!!.getRoot())
            .navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)

    }
}