package pmf.unsa.dreamteameuro.idealTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.ideal_team_fragment.view.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.data.PlayerViewModel


class IdealTeam : Fragment() {

    private lateinit var viewModel: PlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.ideal_team_fragment, container, false)

        // Recyclerview
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

        //  PlayerViewModel
        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)
        viewModel.readAllData.observe(viewLifecycleOwner, Observer { player ->
            adapter.setData(player)
        })


        return view
    }

}