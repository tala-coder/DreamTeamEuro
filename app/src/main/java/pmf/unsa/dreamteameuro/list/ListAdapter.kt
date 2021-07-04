package pmf.unsa.dreamteameuro.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.player_layout.view.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.formats.MyFormat
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
        holder.itemView.playerPrice.text = MyFormat.formatPrice(myList[position].player.proposedMarketValue)
        holder.itemView.shirt.text = myList[position].player.shirtNumber.toString()
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Player>) {
        myList = newList
        notifyDataSetChanged()
    }

    interface OnItemClickedListener {
        fun onItemClick(position: Int)
    }


}

