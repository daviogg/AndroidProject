package it.reti.percorsi.markerlibrary

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.Marker
import java.util.ArrayList

class MarkerMapView: LinearLayout, OnMapReadyCallback {

    private var mMap: GoogleMap? = null
    private var mMapType: Int = NORMAL

    private var mTextColor: Int = 0
    var textColor: Int
        get() = mTextColor
        set(value) {
            mTextColor = value
            update()
        }
    private lateinit var mText: TextView
    private lateinit var mMapContainer: FrameLayout
    var travelDelegate: TravelDelegateBase? = null

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(
        context: Context,
        attrs: AttributeSet
    ) {
        init(context)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MarkerMapView)
        val defaultColor = context.getColor(android.R.color.holo_red_dark)
        mTextColor = typedArray.getColor(R.styleable.MarkerMapView_android_textColor, defaultColor)
        mMapType = typedArray.getInt(R.styleable.MarkerMapView_mapStyle, NORMAL)

        typedArray.recycle()

        update()
    }

    private fun init(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.marker_map_view, this)
        mText = findViewById(R.id.marker_map_view_txt)
        mMapContainer = findViewById(R.id.marker_map_view_map_container)
        buildMapFragment(context)
    }

    private fun update() {
        mText.setTextColor(mTextColor)
        mMap?.mapType =
            if (mMapType == HYBRID) GoogleMap.MAP_TYPE_HYBRID else if (mMapType == SATELLITE) GoogleMap.MAP_TYPE_SATELLITE else GoogleMap.MAP_TYPE_NORMAL
    }

    fun syncMapWithDelegate() {
        if (context is FragmentActivity) {
            val activity = context as FragmentActivity
            activity.supportFragmentManager.fragments
                .filterIsInstance(SupportMapFragment::class.java)
                .firstOrNull()
                ?.getMapAsync(this)
        }
    }

    fun setText(text: String) {
        mText.text = text
    }

    private fun buildMapFragment(context: Context) {
        if (context is FragmentActivity) {
            val mapFragment: SupportMapFragment = SupportMapFragment.newInstance()
            context
                .supportFragmentManager
                .beginTransaction()
                .add(R.id.marker_map_view_map_container, mapFragment)
                .commit()

        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        mMap!!.setOnMarkerClickListener(travelDelegate)
        refreshData()
        update()
    }

    private fun moveToMapBounds(markers: ArrayList<Marker>) {
        val builder = LatLngBounds.Builder()
        for (marker in markers) {
            builder.include(marker.position)
        }
        val bounds = builder.build()
        val padding = 48 // offset from edges of the map in pixels
        mMap?.moveCamera(CameraUpdateFactory.zoomTo(13F))
        mMap?.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding))
    }

    private fun refreshData() {
        mMap?.let {
            it.clear()
            val travel = travelDelegate?.getTravel()
            val markers = ArrayList<Marker>()
            it.clear()
            if (travel != null) {
                for (element in travel) {
                    val markerOptions = travelDelegate?.onBuildMarkerOptions(element)
                    markerOptions?.let { o ->
                        val marker = it.addMarker(o)
                        markers.add(marker)
                    }
                }
            }
            moveToMapBounds(markers)
        }
    }

    companion object {
        const val NORMAL = 0
        const val SATELLITE = 1
        const val HYBRID = 2
    }
}