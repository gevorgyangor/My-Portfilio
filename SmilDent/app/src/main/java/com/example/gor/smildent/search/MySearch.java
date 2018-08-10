package com.example.grigor.fivefriendsmile.search;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import com.example.grigor.fivefriendsmile.R;


public class MySearch extends Activity{


    public class MainActivity extends Activity {

        SearchView search;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            search = (SearchView) findViewById(R.id.searchView1);
            search.setQueryHint("SearchView");

            //*** setOnQueryTextFocusChangeListener ***
            search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub

                    Toast.makeText(getBaseContext(), String.valueOf(hasFocus),
                            Toast.LENGTH_SHORT).show();
                }
            });

            //*** setOnQueryTextListener ***
            search.setOnQueryTextListener(new OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String query) {
                    // TODO Auto-generated method stub

                    Toast.makeText(getBaseContext(), query,
                            Toast.LENGTH_SHORT).show();

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    // TODO Auto-generated method stub

                    //	Toast.makeText(getBaseContext(), newText,
                    Toast.makeText(getBaseContext(), newText, Toast.LENGTH_LONG).show();
                    return false;
                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }
    }
}
