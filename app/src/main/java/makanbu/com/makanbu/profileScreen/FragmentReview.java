package makanbu.com.makanbu.profileScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import makanbu.com.makanbu.R;

/**
 * Created by khalidaziaamrina on 16/03/18.
 */

public class FragmentReview extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review, container, false);
    }


}
