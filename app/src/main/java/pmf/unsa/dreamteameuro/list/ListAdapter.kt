package pmf.unsa.dreamteameuro.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.player_layout.view.*
import org.json.JSONObject
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.list.network.Player


class ListAdapter: RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var myList = emptyList<Player>()

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.player_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.playerName.text = myList[position].player.name
        holder.itemView.playerPrice.text = "$" + myList[position].player.proposedMarketValue.toString()
        holder.itemView.shirt.text = myList[position].player.shirtNumber.toString()
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    fun setData(newList: List<Player>) {
        myList = newList
        notifyDataSetChanged()
    }





}

