package com.gabzil.focuslite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
{
    private String[] mNavigationDrawerItemTitles;
    ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mDrawerList = (ListView) findViewById(R.id.left_drawer);

            //Set the array if increasing the menu
            ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[4];

            drawerItem[0] = new ObjectDrawerItem(R.mipmap.ic_noti, "Results");
            drawerItem[1] = new ObjectDrawerItem(R.mipmap.ic_history, "History");
            drawerItem[2] = new ObjectDrawerItem(R.mipmap.ic_contact, "Contact");
            drawerItem[3] = new ObjectDrawerItem(R.mipmap.ic_logout, "Logout");

            DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem);
            mDrawerList.setAdapter(adapter);

            mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

            mTitle = mDrawerTitle = getTitle();
            android.support.v7.widget.Toolbar toolbar = new android.support.v7.widget.Toolbar(getApplicationContext());
            getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_drawer1);

            mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
            mDrawerToggle = new ActionBarDrawerToggle(
                    this,
                    mDrawerLayout,
                    toolbar,
                    R.string.drawer_open,
                    R.string.drawer_close
            ) {

                /**
                 * Called when a drawer has settled in a completely closed state.
                 */
                public void onDrawerClosed(View view)
                {
                    super.onDrawerClosed(view);
                    getSupportActionBar().setTitle(mNavigationDrawerItemTitles[position]);
                }

                /**
                 * Called when a drawer has settled in a completely open state.
                 */
                public void onDrawerOpened(View drawerView)
                {
                    super.onDrawerOpened(drawerView);
                    getSupportActionBar().setTitle(mDrawerTitle);
                }
            };

            mDrawerLayout.setDrawerListener(mDrawerToggle);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            if(savedInstanceState==null)
            {
                selectItem(0);
            }

        }
        catch(Exception Ex)
        {
            Log.println(3, "Err", Ex.getMessage());

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "Settings Here", Toast.LENGTH_SHORT).show();
                item.setVisible(true);
                return true;

            case R.id.action_search:
                Toast.makeText(this, "Searching Here", Toast.LENGTH_SHORT).show();
                item.setVisible(true);
                return true;

            case R.id.action_send:
                Toast.makeText(this, "Sending Here", Toast.LENGTH_SHORT).show();
                item.setVisible(true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void setTitle(CharSequence title)
    {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    private void selectItem(int position)
    {
        this.position=position;

        Fragment fragment = null;

        switch (position)
        {
            case 0:
                fragment = new Results();
                break;
            case 1:
                fragment = new History();
                break;
            case 2:
                fragment = new Contact();
                break;
            case 3:
                Intent i = new Intent(MainActivity.this,SignIn.class);
                startActivity(i);
//                fragment = new Logout();
                break;

            default:
                break;
        }

        if (fragment != null)
        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            getSupportActionBar().setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        }
        else
        {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            selectItem(position);
        }
    }

}