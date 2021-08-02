package com.pesquiseme.hotmart.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.pesquiseme.hotmart.R
import com.pesquiseme.hotmart.databinding.ActivityDetailBinding
import com.pesquiseme.hotmart.domain.models.Location
import com.pesquiseme.hotmart.presentation.Utils
import com.pesquiseme.hotmart.presentation.home.Adapter.TypeEnum
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val extras = intent.extras

        if (extras != null) {
            val id = intent.getIntExtra("id", 0)
            viewModel.getLocation(id.toString())
        }

        getMessageError(viewModel)
        bindViews(binding, viewModel)
    }

    private fun bindViews(binding : ActivityDetailBinding, viewModel: DetailActivityViewModel) {

        binding.ivBack.setOnClickListener {
            finish()
        }

        viewModel.location.observe(this) { location ->
            if(location != null){
                getStars(binding, location)

                binding.tvName.text = location.name
                binding.tvAbout.text = location.about
                binding.tvPhone.text = location.phone
                binding.tvPin.text = location.adress
                binding.tvReview.text = location.review.toString()

                var schedule = ""

                if(location.schedule.monday != null)
                    schedule += "Segunda-feira - Abre: ${location.schedule.monday.open} e Fecha: ${location.schedule.monday.close} \n"
                if(location.schedule.tuesday != null)
                    schedule += "Terça-feira - Abre: ${location.schedule.tuesday.open} e Fecha: ${location.schedule.tuesday.close}  \n"
                if(location.schedule.wednesday != null)
                    schedule += "Quarta-feira - Abre: ${location.schedule.wednesday.open} e Fecha: ${location.schedule.wednesday.close}  \n"
                if(location.schedule.thursday != null)
                    schedule += "Quinta-feira - Abre: ${location.schedule.thursday.open} e Fecha: ${location.schedule.thursday.close}  \n"
                if(location.schedule.friday != null)
                    schedule += "Sexta-feira - Abre: ${location.schedule.friday.open} e Fecha: ${location.schedule.friday.close}  \n"
                if(location.schedule.saturday != null)
                    schedule += "Sábado - Abre: ${location.schedule.saturday.open} e Fecha: ${location.schedule.saturday.close}  \n"
                if(location.schedule.sunday != null)
                    schedule += "Domingo - Abre: ${location.schedule.sunday.open} e Fecha: ${location.schedule.sunday.close}"

                binding.tvClock.text = schedule

                when(location.type){
                    TypeEnum.BARBEARIA.type -> binding.ivPhoto.setImageResource(R.color.green_water)
                    TypeEnum.BARES.type -> binding.ivPhoto.setImageResource(R.color.pink_baby)
                    TypeEnum.CAFETERIA.type -> binding.ivPhoto.setImageResource(R.color.pastel_yellow)
                    TypeEnum.COWORKING.type -> binding.ivPhoto.setImageResource(R.color.green_water)
                    TypeEnum.RESTAURANTE.type -> binding.ivPhoto.setImageResource(R.color.pink_baby)
                    TypeEnum.PADARIA.type -> binding.ivPhoto.setImageResource(R.color.pastel_yellow)
                    TypeEnum.SUCOS_NATURAIS.type -> binding.ivPhoto.setImageResource(R.color.green_water)
                    TypeEnum.PRODUTOS_NATURAIS.type -> binding.ivPhoto.setImageResource(R.color.pink_baby)
                    TypeEnum.SUPERMERCADO.type -> binding.ivPhoto.setImageResource(R.color.pastel_yellow)
                    else -> {
                        binding.ivPhoto.setImageResource(R.color.green_water)
                    }
                }
            }
        }

    }

    private fun getStars(binding: ActivityDetailBinding, location: Location){

        binding.ivStar1.setImageResource(R.drawable.star_large_incomplete)
        binding.ivStar2.setImageResource(R.drawable.star_large_incomplete)
        binding.ivStar3.setImageResource(R.drawable.star_large_incomplete)
        binding.ivStar4.setImageResource(R.drawable.star_large_incomplete)
        binding.ivStar5.setImageResource(R.drawable.star_large_incomplete)

        if(location.review > 0.5 && location.review <= 1.5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
        }

        if(location.review > 1.5 && location.review <= 2.5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
            binding.ivStar2.setImageResource(R.drawable.star_large)
        }

        if(location.review > 2.5 && location.review <= 3.5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
            binding.ivStar2.setImageResource(R.drawable.star_large)
            binding.ivStar3.setImageResource(R.drawable.star_large)
        }

        if(location.review > 3.5 && location.review <= 4.5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
            binding.ivStar2.setImageResource(R.drawable.star_large)
            binding.ivStar3.setImageResource(R.drawable.star_large)
            binding.ivStar4.setImageResource(R.drawable.star_large)
        }

        if(location.review > 4.5 && location.review <= 5){
            binding.ivStar1.setImageResource(R.drawable.star_large)
            binding.ivStar2.setImageResource(R.drawable.star_large)
            binding.ivStar3.setImageResource(R.drawable.star_large)
            binding.ivStar4.setImageResource(R.drawable.star_large)
            binding.ivStar5.setImageResource(R.drawable.star_large)
        }

    }

    private fun getMessageError(viewModel: DetailActivityViewModel){
        viewModel.error.observe(this) { error ->
            if(error != null){
                if(error.isEmpty()){
                    Utils.showError(getString(R.string.alert_message_error), this)
                }
                else{
                    Utils.showError(error, this, true)
                }
            }
        }
    }

}