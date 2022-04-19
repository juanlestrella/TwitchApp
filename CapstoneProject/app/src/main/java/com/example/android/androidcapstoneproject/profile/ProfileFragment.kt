package com.example.android.androidcapstoneproject.profile
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.androidcapstoneproject.Constants
import com.example.android.androidcapstoneproject.R
import com.example.android.androidcapstoneproject.databinding.FragmentProfileBinding
import com.example.android.androidcapstoneproject.network.MyInterceptor
import com.example.android.androidcapstoneproject.repository.TwitchRepository
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private val args: ProfileFragmentArgs by navArgs()

    private val repository = TwitchRepository()

    var token: String? = null

    private val viewModel: ProfileViewModel by lazy {
        ViewModelProvider(this, ProfileViewModel.Factory(repository)).get(ProfileViewModel::class.java)
    }

    fun fetchToken(): String? {
        return token
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
            val intent = Intent(Intent.ACTION_VIEW)
            val authUri = Constants.AUTH_URL +
                    "&response_type=token" +
                    "&client_id=" + Constants.CLIENT_ID +
                    "&redirect_uri=" + Constants.LOCAL_URL +
                    "&scope=" + Constants.scope

            //Log.i("ProfileFragment", authUri)
            intent.data = Uri.parse(authUri)
            startActivity(intent)
        }

        // this works now, so need to use the tokenDL in viewmodel
        // to connect to the twitch api with retrofit

//        val scopeDL = args.scope.toString()
//        binding.channelEmotesId.text = scopeDL

        //binding.username.text = args.toString()
        //Log.i("ProfileFragment", args.accessToken.toString())

        if(args.accessToken != null){

            token = args.accessToken.toString()
            binding.channelChatBadgesId.text = token

            Log.i("ProfileFragment", args.accessToken.toString())
            Log.i("ProfileFragment", token!!)

            viewModel.getUsers()

            viewModel.users.observe( viewLifecycleOwner, Observer {

            })
        }



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