package com.example.kevin.androidsoundboard;

import android.support.v4.app.Fragment;

/**
 * Created by kevin on 11/23/2017.
 */

public class SoundBoardActivity extends MainActivity {
    @Override
    protected Fragment getFragment() {
        return new listFrag();
    }
}
