package com.example.dbm0204.assignment101;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dbm0204 on 6/18/17.
 */

public class LM_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        /**
         * Inflate the layout of this fragment
         */
        return inflater.inflate(R.layout.lm_fragment,container,false);

    }
}
