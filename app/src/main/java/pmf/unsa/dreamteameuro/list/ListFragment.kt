package pmf.unsa.dreamteameuro.list
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.databinding.FragmentListBinding
import pmf.unsa.dreamteameuro.list.network.Player
import pmf.unsa.dreamteameuro.list.repository.Repository


class ListFragment : Fragment(), ListAdapter.OnItemClickedListener{

    private lateinit var viewModel: ListViewModel
    private lateinit var args: ListFragmentArgs
    private lateinit var myRecView: RecyclerView
    private lateinit var myList: List<Player>
    private val ListAdapter by lazy { ListAdapter(this) }

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = ListFragmentArgs.fromBundle(requireArguments())
        val repository = Repository()
        val viewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
        viewModel.getPlayers(args.teamId)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.nationalPlayers?.let { ListAdapter.setData(it) }
                myList = response.body()?.nationalPlayers!!
            } else {
                Toast.makeText(context, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

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

        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.options2){
            sortList(2)
        }
        else if(item.itemId == R.id.options1){
            sortList(1)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setRecyclerView() {
        myRecView.adapter = ListAdapter
        myRecView.layoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(myRecView.getContext(),
                (myRecView.layoutManager as LinearLayoutManager).getOrientation())
        myRecView.addItemDecoration(dividerItemDecoration)
    }

    fun sortList(param: Int) {
        if(param == 2) {
            val priceComparator =
                Comparator { p1: Player, p2: Player -> p1.player.proposedMarketValue - p2.player.proposedMarketValue }
            myList = myList.sortedWith(priceComparator)
            ListAdapter.setData(myList)
        }
        else {
            val priceComparator =
                Comparator { p1: Player, p2: Player -> p2.player.proposedMarketValue - p1.player.proposedMarketValue }
            myList = myList.sortedWith(priceComparator)
            ListAdapter.setData(myList)
        }
    }

    override fun onItemClick(position: Int) {
        val item = myList[position]
        val playerName = item.player.name
        val playerNumber = item.player.shirtNumber
        val playerValue = item.player.proposedMarketValue
        val playerPosition = item.player.position
        val playerHeight = item.player.height
        val playerDate = item.player.dateOfBirthTimestamp
        findNavController().navigate(ListFragmentDirections.actionListFragmentToAboutPlayer(
            playerName,
            playerNumber,
            playerValue,
            playerPosition,
            playerHeight,
            playerDate
        ))
    }

}