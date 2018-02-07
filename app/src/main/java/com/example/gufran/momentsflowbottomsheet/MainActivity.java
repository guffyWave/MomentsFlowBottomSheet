package com.example.gufran.momentsflowbottomsheet;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

import com.example.gufran.momentsflowbottomsheet.fragment.ImageGalleryFragment;
import com.example.gufran.momentsflowbottomsheet.fragment.VideoGalleryFragment;

public class MainActivity extends AppCompatActivity {
    BottomSheetBehavior sheetBehavior;
    LinearLayout layoutBottomSheet;
    int bottomSheetNewMargin = 0;
    ViewPager vpPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        vpPager = (ViewPager) findViewById(R.id.vpPager);


        final CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) layoutBottomSheet.getLayoutParams();

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                bottomSheetNewMargin = (int) (convertDpToPixel(20) * (1 - slideOffset));
                params.setMargins(bottomSheetNewMargin, params.topMargin, bottomSheetNewMargin, params.bottomMargin);
                layoutBottomSheet.requestLayout();
            }
        });

    }

    public static float convertDpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return ImageGalleryFragment.newInstance(0);
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return VideoGalleryFragment.newInstance(1);
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }
    }

}
