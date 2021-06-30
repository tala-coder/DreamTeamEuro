package pmf.unsa.dreamteameuro.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pmf.unsa.dreamteameuro.R
/*

class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    var data =  listOf<ListFragment>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ime: TextView = itemView.findViewById(R.id.textView3)
        val tim: TextView = itemView.findViewById(R.id.textView4)

        fun bind(item: ListFragment) {
            ime.text = ".."
            tim.text = "..."
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.players_item_view, parent, false)

                return ViewHolder(view)
            }
        }
    }
}*/
