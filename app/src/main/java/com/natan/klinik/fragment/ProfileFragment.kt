package com.natan.klinik.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.natan.klinik.R
import com.natan.klinik.activities.DetailDoctorActivity
import com.natan.klinik.activities.LoginActivity
import com.natan.klinik.databinding.FragmentProfileBinding
import com.pixplicity.easyprefs.library.Prefs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    lateinit var binding : FragmentProfileBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        var name = Prefs.getString("name", "")
        var email = Prefs.getString("email", "")
        var role_id = Prefs.getInt("role_id", 0)
        var image = Prefs.getString("image", "")
        binding.tvNamaPasien.setText(name)
        binding.tvEmailPasien.setText(email)
        if (role_id == 2){
            binding.tvRolePasien.setText("Pasien")
        }else{
            binding.tvRolePasien.setText("Dokter/Admin")
        }
        Glide.with(context!!).load(image).placeholder(R.drawable.ic_account).into(binding.imgProfilPasien)

        binding.btnLogout.setOnClickListener {
            Prefs.clear()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}