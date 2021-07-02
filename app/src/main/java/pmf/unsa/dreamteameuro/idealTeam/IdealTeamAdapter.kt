package pmf.unsa.dreamteameuro.idealTeam

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_player_layout_database.view.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.data.Player


class IdealTeamAdapter: RecyclerView.Adapter<IdealTeamAdapter.MyViewHolder>() {

        private var playerList = emptyList<Player>()

        class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_player_layout_database, parent, false))
        }

        override fun getItemCount(): Int {
            return playerList.size
            //dsds
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = playerList[position]
            holder.itemView.number.text = currentItem.id.toString()
            holder.itemView.playerName.text = currentItem.name
            holder.itemView.age.text = currentItem.age.toString()

            holder.itemView.rvld.setOnClickListener {


            }

        }

        fun setData(player: List<Player>){
            this.playerList = player
            notifyDataSetChanged()
        }
    }

