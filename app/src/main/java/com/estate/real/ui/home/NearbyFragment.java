package com.estate.real.ui.home;


import android.app.Notification;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.estate.real.R;
import com.estate.real.ui.HomeRecyclerAdapter;
import com.estate.real.ui.HomeRecyclerViewData;
import com.estate.real.ui.Item;
import com.estate.real.ui.ParentItem;
import com.estate.real.ui.ParentRecyclerAdapter;
import com.estate.real.ui.RecyclerAdapter;
import com.estate.real.ui.RecyclerFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;


public class NearbyFragment extends Fragment {

    private int[] sampleImages = {R.drawable.image1, R.drawable.image2,
            R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6};


    public NearbyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.fragment_nearby, container, false);
        ScrollView parent = (ScrollView) inflater.inflate(R.layout.fragment_nearby, container, false);

        ArrayList<Item> dummyList = new ArrayList<>();
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));
        dummyList.add(new Item("Modern Kitchen Renovation", "RM18,800", "TF ONE Construction", "Selangor", "16:30"));

        String[] categories = new String[]{
                "Experienced Services",
                "Hot Deals",
                "Recommended Real Estates",
                "High Review Machineary"
        };
//        LinearLayout layout = parent.findViewById(R.id.home_container);

        RecyclerFragment[] fragments = new RecyclerFragment[4];
        fragments[0] = RecyclerFragment.newInstance(categories[0], dummyList);
        fragments[1] = RecyclerFragment.newInstance(categories[1], dummyList);
        fragments[2] = RecyclerFragment.newInstance(categories[2], dummyList);
        fragments[3] = RecyclerFragment.newInstance(categories[3], dummyList);

        getChildFragmentManager().beginTransaction()
                .add(R.id.home_container, fragments[0])
                .add(R.id.home_container, fragments[1])
                .add(R.id.home_container, fragments[2])
                .add(R.id.home_container, fragments[3])
                .commit();


        //inflating home recycler adapter

        RecyclerView homerecyclerview = parent.findViewById(R.id.homerecyclerview);
        //    private RecyclerView
        ArrayList<HomeRecyclerViewData> list = new ArrayList<>();
        list.add(new HomeRecyclerViewData("Professional Services", R.drawable.im1));
        list.add(new HomeRecyclerViewData("Contractor", R.drawable.im2));
        list.add(new HomeRecyclerViewData("Hardware Trading", R.drawable.im3));
        list.add(new HomeRecyclerViewData("Whole Seller", R.drawable.im4));
        list.add(new HomeRecyclerViewData("Whole Sale Dealer", R.drawable.im5));
        list.add(new HomeRecyclerViewData("Professional Services", R.drawable.im6));
        list.add(new HomeRecyclerViewData("Professional Services", R.drawable.im7));
        list.add(new HomeRecyclerViewData("Professional Services", R.drawable.im8));

        HomeRecyclerAdapter homeRecyclerAdapter = new HomeRecyclerAdapter(getContext(), list);
        homerecyclerview.setAdapter(homeRecyclerAdapter);
        homeRecyclerAdapter.notifyDataSetChanged();


        //Code for Carousel View
        CarouselView carouselView = parent.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        return parent;
    }

    private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}
