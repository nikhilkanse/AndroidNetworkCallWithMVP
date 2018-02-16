package com.in.nyk.networkexamplewithmvp.Presenter;

import com.in.nyk.networkexamplewithmvp.Contractor.IRepoActivity;
import com.in.nyk.networkexamplewithmvp.Model.Repository;
import com.in.nyk.networkexamplewithmvp.Network.DownloadCompleteListener;
import com.in.nyk.networkexamplewithmvp.Network.DownloadRepoTask;

import java.util.ArrayList;

/**
 * Created by nikhilkanse on 16/02/18.
 */

public class RepoListPresenter implements IRepoActivity.ActivityPresenter, DownloadCompleteListener {

    private IRepoActivity.ActivityView view;

    public RepoListPresenter(IRepoActivity.ActivityView view) {
        this.view = view;
    }

    @Override
    public void downloadData() {
        view.showProgressDialog();
        new DownloadRepoTask(this).execute("https://api.github.com/repositories");
    }

    @Override
    public void downloadComplete(ArrayList<Repository> repositories) {
        view.hideProgressDialog();
        view.showResult(repositories);
    }
}
