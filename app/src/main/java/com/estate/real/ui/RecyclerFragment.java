package com.estate.real.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.estate.real.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_LIST = "list";

    // TODO: Rename and change types of parameters
    private String categoryTitle;
    private ArrayList<Item> itemsList;

    private OnFragmentInteractionListener mListener;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    public static RecyclerFragment newInstance(String categoryTitle, ArrayList<Item> list) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, categoryTitle);
        args.putParcelableArrayList(ARG_LIST, list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryTitle = getArguments().getString(ARG_TITLE);
            itemsList = getArguments().getParcelableArrayList(ARG_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_item, container, false);

//        holder.tvCategory.setText(item.getCategoryTitle());
        TextView tv = v.findViewById(R.id.category_title);
        tv.setText(categoryTitle);

        RecyclerView rv = v.findViewById(R.id.recyclerList);

        RecyclerAdapter adapter = new RecyclerAdapter(itemsList);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, Item item, int position) {
                mListener.onListItemClicked(position, item);
            }
        });

        Button btn = v.findViewById(R.id.btnViewAll);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewAllClicked(itemsList);
            }
        });
//        adapter.setOnItemClickListener(childListener);

//        holder.recyclerView.setAdapter(adapter);

//        holder.btnViewAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mListener.onViewAllClick(view, position);
//            }
//        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onViewAllClicked(ArrayList<Item> items);
        void onListItemClicked(int position, Item item);
    }
}
