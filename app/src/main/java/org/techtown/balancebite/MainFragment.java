package org.techtown.balancebite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainFragment extends Fragment {
    MainActivity activity;
    RecyclerView recyclerView;
    MainItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main, container, false);
        activity = (MainActivity)getActivity();
        RecyclerView recyclerView;
        recyclerView = rootView.findViewById(R.id.mainRecycler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        adapter = new MainItemAdapter();
        adapter.addItem("영양사 joo's 레시피");
        adapter.addItem("쉐프 배의 레시피");
        adapter.addItem("홍쉐프 식단표");
        adapter.addItem("건강식 레시피");
        adapter.addItem("건강식 레시피");

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnMainItemClickListener() {
            @Override
            public void onItemClick(MainItemAdapter.ViewHolder holder, View view, int position) {
                String title = adapter.getItem(position);
                Toast.makeText(getContext(),"선택된 아이템:"+title,Toast.LENGTH_SHORT).show();
                activity.setItemTitle(title);
                activity.goItemPage();
            }
        });

        return rootView;
    }
}