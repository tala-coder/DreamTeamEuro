package pmf.unsa.dreamteameuro.list
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.databinding.FragmentListBinding
import pmf.unsa.dreamteameuro.list.repository.Repository


class ListFragment : Fragment(){

    private lateinit var viewModel: ListViewModel
    private lateinit var args: ListFragmentArgs
    private lateinit var myRecView: RecyclerView
    private val ListAdapter by lazy { ListAdapter() }

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = ListFragmentArgs.fromBundle(requireArguments())
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentListBinding.inflate(inflater)
        binding.next.text = args.teamName
        myRecView = binding.myRecView

        myRecView.addItemDecoration(
            DividerItemDecoration(
                myRecView.context,
                DividerItemDecoration.VERTICAL
            )
        )

        setHasOptionsMenu(true)
        setRecyclerView()

        val repository = Repository()
        val viewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        viewModel.getPlayers(args.teamId)
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.nationalPlayers?.let { ListAdapter.setData(it) }
            } else {
                Toast.makeText(context, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    private fun setRecyclerView() {
        myRecView.adapter = ListAdapter
        myRecView.layoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(myRecView.getContext(),
                (myRecView.layoutManager as LinearLayoutManager).getOrientation())
        myRecView.addItemDecoration(dividerItemDecoration)
    }


    
}