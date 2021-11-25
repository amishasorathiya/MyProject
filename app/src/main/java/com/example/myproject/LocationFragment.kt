package com.example.myproject

import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LocationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationFragment : Fragment() {
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


    lateinit var b1 : Button
    lateinit var b2 : Button
    lateinit var ed1:EditText
    lateinit var tv:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var v = inflater.inflate(R.layout.fragment_location, container, false)

        b1 = v.findViewById<Button>(R.id.button6)
        b2 = v.findViewById<Button>(R.id.button7)
        ed1 = v.findViewById<EditText>(R.id.editTextTextPersonName)
        tv = v.findViewById<TextView>(R.id.textView6)
        var tv2 = v.findViewById<TextView>(R.id.textView7)

        if(ActivityCompat.checkSelfPermission(requireContext(),android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(requireContext(),android.Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(requireContext(),android.Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,
                                                                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                                                                        android.Manifest.permission.INTERNET), 111)
        }
        else
        {
            b1.isEnabled = true
        }

        b1.setOnClickListener {
            var gc = Geocoder(requireContext(), Locale.getDefault())
            var address = gc.getFromLocationName(ed1.text.toString(), 2)
            var addresses = address.get(0)
            tv.visibility = View.VISIBLE
            tv2.visibility = View.VISIBLE
            tv.setText("Latitude : ${addresses.latitude} \nLongitude : ${addresses.longitude} \nLocality : ${addresses.locality}")

            var address2 = gc.getFromLocationName(ed1.text.toString(), 2)
            var addresses2 = address2.get(0)
            var addressescodes = gc.getFromLocation(addresses2.latitude,addresses2.longitude,2)
            var addressescode = addressescodes.get(0)
            tv2.setText("Searched Location :\n ${addressescode.locality} \n ${addressescode.getAddressLine(0)}")
        }

        var lm = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var ll = object : LocationListener {
            override fun onLocationChanged(p0: Location) {
                reverseGeocode(p0,tv2)
            }
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 50.2f, ll)

        return v
    }

    private fun reverseGeocode(location: Location, tv2: TextView) {
        var gc = Geocoder(requireContext(),Locale.getDefault())
        var addresses = gc.getFromLocation(location.latitude,location.longitude,2)
        var address = addresses.get(0)
        b2.setOnClickListener {
            tv2.visibility = View.VISIBLE
            tv.visibility = View.GONE
            tv2.setText("Current Location :\n ${address.locality} \n ${address.getAddressLine(0)}")
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            b1.isEnabled = true
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LocationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LocationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}