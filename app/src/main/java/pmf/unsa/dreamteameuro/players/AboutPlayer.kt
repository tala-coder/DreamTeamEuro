package pmf.unsa.dreamteameuro.players

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.about_player_fragment.*
import kotlinx.android.synthetic.main.about_player_fragment.view.*
import kotlinx.android.synthetic.main.recyclerview_player_layout_database.view.*
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.data.Player
import pmf.unsa.dreamteameuro.data.PlayerViewModel

class AboutPlayer : Fragment() {

    private lateinit var args: AboutPlayerArgs
    private lateinit var viewModel: PlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = AboutPlayerArgs.fromBundle(requireArguments())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.about_player_fragment, container, false)
        viewModel = ViewModelProvider(this).get(PlayerViewModel::class.java)

        view.namePly.text = args.playerName
        view.agePly.text = args.playerDate.toString()
        view.positionPly.text = args.playerPosition
        view.heightPly.text = args.playerHeight.toString()
        view.valuePly.text = args.playerValue.toString()
        view.numberPly.text = args.playerNumber.toString()

        view.add_floatingActionButton.setOnClickListener{
            insertPlayerToDatabase()
        }

        return view
    }

    private fun insertPlayerToDatabase() {
        // todo: promijeniti nazive
        val t1 = namePly.text.toString()
        val t2 = numberPly.text.toString()
        val t3 = agePly.text.toString()
//        val t4 = t4.text.toString()



        try{
            val player = Player(0, t1, t2, Integer.parseInt(t3))
            viewModel.addPlayer(player)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_aboutPlayer_to_idealTeam)
        }catch(excepiton: Exception){
            Toast.makeText(requireContext(), "Something wrong...", Toast.LENGTH_LONG).show()
        }


    }
}