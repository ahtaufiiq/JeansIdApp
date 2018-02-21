package makanbu.com.makanbu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ReviewAfterOrder extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_review_after_order);
    }
}
