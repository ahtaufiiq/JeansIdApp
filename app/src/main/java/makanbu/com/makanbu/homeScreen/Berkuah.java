package makanbu.com.makanbu.homeScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import makanbu.com.makanbu.R;
import makanbu.com.makanbu.adapter.MakananAdapter;
import makanbu.com.makanbu.model.Makanan;


public class Berkuah extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Makanan> listPosts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_berkuah, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        listPosts = new ArrayList<>();

//        listPosts.add(new Makanan(""));

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        MakananAdapter postList = new MakananAdapter(getContext(), listPosts);

        recyclerView.setAdapter(postList);
        return view;
    }
}