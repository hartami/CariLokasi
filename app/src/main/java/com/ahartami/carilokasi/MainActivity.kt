package com.ahartami.carilokasi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.common.api.Status
//import com.google.android.libraries.places.api.model.Place
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener
//import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
//import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.gms.location.places.AutocompleteFilter


class MainActivity : AppCompatActivity(), PlaceSelectionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //to search initial location
        val autocompleteFragment = fragmentManager.findFragmentById(R.id.autocomplete_fragment)
                as PlaceAutocompleteFragment
        val filter = AutocompleteFilter.Builder()
            .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS) // to show possible addresses in format
            .build()
        autocompleteFragment.setFilter(filter);
        autocompleteFragment.setOnPlaceSelectedListener(this)


        // to search destination
        val autocompleteFragment2 = fragmentManager.findFragmentById(R.id.autocomplete_fragment2)
                as PlaceAutocompleteFragment
        val filter2 = AutocompleteFilter.Builder()
            .setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS)  // to show possible addresses
            .build()
        autocompleteFragment.setFilter(filter2);
        autocompleteFragment2.setOnPlaceSelectedListener(this)
    }

    override fun onPlaceSelected(p0: Place) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(applicationContext,""+p0!!.name+p0!!.latLng,Toast.LENGTH_LONG).show();
    }


    override fun onError(status: Status) {
        Toast.makeText(applicationContext,""+status.toString(),Toast.LENGTH_LONG).show();
    }

}
