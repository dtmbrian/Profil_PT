package com.example.b_corporation.ptanugerahgenerasibersama.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.b_corporation.ptanugerahgenerasibersama.R;

/**
 * Created by B-Corporation on 4/28/2016.
 */
public class Profil_perusahaan extends AppCompatActivity {
    TextView mprofilper;
    ScrollView mScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_perusahaan);
        mprofilper = (TextView) findViewById(R.id.textView3);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
    }

        private void scrollToBottom()
        {
            mScrollView.post(new Runnable()
            {
                public void run()
                {
                    mScrollView.smoothScrollTo(0, mprofilper.getBaseline());
                }
            });
        }
    }

