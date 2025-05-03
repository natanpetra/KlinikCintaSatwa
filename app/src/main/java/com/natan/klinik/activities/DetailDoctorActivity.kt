package com.natan.klinik.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.natan.klinik.R
import com.natan.klinik.databinding.ActivityDetailDoctorBinding
import com.natan.klinik.model.DoctorItem

class DetailDoctorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("Detail Doctor")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val doctor = intent.getSerializableExtra("doctor") as? DoctorItem

        if (doctor != null) {
            binding.tvDoctorNameDetail.text = doctor.name
            binding.tvSpecialistDetail.text = doctor.specialization
            binding.tvDescription.text = doctor.phone
            Glide.with(this@DetailDoctorActivity)
                .load(doctor.imageUrl) // Pastikan ini sesuai dengan field gambar yang benar
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.img_doctor)
                .into(binding.imgDoctorDetail)
        }



    }
}