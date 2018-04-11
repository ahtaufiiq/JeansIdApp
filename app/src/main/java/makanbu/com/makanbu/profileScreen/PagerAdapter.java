package makanbu.com.makanbu.profileScreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import makanbu.com.makanbu.profileScreen.FragmentFood;
import makanbu.com.makanbu.profileScreen.FragmentReview;

/**
 * Created by khalidaziaamrina on 16/03/18.
 */

public class PagerAdapter  extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new FragmentFood();
            case 1:
                return new FragmentReview();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
