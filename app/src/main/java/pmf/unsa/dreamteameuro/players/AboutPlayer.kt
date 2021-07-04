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
        view.agePly.text = formatDate(args.playerDate.toLong())
        view.positionPly.text = args.playerPosition
        view.heightPly.text = args.playerHeight.toString()
        view.valuePly.text = formatPrice(args.playerValue)
        view.numberPly.text = args.playerNumber.toString()

        view.add_floatingActionButton.setOnClickListener{
            insertPlayerToDatabase()
        }

        return view
    }

    fun formatPrice(price: Int): String {
        var formated = "$"
        var pom = price
        var i = 0
        if(pom < 1000000) {
            val str = price.toString()
            if(str.length == 6)
                formated += str.substring(0,2) + " k"
            else if(str.length == 5)
                formated += str.substring(0,1) + " k"
            else
                formated += str[0] + " k"
        }
        while(pom >= 1000000) {
            val str = price.toString()
            pom /= 10
            formated += str[i]
            i += 1
            if(pom < 1000000)
                formated += "." + str[i] + " m"
        }
        return formated
    }

    // https://stackoverflow.com/questions/47250263/kotlin-convert-timestamp-to-datetime
    private fun formatDate(epoc: Long): String? {
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val netDate = Date(epoc*1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }


    private fun insertPlayerToDatabase() {

        val t1 = namePly.text.toString()
        val t2 = numberPly.text.toString()
        val t3 = args.playerDate.toString()
//        val t3 = agePly.text.toString()


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