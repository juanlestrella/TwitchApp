package com.example.android.androidcapstoneproject.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.androidcapstoneproject.Constants
import com.example.android.androidcapstoneproject.R
import com.example.android.androidcapstoneproject.databinding.FragmentProfileBinding
import com.example.android.androidcapstoneproject.databinding.FragmentProfileBindingImpl
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private val scope: String = "user:edit"
    //private val args: ProfileFragmentArgs by navArgs()

    private val viewModel: ProfileViewModel by lazy {
        ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentProfileBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.authId.setOnClickListener {
            Log.i("ProfileFragment", "Clicckeed")
//            viewModel.twitchAuth()
            val intent = Intent(Intent.ACTION_VIEW)
            val auth_url = Constants.AUTH_URL +
                    "client_id=" + Constants.CLIENT_ID +
                    "&redirect_uri=" + Constants.LOCAL_URL +
                    "&response_type=token" +
                    "&scope=" + scope

            intent.data = Uri.parse(auth_url)
            startActivity(intent)
        }

        //val tokenDL = args.token
        //Log.i("PROFILE FRAGMENT", tokenDL.toString())

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.logout -> {
                FirebaseAuth.getInstance().signOut()
                findNavController().popBackStack() // TODO: navigate back to authFragment
                //Toast.makeText(activity, "clicked", Toast.LENGTH_SHORT).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}