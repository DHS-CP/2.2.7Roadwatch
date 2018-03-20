package com.example.osnho.a227roadwatch;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.backendless.Geo;
import com.backendless.exceptions.BackendlessException;
import com.backendless.geo.BackendlessGeoQuery;
import com.backendless.geo.GeoPoint;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class MapFragment extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //backendless infrastructure for geopoint manipulation
    private List<String> categories = new ArrayList<String>();
    Map<String, Object> meta = new HashMap<String, Object>();

    // backendless constants
    public static final String APPLICATION_ID = "8512BE23-528D-99C4-FF83-7CE5EE303F00";
    public static final String API_KEY = "FF8076AF-785C-50A7-FF2F-30B2E12C3800";
    public static final String SERVER_URL = "https://api.backendless.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //backendless initialization
        Backendless.setUrl(SERVER_URL );
        Backendless.initApp( getApplicationContext(), APPLICATION_ID, API_KEY );
        meta.put("name", "pothole");
        categories.add("accidents");

        // find all reported accidents
        BackendlessGeoQuery geoQuery = new BackendlessGeoQuery();
        geoQuery.addCategory( "accidents" );
        



        // double checking that backend is live and running
        /**HashMap testObject = new HashMap<>();
        testObject.put( "foo", "bar" );
        Backendless.Data.of( "TestTable" ).save(testObject, new AsyncCallback<Map>() {
                    @Override
                    public void handleResponse(Map response) {
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.e("MYAPP", "Server reported an error " + fault.getMessage());
                    }
                }); **/

        /**Backendless.Geo.savePoint( 38, -122, categories, meta, new AsyncCallback<GeoPoint>() {@Override
        public void handleResponse( GeoPoint geoPoint )
        {
            Log.i( "MYAPP", geoPoint.getObjectId() );
        }

            @Override
            public void handleFault( BackendlessFault backendlessFault )
            {

            }
        }); **/

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // add markers to the map for each reported accident in the database
        //for (GeoPoint point: geoPoints) {
        //    mMap.addMarker(new MarkerOptions().position(new LatLng(point.getLatitude(),point.getLongitude()))
        //            .title(point.getObjectId()));
        //}

        LatLng dublin = new LatLng(37.702152, -121.935791);

        // centers the map at about Dublin High School
        mMap.addMarker(new MarkerOptions().position(dublin).title("Dublin High School"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dublin, 16));
    }

    /**public void onMapLongClick(LatLng point) {
        mMap.addMarker(new MarkerOptions().position(point).title("new point"));
    }**/

    }
