package pmf.unsa.dreamteameuro.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import pmf.unsa.dreamteameuro.R
import pmf.unsa.dreamteameuro.databinding.FragmentHomeBinding
import pmf.unsa.dreamteameuro.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentSplashBinding.inflate(inflater)


        Handler().postDelayed({
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
         }, 2500)

        return binding.root
    }
}