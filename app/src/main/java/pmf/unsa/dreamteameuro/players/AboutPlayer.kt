package pmf.unsa.dreamteameuro.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pmf.unsa.dreamteameuro.R

class AboutPlayer : Fragment() {

    companion object {
        fun newInstance() = AboutPlayer()
    }

    private lateinit var viewModel: AboutPlayerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.about_player_fragment, container, false)
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AboutPlayerViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}