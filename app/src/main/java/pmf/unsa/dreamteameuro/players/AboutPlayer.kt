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
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.data.Player
import pmf.unsa.dreamteameuro.data.PlayerViewModel
import pmf.unsa.dreamteameuro.formats.MyFormat
import java.text.SimpleDateFormat
import java.util.*

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
        view.agePly.text = MyFormat.formatDate(args.playerDate.toLong())
        view.positionPly.text = MyFormat.formatPosition(args.playerPosition)
        view.heightPly.text = MyFormat.formatHeight(args.playerHeight)
        view.valuePly.text = MyFormat.formatPrice(args.playerValue)
        view.numberPly.text = args.playerNumber.toString()

        view.add_floatingActionButton.setOnClickListener{
            insertPlayerToDatabase()
        }

        return view
    }


    private fun insertPlayerToDatabase() {

        try{
            val player = Player(0, args.playerName, args.playerPosition, args.playerDate)
            viewModel.addPlayer(player)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_aboutPlayer_to_idealTeam)


        }catch(excepiton: Exception){
            Toast.makeText(requireContext(), "Something wrong...", Toast.LENGTH_LONG).show()
        }


    }
}