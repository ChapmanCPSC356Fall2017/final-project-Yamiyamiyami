package com.example.kevin.androidsoundboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kevin on 11/23/2017.
 */

public class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.SoundViewHolder>{
    @Override
    public SoundViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.cell, parent, false);
        return new SoundViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SoundViewHolder holder, int position) {
        ButtonModel button = buttonlist.GetInstance().getButtons().get(position);
        holder.setup(button);
    }

    @Override
    public int getItemCount() {
        return buttonlist.GetInstance().getButtons().size();
    }

    class SoundViewHolder extends RecyclerView.ViewHolder {
        private ButtonModel button;
        private Button bt_butt;
        public SoundViewHolder(View itemView) {
            super(itemView);
            this.bt_butt = itemView.findViewById(R.id.annoyRyan);
        }
        public void setup(ButtonModel button){
            this.button = button;
            this.bt_butt.setText(button.getText());
        }

    }
}
