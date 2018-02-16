package com.in.nyk.networkexamplewithmvp.Network;

import com.in.nyk.networkexamplewithmvp.Model.Repository;

import java.util.ArrayList;

/**
 * Created by nikhilkanse on 16/02/18.
 */

public interface DownloadCompleteListener {
    void downloadComplete(ArrayList<Repository> repositories);
}
