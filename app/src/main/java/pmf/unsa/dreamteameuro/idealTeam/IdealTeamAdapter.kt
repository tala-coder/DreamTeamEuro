package pmf.unsa.dreamteameuro.idealTeam


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_player_layout_database.view.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.data.Player
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

//            holder.itemView.age.text = currentItem.age.toString()
            holder.itemView.age.text = formatDate(currentItem.age.toLong())

        }

// https://stackoverflow.com/questions/47250263/kotlin-convert-timestamp-to-datetime
    private fun formatDate(epoc: Long): String? {
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val netDate = Date(epoc*1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

        fun setData(player: List<Player>){
            this.playerList = player
            notifyDataSetChanged()
        }
}

