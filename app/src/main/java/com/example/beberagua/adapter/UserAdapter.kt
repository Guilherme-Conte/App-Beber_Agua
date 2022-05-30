package com.example.beberagua.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.beberagua.R
import com.example.beberagua.data.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    var listaUser = emptyList<User>()

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textId = view.findViewById<TextView>(R.id.textId)
        val textPeso = view.findViewById<TextView>(R.id.textPeso)
        val textIdade = view.findViewById<TextView>(R.id.textIdade)
        //val textResult = view.findViewById<TextView>(R.id.text_resultadoML)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout_user, parent, false)

        return UserViewHolder(layout)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listaUser[position]

        holder.textId.text = user.id.toString()
        holder.textPeso.text = user.peso.toString()
        holder.textIdade.text = user.idade.toString()
        //holder.textResult.text = user.resultadoMl.toString()
    }

    override fun getItemCount(): Int {
        return listaUser.size
    }

    fun setList(list: List<User>){
        listaUser = list
        notifyDataSetChanged()
    }
}