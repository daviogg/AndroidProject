package it.reti.percorsi.markerlibrary

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

abstract class TravelDelegateBase : GoogleMap.OnMarkerClickListener {

    override fun onMarkerClick(marker: Marker): Boolean {
        return false
    }

    open fun onBuildMarkerOptions(item: Markable): MarkerOptions? {
        return MarkerOptions()
            .position(LatLng(item.latitude, item.longitude))
            .title(item.title)
            .flat(true)
    }

    fun getTravel(): Collection<Markable> {
        return onGetTravel()
    }

    abstract fun onGetTravel(): Collection<Markable>
}