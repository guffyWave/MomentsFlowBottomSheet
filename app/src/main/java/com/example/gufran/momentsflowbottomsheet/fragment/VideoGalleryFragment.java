package com.example.gufran.momentsflowbottomsheet.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gufran.momentsflowbottomsheet.R;

/**
 * Created by magicpin on 7/2/18.
 */

public class VideoGalleryFragment extends Fragment {

    public static VideoGalleryFragment newInstance(int page) {
        VideoGalleryFragment fragment = new VideoGalleryFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_gallery, container, false);
    }
}
