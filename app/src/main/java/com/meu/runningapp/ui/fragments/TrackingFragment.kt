package com.meu.runningapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.maps.GoogleMap
import com.meu.runningapp.R
import com.meu.runningapp.databinding.FragmentTrackingBinding
import com.meu.runningapp.other.TrackingUtility.ActionServiceTracking
import com.meu.runningapp.services.TrackingService
import com.meu.runningapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking){

    private lateinit var binding:FragmentTrackingBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrackingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync {
            map = it
        }
        binding.btnToggleRun.setOnClickListener{
            sendCommandToService(ActionServiceTracking.ACTION_START_OR_RESUME_SERVICE.toString())
        }
    }

    //This function is responsible for indicating the action/intention to be taken by "Tracking"
    private fun sendCommandToService(action:String) =
        Intent(requireContext(), TrackingService::class.java).also {
            it.action = action
            requireContext().startService(it)
        }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    //This function warns about low memory, so the map consumes less resources.
    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    //This function helps store the map in the cache for don't have to load it all the time when opening app.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }
}
