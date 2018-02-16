package com.in.nyk.networkexamplewithmvp.UI;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.in.nyk.networkexamplewithmvp.Contractor.IRepoActivity;
import com.in.nyk.networkexamplewithmvp.Model.Repository;
import com.in.nyk.networkexamplewithmvp.Presenter.RepoListPresenter;
import com.in.nyk.networkexamplewithmvp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IRepoActivity.ActivityView {

    ListsFragment mListFragment;
    ProgressDialog mProgressDialog;
    IRepoActivity.ActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPresenter = new RepoListPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            mPresenter.downloadData();
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showResult(ArrayList<Repository> repositories) {
        mListFragment = ListsFragment.newInstance(repositories);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mListFragment).
                commit();
    }

    @Override
    public void showError() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Oopss !!! Something went wrong...");
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }
}
