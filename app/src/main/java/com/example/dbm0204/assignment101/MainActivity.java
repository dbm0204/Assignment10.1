package com.example.dbm0204.assignment101;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static EditText num;
    private static TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // gets the configuration of the android system
        Configuration config = getResources().getConfiguration();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        /**
         *  Check the orientation and act accordingly
         */
        if(config.orientation==Configuration.ORIENTATION_LANDSCAPE) {
            /**
             *  Landscape mode of the device
             */
            LM_Fragment ls_fragment = new LM_Fragment();
            fragmentTransaction.replace(R.id.content,ls_fragment);
        } else {
            /**
             * Portrait Mode of the device
             */
            PM_Fragment  pm_fragment = new PM_Fragment();
            fragmentTransaction.replace(R.id.content, pm_fragment);
            fragmentTransaction.addToBackStack(null);

        }
        // Commit the transaction
        fragmentTransaction.commit();

        num = (EditText) findViewById(R.id.field);
        String textString = num.getText().toString();
        text= (TextView) findViewById(R.id.blank);
        text.setText(textString);
    }


}
