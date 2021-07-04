package pmf.unsa.dreamteameuro.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.findNavController
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.databinding.FragmentHomeBinding

val map = hashMapOf(
    "Italy" to 4707,
    "Belgium" to 4717,
    "Spain" to 4698,
    "Netherlands" to 4705,
    "England" to 4713,
    "France" to 4481,
    "Portugal" to 4704,
    "Switzerland" to 4699,
    "Austria" to 4718,
    "Wales" to 4702,
    "Sweden" to 4688,
    "Denmark" to 4476,
    "Germany" to 4711,
    "Finland" to 4712,
    "Ukraine" to 4701,
    "Croatia" to 4715,
    "Czech Republic" to 4714,
    "Poland" to 4703,
    "Scotland" to 4695,
    "Russia" to 4694,
    "Turkey" to 4700,
    "North Macedonia" to 4777,
    "Slovakia" to 4697,
    "Hungary" to 4709
)

class HomeFragment : Fragment(), AdapterView.OnItemSelectedListener{
    private lateinit var binding: FragmentHomeBinding
    var teamName = "Austria"
    var teamId = 4718

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater)

        binding.next.setOnClickListener { view : View ->
            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToListFragment(teamName, teamId))
        }

        /*binding.next2.setOnClickListener { view : View ->
            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToIdealTeam())
        }*/

        val spinner: Spinner = binding.spinner
        ArrayAdapter.createFromResource(
            this.requireActivity(),
            R.array.teams,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this

        return binding.root
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            teamName = parent.getItemAtPosition(position).toString()
            teamId = map[teamName]!!
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        teamName = "Austria"
        teamId = 4718
    }

}