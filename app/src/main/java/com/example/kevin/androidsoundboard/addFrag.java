package com.example.kevin.androidsoundboard;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by kevin on 12/12/2017.
 */

public class addFrag extends Fragment {
    private String LOG_TAG = "ERROR";
    private ButtonModel button;
    private Button recStopBT;
    private Button saveBT;
    private TextView tv_title;
    private MediaPlayer mp = null;
    private static String fileName;
    private MediaRecorder mr = null;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private boolean permissionToRecordAccepted = false;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String returnID = getArguments().getString(SoundBoardActivity.EXTRA_NOTE_ID);
        this.button = buttonlist.GetInstance().getButton(returnID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(getActivity(), permissions, REQUEST_RECORD_AUDIO_PERMISSION);
        fileName = getContext().getExternalCacheDir().getAbsolutePath();
        fileName += "/audiorecordtest.3gp";
        View v = inflater.inflate(R.layout.addnoisefrag, container, false);
        this.recStopBT = v.findViewById(R.id.recordBT);
        this.saveBT = v.findViewById(R.id.playBT);
        this.tv_title = v.findViewById(R.id.titleTV);
        recStopBT.setOnClickListener(new View.OnClickListener() {
            boolean mStartRecording = true;
            @Override
            public void onClick(View view) {

                onRecord(mStartRecording);
                if(mStartRecording){
                    recStopBT.setText("STOP");

                }else{
                    recStopBT.setText("RECORD");

                }
                mStartRecording = !mStartRecording;
            }
        });
        saveBT.setOnClickListener(new View.OnClickListener() {
            boolean mStartPlaying = true;
            @Override
            public void onClick(View view) {

                onPlay(mStartPlaying);
                if(mStartPlaying){
                    saveBT.setText("STOP");
                }else{
                    saveBT.setText("PLAY");
                }
                mStartPlaying = !mStartPlaying;
            }
        });
        return v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
    }
    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }
    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void stopRecording(){
        mr.stop();
        mr.release();
        mr = null;
    }
    private void startRecording() {
        mr = new MediaRecorder();
        mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        mr.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mr.setOutputFile(fileName);
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mr.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mr.start();
    }
    private void startPlaying() {
        mp = new MediaPlayer();
        try {
            mp.setDataSource(fileName);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopPlaying() {
        mp.release();
        mp = null;
    }


}
