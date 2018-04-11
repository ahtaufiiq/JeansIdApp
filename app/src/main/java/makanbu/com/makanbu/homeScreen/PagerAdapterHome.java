package makanbu.com.makanbu.homeScreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import makanbu.com.makanbu.homeScreen.Berkuah;
import makanbu.com.makanbu.homeScreen.Cemilan;
import makanbu.com.makanbu.homeScreen.Gorengan;

/**
 * Created by HP on 3/17/2018.
 */

public class PagerAdapterHome extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapterHome(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Berkuah();
            case 1:
                return new Gorengan();
            case 2:
                return new Cemilan();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
