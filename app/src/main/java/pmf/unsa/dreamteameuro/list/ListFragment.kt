package pmf.unsa.dreamteameuro.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.databinding.FragmentListBinding
import pmf.unsa.dreamteameuro.databinding.FragmentSplashBinding


class ListFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentListBinding.inflate(inflater)
        setHasOptionsMenu(true)

//        val adapter = ListAdapter()
//        binding.recyclerviewListPlayers.adapter = adapter

        val args = ListFragmentArgs.fromBundle(requireArguments())
//        binding.next.text = "Name: " + args.teamName
//        binding.teamid.text = "ID: " + args.teamId
        binding.textView2.text = "Name: " + args.teamName
        binding.textView6.text = "ID: " + args.teamId
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

}