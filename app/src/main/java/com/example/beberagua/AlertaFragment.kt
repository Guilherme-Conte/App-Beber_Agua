package com.example.beberagua

import android.app.TimePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.AlarmClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import com.example.beberagua.databinding.FragmentAlertaBinding
import java.util.*


class AlertaFragment : Fragment() {

    private lateinit var binding: FragmentAlertaBinding
    lateinit var timePickerDialog: TimePickerDialog
    lateinit var calendario: Calendar
    var horaAtual = 0
    var minutosAtual = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAlertaBinding.inflate(layoutInflater, container, false)

        binding.btDefinirLembrete.setOnClickListener {

            calendario = Calendar.getInstance()
            horaAtual = calendario.get(Calendar.HOUR_OF_DAY)
            minutosAtual = calendario.get(Calendar.MINUTE)
            timePickerDialog = TimePickerDialog(context,
                { timePicker: TimePicker, hourOfDay: Int, minutes: Int ->
                binding.textHora.text = String.format("%02d", hourOfDay)
                binding.textMinutos.text = String.format("%02d", minutes)
            }, horaAtual, minutosAtual, true)
            timePickerDialog.show()
        }

        binding.btAlarme.setOnClickListener {

            val hora = binding.textHora.text.toString()
            val minuto = binding.textMinutos.text.toString()

            if (!hora.isEmpty() && !minuto.isEmpty()){

                val intent = Intent(AlarmClock.ACTION_SET_ALARM)
                intent.putExtra(AlarmClock.EXTRA_HOUR, hora.toInt())
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minuto.toInt())
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Hora de beber água!")
                startActivity(intent)

            }

        }

        return binding.root

    }

}