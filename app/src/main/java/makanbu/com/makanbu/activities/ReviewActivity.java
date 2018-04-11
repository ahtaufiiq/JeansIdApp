package makanbu.com.makanbu.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import makanbu.com.makanbu.R;
import makanbu.com.makanbu.profileScreen.Profile;

public class ReviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_review_after_order);
    }

    public void review(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
