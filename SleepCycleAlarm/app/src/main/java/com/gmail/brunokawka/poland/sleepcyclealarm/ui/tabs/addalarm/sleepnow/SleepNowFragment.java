package com.gmail.brunokawka.poland.sleepcyclealarm.ui.tabs.addalarm.sleepnow;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.brunokawka.poland.sleepcyclealarm.R;
import com.gmail.brunokawka.poland.sleepcyclealarm.ui.tabs.addalarm.ListAdapter;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SleepNowFragment extends Fragment {
    private static final String TAG = "SleepNowFragmentLog";

    @BindView(R.id.sleepNowFragmentRecycler)
    RecyclerView recycler;

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  layoutInflater.inflate(R.layout.fragment_sleep_now, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpRecycler();
    }

    private void setUpRecycler() {
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setItemAnimator(new DefaultItemAnimator());

        recycler.setAdapter(new ListAdapter(SleepNowItemBuilder.getItemsForCurrentDate(getCurrentDateTime()), recycler));
    }

    private DateTime getCurrentDateTime() {
        return DateTime.now();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
