package com.estate.real.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.estate.real.MainActivity;
import com.estate.real.R;
import com.estate.real.ui.ChatItemObject;
import com.estate.real.ui.MessagesListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment implements MessagesListAdapter.ItemClickListener {

    private RecyclerView chatmessageRecyclerView;
    private MessagesListAdapter myAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_messages, container, false);
        // If hidden, then show it here
        MainActivity activity = (MainActivity) getActivity();
        activity.getSupportActionBar().show();

        /////////////////////////////
        chatmessageRecyclerView = root.findViewById(R.id.chat_recyclerview);
        chatmessageRecyclerView.setHasFixedSize(true);
        List<ChatItemObject> rowListItem = getAllItemList();
        mLayoutManager = new LinearLayoutManager(getActivity());
        chatmessageRecyclerView.setLayoutManager(mLayoutManager);
        myAdapter = new MessagesListAdapter(getContext(), rowListItem);
        chatmessageRecyclerView.setAdapter(myAdapter);
        myAdapter.setClickListener(this);

        return root;
    }

    List<ChatItemObject> getAllItemList(){
        List<ChatItemObject> allItems = new ArrayList<ChatItemObject>();
        allItems.add(new ChatItemObject("Kimmu Group Sdn Bhd","Hello...", R.drawable.chat_prof1, " 11 : 34 am"));
        allItems.add(new ChatItemObject("TF One Construction","Hello...", R.drawable.chat_prof2, " 10: 46 am"));
        allItems.add(new ChatItemObject("Nilaitek M Sdn Bhd","Hello...", R.drawable.chat_prof3, "Yesterday"));
        allItems.add(new ChatItemObject("EC Excel Wire Sdn Bhd","Hello...", R.drawable.chat_prof4, "24-09-2019"));
        allItems.add(new ChatItemObject("Ado Dedovic","Hello...", R.drawable.chat_prof5, "25-09-2019"));
        allItems.add(new ChatItemObject("Jackie","Hello...", R.drawable.chat_prof6,"26-09-2019"));

        return allItems;
    }

    @Override
    public void itemClick(View view, int position) {
        switch (view.getId()){
            case R.id.message_image:
                Toast.makeText(getActivity(), "Hello WOrld", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}