package com.example.grigor.fivefriendsmile;

import android.app.Dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.grigor.fivefriendsmile.search.SearchAdapter;
import com.example.grigor.fivefriendsmile.search.SearchUtil;
import com.example.grigor.fivefriendsmile.search.SharedPrefernces;
import com.example.grigor.fivefriendsmile.tabBar.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    Intent intent;
    Toolbar toolbar;
    private ArrayList<String> doctorsAndStomNames;


    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private NavigationView navigationView;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBarData();
        initDrawerLayout();
        initTabs();
//        initNavigationView();

    }

//    private void initNavigationView() {
//        navigationView = (NavigationView) findViewById(R.id.navigation_view);
//        navigationView.setItemIconTintList(null);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.login_drawer:
//                        intent = new Intent(MainActivity.this, LoginActivity.class);
//                        startActivity(intent);
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        item.setChecked(false);
//                        return true;
//                    case R.id.favorit_doctors:
////                        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
////
////    // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
////                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
////    // Make the Intent explicit by setting the Google Maps package
////                        mapIntent.setPackage("com.google.android.apps.maps");
////
////    // Attempt to start an activity that can handle the Intent
////                        startActivity(mapIntent);
////                        item.setChecked(false);
//                        return true;
//                    case R.id.about_us_drawer:
//                        intent = new Intent(MainActivity.this, AboutAs.class);
//                        startActivity(intent);
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        item.setChecked(false);
//                        return true;
//
//                }
//                return false;
//            }
//        });
//    }


    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            case android.R.id.home:
                finish();
                break;

            case R.id.action_search:
                loadToolBarSearch();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toolBarData() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Smile Dent");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }

    public void loadToolBarSearch() {

        ArrayList<String> countryStored = SharedPrefernces.loadList(MainActivity.this, SearchUtil.PREFS_NAME, SearchUtil.KEY_NAME);

        View view = MainActivity.this.getLayoutInflater().inflate(R.layout.view_toolbar_search, null);
        LinearLayout parentToolbarSearch = (LinearLayout) view.findViewById(R.id.parent_toolbar_search);
        ImageView imgToolBack = (ImageView) view.findViewById(R.id.img_tool_back);
        final EditText edtToolSearch = (EditText) view.findViewById(R.id.edt_tool_search);
        final ListView listSearch = (ListView) view.findViewById(R.id.list_search);
        final TextView txtEmpty = (TextView) view.findViewById(R.id.txt_empty);

        SearchUtil.setListViewHeightBasedOnChildren(listSearch);

        edtToolSearch.setHint("search doctor or stomatology");

        final Dialog toolbarSearchDialog = new Dialog(MainActivity.this, R.style.MaterialSearch);
        toolbarSearchDialog.setContentView(view);
        toolbarSearchDialog.setCancelable(false);
        toolbarSearchDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        toolbarSearchDialog.getWindow().setGravity(Gravity.BOTTOM);
        toolbarSearchDialog.show();

        toolbarSearchDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        countryStored = (countryStored != null && countryStored.size() > 0) ? countryStored : new ArrayList<String>();
        final SearchAdapter searchAdapter = new SearchAdapter(MainActivity.this, countryStored, false);

        listSearch.setVisibility(View.VISIBLE);
        listSearch.setAdapter(searchAdapter);


        listSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String country = String.valueOf(adapterView.getItemAtPosition(position));
                SharedPrefernces.addList(MainActivity.this, SearchUtil.PREFS_NAME, SearchUtil.KEY_NAME, country);
                edtToolSearch.setText(country);
                listSearch.setVisibility(View.GONE);


            }
        });
        edtToolSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                String[] country = MainActivity.this.getResources().getStringArray(R.array.stomatology_name_and_doctor_name);
                doctorsAndStomNames = new ArrayList<String>(Arrays.asList(country));
                listSearch.setVisibility(View.VISIBLE);
                searchAdapter.updateList(doctorsAndStomNames, true);


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<String> filterList = new ArrayList<String>();
                boolean isNodata = false;
                if (s.length() > 0) {
                    for (int i = 0; i < doctorsAndStomNames.size(); i++) {


                        if (doctorsAndStomNames.get(i).toLowerCase().startsWith(s.toString().trim().toLowerCase())) {

                            filterList.add(doctorsAndStomNames.get(i));

                            listSearch.setVisibility(View.VISIBLE);
                            searchAdapter.updateList(filterList, true);
                            isNodata = true;
                        }
                    }
                    if (!isNodata) {
                        listSearch.setVisibility(View.GONE);
                        txtEmpty.setVisibility(View.VISIBLE);
                        txtEmpty.setText("No data found");
                    }
                } else {
                    listSearch.setVisibility(View.GONE);
                    txtEmpty.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imgToolBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbarSearchDialog.dismiss();
            }
        });


    }


}















