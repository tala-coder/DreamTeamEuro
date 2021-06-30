package pmf.unsa.dreamteameuro.list

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.databinding.FragmentListBinding
import pmf.unsa.dreamteameuro.databinding.FragmentSplashBinding
import pmf.unsa.dreamteameuro.list.repository.Repository


class ListFragment : Fragment(){

    private lateinit var viewModel: ListViewModel
    private lateinit var args: ListFragmentArgs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = ListFragmentArgs.fromBundle(requireArguments())
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentListBinding.inflate(inflater)
        binding.next.text = "Name: " + args.teamName
        binding.teamid.text = "ID: " + args.teamId

        setHasOptionsMenu(true)

        val repository = Repository()
        val viewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        viewModel.getPlayers()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if(response.isSuccessful){
                Log.d("Response", response.body()?.players?.get(0).toString())
                binding.next.text = response.body()?.players?.get(0).toString()
            }
            else{
                Log.d("Response", response.errorBody().toString())
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

}