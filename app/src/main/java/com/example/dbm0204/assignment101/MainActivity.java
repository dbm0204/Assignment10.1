package com.example.dbm0204.assignment101;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This is the MainActivity
 */
public class MainActivity extends Activity {
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_simple);
        if (savedInstanceState == null) {
            /**
             * Fragment is being intialized and instantiated
             */
            Fragment newFragment = SimpleAddition.newInstance(i);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.FrameLayout1, newFragment).commit();
        } else {
            i = savedInstanceState.getInt("level");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("level", i);
    }

    public static class SimpleAddition extends Fragment {
        int mNum;

        static SimpleAddition newInstance(int num) {
            SimpleAddition f = new SimpleAddition();

            Bundle args = new Bundle();
            args.putInt("num", num);
            f.setArguments(args);

            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.activity_main, container, false);

            Button b = (Button) v.findViewById(R.id.button1);
            final EditText et1 = (EditText) v.findViewById(R.id.editText1);
            final TextView tv = (TextView) v.findViewById(R.id.textView1);

            b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    tv.setText(et1.getText().toString());
                }
            });
            return v;
        }
    }

}