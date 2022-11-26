package com.example.indianewsfeed.ui.sports;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indianewsfeed.Models.APIResponse;
import com.example.indianewsfeed.Models.Headlines;
import com.example.indianewsfeed.R;
import com.example.indianewsfeed.databinding.FragmentHomeBinding;
import com.example.indianewsfeed.ui.home.HomeAdapter;
import com.example.indianewsfeed.ui.home.NewsContentActivity;
import com.example.indianewsfeed.ui.home.OnFetchDataListener;
import com.example.indianewsfeed.ui.home.RequestManager;
import com.example.indianewsfeed.ui.home.SelectListener;

import java.util.List;

public class SportsFragment extends Fragment implements SelectListener {

    RecyclerView recyclerView;
    HomeAdapter adapter;
    ProgressDialog dialog;


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dialog = new ProgressDialog(getContext());
        dialog.setTitle("Fetching news articles...");
        dialog.show();

        RequestManager manager=new RequestManager(getContext());
        manager.getNewsHeadlines(listener,"sports",null);

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                dialog.setTitle("Fetching news articles of "+query);
                dialog.show();
                RequestManager manager=new RequestManager(getContext());
                manager.getNewsHeadlines(listener,"business",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                return false;
            }
        });

        return root;

    }

    private final OnFetchDataListener<APIResponse> listener=new OnFetchDataListener<APIResponse>() {
        @Override
        public void onFetchData(List<Headlines> list, String message)
        {
            if(list.isEmpty())
            {
                Toast.makeText(getContext(), "No Data found", Toast.LENGTH_SHORT).show();
            }
            else {
                showNews(list);
                dialog.dismiss();

            }


        }

        @Override
        public void onError(String message) {
            Toast.makeText(getContext(), "An Error Occurred", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<Headlines> list) {
        recyclerView=binding.recyclerMain.findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        adapter =new HomeAdapter(getContext(),list, (SelectListener) this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnNewsClicked(Headlines headlines)
    {
        startActivity(new Intent(getContext(), NewsContentActivity.class)
                .putExtra("data",headlines));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}