package com.example.kevin.androidsoundboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by kevin on 12/12/2017.
 */

public class noise_activity extends MainActivity {
    @Override
    protected Fragment getFragment() {
        Bundle extras = getIntent().getExtras();
        addFrag frag = new addFrag();
        frag.setArguments(extras);
        return frag;
    }
}
