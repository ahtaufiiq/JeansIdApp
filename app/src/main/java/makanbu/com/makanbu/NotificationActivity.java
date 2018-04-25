package makanbu.com.makanbu;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import makanbu.com.makanbu.adapter.MakananAdapter;
import makanbu.com.makanbu.adapter.NotificationAdapter;
import makanbu.com.makanbu.model.Makanan;
import makanbu.com.makanbu.model.Notification;

public class NotificationActivity extends AppCompatActivity {
    Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Notification> listPosts;
    private FirebaseFirestore firebaseFirestore;
    private SwipeRefreshLayout swipeRefreshLayout;
    Query databasePost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        createToolbar();
        createActionBar();
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        firebaseFirestore = FirebaseFirestore.getInstance();
        listPosts = new ArrayList<>();
        databasePost = FirebaseDatabase.getInstance().getReference("Notification");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NotificationAdapter(this, listPosts);

        recyclerView.setAdapter(adapter);
    }
    public void onStart() {
        super.onStart();
        databasePost.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                listPosts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Notification post = postSnapshot.getValue(Notification.class);

                    listPosts.add(post);
                }

                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void createToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void createActionBar() {
        //Action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Notification");
    }
}
