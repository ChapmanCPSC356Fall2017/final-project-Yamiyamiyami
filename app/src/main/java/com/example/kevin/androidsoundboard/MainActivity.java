package com.example.kevin.androidsoundboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class MainActivity extends AppCompatActivity {
    protected abstract Fragment getFragment();
    public static final String EXTRA_NOTE_ID = "potato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(getFragment());
    }
    private void showFragment(Fragment frag)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_contain, frag)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_noise,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_noise:
                ButtonModel button = new ButtonModel();
                Intent newIntent = new Intent(getApplicationContext(),noise_activity.class);
                newIntent.putExtra(MainActivity.EXTRA_NOTE_ID, button.getID());

                getApplicationContext().startActivity(newIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
