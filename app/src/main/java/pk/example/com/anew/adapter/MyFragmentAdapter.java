package pk.example.com.anew.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import pk.example.com.anew.fragment.MyFragment;


public class MyFragmentAdapter extends FragmentPagerAdapter {
  private ArrayList<MyFragment> mMyFragments;
    private ArrayList<String> mTitle;

    public MyFragmentAdapter(FragmentManager fm, ArrayList<MyFragment> mMyFragments, ArrayList<String> mTitle) {
        super(fm);
        this.mMyFragments = mMyFragments;
        this.mTitle = mTitle;

    }

    @Override
    public Fragment getItem(int position) {
      //  return MyFragment.newInstance(position + 1);

        if(position < mMyFragments.size()){

            return mMyFragments.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if(mMyFragments != null){
            return mMyFragments.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(mTitle != null && position < mTitle.size()){
            return mTitle.get(position);
        }
        return "noTitle";
    }
}
