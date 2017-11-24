package com.example.kevin.androidsoundboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kevin on 11/23/2017.
 */

public class listFrag extends android.support.v4.app.Fragment {
    private SoundAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recycle_view, container, false);
        RecyclerView buttonList = v.findViewById(R.id.rv_list);
        this.adapter = new SoundAdapter();
        buttonList.setAdapter(adapter);
        buttonList.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
}
