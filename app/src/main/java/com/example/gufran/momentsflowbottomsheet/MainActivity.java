package com.example.gufran.momentsflowbottomsheet;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    BottomSheetBehavior sheetBehavior;
    LinearLayout layoutBottomSheet;
    int bottomSheetNewMargin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);


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
}
