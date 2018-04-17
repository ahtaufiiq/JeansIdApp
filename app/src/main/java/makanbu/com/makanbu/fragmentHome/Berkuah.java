package makanbu.com.makanbu.fragmentHome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import makanbu.com.makanbu.R;
import makanbu.com.makanbu.adapter.MakananAdapter;
import makanbu.com.makanbu.model.Makanan;


public class Berkuah extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Makanan> listPosts;
    private FirebaseFirestore firebaseFirestore;

    public Berkuah() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_berkuah, container, false);

        recyclerView = view.findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        firebaseFirestore = FirebaseFirestore.getInstance();
        listPosts = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MakananAdapter(getContext(), listPosts);

        recyclerView.setAdapter(adapter);
        getProduct();
        return view;
    }

    private void getProduct() {
        Query firstQuery = FirebaseFirestore.getInstance().collection("Makanan").whereEqualTo("category","berkuah").orderBy("timestamp", Query.Direction.DESCENDING);
        firstQuery.addSnapshotListener(getActivity(), new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                Log.d("Testing", "onEvent: " + e);

                if (!documentSnapshots.isEmpty()) {

                    for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {

                        if (doc.getType() == DocumentChange.Type.ADDED) {

                            String productId = doc.getDocument().getId();
                            Makanan product = doc.getDocument().toObject(Makanan.class);

                            listPosts.add(product);

                        }
                        adapter.notifyDataSetChanged();
                    }
                }

            }

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}