package makanbu.com.makanbu.profileScreen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import makanbu.com.makanbu.R;
import makanbu.com.makanbu.model.User;

public class Profile extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference databaseUser;
    TextView nama,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_profile);

        nama = findViewById(R.id.namaUser);
        Password= findViewById(R.id.harga_makanan);
        mAuth= FirebaseAuth.getInstance();
        String id = mAuth.getUid();

        databaseUser = FirebaseDatabase.getInstance().getReference("Profile").child(id);

        databaseUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user= dataSnapshot.getValue(User.class);
                nama.setText(user.getEmail());
                Password.setText(user.getNomerHandphone());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Foods"));
        tabLayout.addTab(tabLayout.newTab().setText("Review"));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
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
}
