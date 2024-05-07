package com.example.rv_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rv_kotlin.databinding.ActivityMainBinding
import com.example.rv_kotlin.databinding.ItemListDataBinding
import com.example.rv_kotlin.model.Item

class ItemAdapter (
    // paso 3 declarar constructor  del item Adapter
    /// paso 4 heredar Rv implementar inner class
    private val itemList : List<Item>,
    private val context : Context,
    private val listener : SendItem) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


        // paso implementar método oncreate , onBind,getItem.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // inflar vista item_list_data
        val binding = ItemListDataBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
            return  ItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = itemList[position]
        // cargamos textview con al descripcion
        holder.textView.text =item.itemDescription
        // this add the image on the imgView
        Glide.with(context).load(item.urlImage).centerCrop().override(300,300)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }



    //paso crear inner class   referencia al diseño del Rv  1.1

    inner class ItemViewHolder(binding: ItemListDataBinding) :
        RecyclerView.ViewHolder(binding.getRoot()), View.OnClickListener {


        // inicializar elemento de entrada Rv
        val imageView: ImageView
        val textView: TextView

        init {
            // referencia elementos con Id
            imageView = binding.ivItem
            textView = binding.tvItem

            itemView.setOnClickListener(this)


        }


        override fun onClick(v: View?) {
            listener.sendItem(itemList[layoutPosition])
        }

    }

    // paso 2 crear interfaz que implementaremos en el primer fragmento
    // para escuchar cuando alguien selecciona un elemento del Rv
    interface SendItem {
        fun sendItem(item: Item?)
    }



}

