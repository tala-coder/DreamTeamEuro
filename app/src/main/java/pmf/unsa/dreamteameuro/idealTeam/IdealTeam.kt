package pmf.unsa.dreamteameuro.idealTeam

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.ideal_team_fragment.view.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.data.PlayerViewModel
import pmf.unsa.dreamteameuro.list.ListAdapter


class IdealTeam : Fragment() {

    private lateinit var viewModel: PlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.ideal_team_fragment, container, false)


        val adapter = IdealTeamAdapter()
        val recyclerView = view.recyclerview_idealteam
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )


        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        viewModel.readAllData.observe(viewLifecycleOwner, Observer { player ->
            adapter.setData(player)
        })

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteAllPlayers()
        }
        else if(item.itemId == R.id.menu_share){
            shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.ideal_team_share))
        return shareIntent
    }


    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    private fun deleteAllPlayers() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteAllPlayers()
            Toast.makeText(
                requireContext(),
                "Successfully removed everything",
                Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }
}