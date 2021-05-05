package com.example.ageofempires

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.civilization_row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    val civilizationNames = listOf("first name", "second name", "third name", "fourth")


    //number of items
    override fun getItemCount(): Int {
        println(homeFeed.civilizations.size)
        return homeFeed.civilizations.size


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.civilization_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        val civilizationName = civilizationNames.get(position)
        val civ = homeFeed.civilizations.get(position)

        //This is where I pull my data from

        holder.view?.textView_civ_name?.text = civ.name
        holder.view?.textView_data?.text = "Army Type: " + civ.army_type
        holder.view?.textView_data1?.text = "Bonus: " + civ.team_bonus

    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            println("test click")


            val intent= Intent(view.context, CivilizationDetailActivity::class.java)

            view.context.startActivity(intent)
        }
    }

}