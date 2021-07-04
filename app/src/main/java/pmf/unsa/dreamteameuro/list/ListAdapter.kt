package pmf.unsa.dreamteameuro.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.player_layout.view.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.list.network.Player


class ListAdapter(private val listener: OnItemClickedListener): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var myList = emptyList<Player>()

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.onItemClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.playerName.text = myList[position].player.name
        holder.itemView.playerPrice.text = formatPrice(myList[position].player.proposedMarketValue)
        holder.itemView.shirt.text = myList[position].player.shirtNumber.toString()
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Player>) {
        myList = newList
        notifyDataSetChanged()
    }


    fun formatPrice(price: Int): String {
        var formated = "$"
        var pom = price
        var i = 0
        if(pom < 1000000) {
            val str = price.toString()
            if(str.length == 6)
                formated += str.substring(0,2) + " k"
            else if(str.length == 5)
                formated += str.substring(0,1) + " k"
            else
                formated += str[0] + " k"
        }
        while(pom >= 1000000) {
            val str = price.toString()
            pom /= 10
            formated += str[i]
            i += 1
            if(pom < 1000000)
                formated += "." + str[i] + " m"
        }
        return formated
    }


    interface OnItemClickedListener {
        fun onItemClick(position: Int)
    }


}

