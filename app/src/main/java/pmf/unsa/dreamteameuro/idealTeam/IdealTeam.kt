package pmf.unsa.dreamteameuro.idealTeam

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pmf.unsa.dreamteameuro.R

class IdealTeam : Fragment() {

    companion object {
        fun newInstance() = IdealTeam()
    }

    private lateinit var viewModel: IdealTeamViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ideal_team_fragment, container, false)


    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(IdealTeamViewModel::class.java)
//
//
//    }

}