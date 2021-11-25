package com.example.myproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeachAdapter:RecyclerView.Adapter<BeachAdapter.MyHolder> (){

    var beach_data = arrayOf("Panambur Beach","Diu Beach","Colva Beach","Om Beach","Aksa Beach","Marina Beach","Kappad Beach","Mandvi Beach","Golden Beach","Someshwar Beach","Betul Beach","Yanam Beach","Tithal Beach","Hawa Beach","Juhu Beach","Coco Beach","Kelwa Beach","Paradise Beach")
    var state_data = arrayOf("Mangalore","Gujarat","Goa","Karnataka","Maharastra","Tamil Nadu","Kerala","Gujarat","Tamil Nadu","Karnataka","Goa","Pondicherry","Gujarat","Kerala","Maharastra","Goa","Maharastra","Pondicherry")
    var beach_image = arrayOf(R.drawable.panambur_beach,R.drawable.diu_beach,R.drawable.colva_beach,R.drawable.om_beach,R.drawable.aksa_beach,R.drawable.marina_beach,R.drawable.kappad_beach,R.drawable.mandvi_beach,R.drawable.golden_beach,R.drawable.someshwar_beach,R.drawable.betul_beach,R.drawable.yanam_beach,R.drawable.tithal_beach,R.drawable.hawa_beach,R.drawable.juhu_beach,R.drawable.coco_beach,R.drawable.kelwa_beach,R.drawable.paradise_beach)

    inner class MyHolder(view: View):RecyclerView.ViewHolder(view){
       // var photo:ImageView
        var beach:TextView
        var state:TextView
        var bimage:ImageView

        init {
          //  photo = view.findViewById(android.R.id.text1)
            beach = view.findViewById(R.id.textView)
            state = view.findViewById(R.id.textView2)
            bimage = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.mylayout,parent,false)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.beach.text = beach_data[position]
        holder.state.text = state_data[position]
        holder.bimage.setImageResource(beach_image[position])
    }

    override fun getItemCount(): Int {
        return beach_data.size
    }


}