package pmf.unsa.dreamteameuro.idealTeam


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_player_layout_database.view.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.data.Player
import pmf.unsa.dreamteameuro.formats.MyFormat
import java.text.SimpleDateFormat
import java.util.*


class IdealTeamAdapter: RecyclerView.Adapter<IdealTeamAdapter.MyViewHolder>() {

        private var playerList = emptyList<Player>()

        class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_player_layout_database, parent, false))
        }

        override fun getItemCount(): Int {
            return playerList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = playerList[position]
            holder.itemView.number.text = currentItem.id.toString()
            holder.itemView.playerName.text = currentItem.name
            holder.itemView.age.text = MyFormat.formatDate(currentItem.age.toLong())

        }

        fun setData(player: List<Player>){
            this.playerList = player
            notifyDataSetChanged()
        }
}

