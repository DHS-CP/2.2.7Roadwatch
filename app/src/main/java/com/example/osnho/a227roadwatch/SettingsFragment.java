package com.example.osnho.a227roadwatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

/**
 * Created by osnho on 3/20/2018.
 */

public class SettingsFragment extends Fragment {

    private Switch data_share;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.settings_activity, container, false);

        data_share = (Switch) rootView.findViewById(R.id.data_share);
        Boolean switchState = data_share.isChecked();

        return rootView;
    }
}