package makanbu.com.makanbu.homeScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import makanbu.com.makanbu.activities.LandingActivity;
import makanbu.com.makanbu.R;


public class Home extends AppCompatActivity {

    public static final String table_3 = "User";
    // [START declare_auth]
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        mAuth = FirebaseAuth.getInstance();
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Berkuah"));
        tabLayout.addTab(tabLayout.newTab().setText("Gorengan"));
        tabLayout.addTab(tabLayout.newTab().setText("Cemilan"));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapterHome adapter = new PagerAdapterHome(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setAdapter(adapter);
        viewPager.setAdapter(adapter);

        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth==null){
            Intent i = new Intent(Home.this,LandingActivity.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.menus:
                mAuth.signOut();
                Toast.makeText(this, "Ini menunya", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.searchh:
                signOut();
                Toast.makeText(this, "Ini pencarian", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void signOut(){
        mAuth.signOut();
        Intent i = new Intent(Home.this,LandingActivity.class);
        startActivity(i);
    }
}
