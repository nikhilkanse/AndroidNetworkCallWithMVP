package com.in.nyk.networkexamplewithmvp.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.in.nyk.networkexamplewithmvp.Adapter.ListRecyclerViewAdapter;
import com.in.nyk.networkexamplewithmvp.Model.Repository;
import com.in.nyk.networkexamplewithmvp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhilkanse on 16/02/18.
 */

public class ListsFragment extends Fragment {

    private static final String SARG_REPOS = "repos";
    private List<Repository> mRepos = new ArrayList<>();

    public ListsFragment() {
    }

    public static ListsFragment newInstance(ArrayList<Repository> repos) {
        ListsFragment fragment = new ListsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(SARG_REPOS, repos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRepos = getArguments().getParcelableArrayList(SARG_REPOS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new ListRecyclerViewAdapter(mRepos));
        }
        return view;
    }
}
