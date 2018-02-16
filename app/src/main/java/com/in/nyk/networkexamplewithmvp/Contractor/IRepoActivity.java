package com.in.nyk.networkexamplewithmvp.Contractor;

import com.in.nyk.networkexamplewithmvp.Model.Repository;

import java.util.ArrayList;

/**
 * Created by nikhilkanse on 16/02/18.
 */

public class IRepoActivity {

    /** Represents the View in MVP. */
    public interface ActivityView {
        void showProgressDialog();
        void hideProgressDialog();
        void showResult(ArrayList<Repository> repositories);
        void showError();
    }

    /** Represents the Presenter in MVP. */
    public interface ActivityPresenter {
       void downloadData();
    }

}
