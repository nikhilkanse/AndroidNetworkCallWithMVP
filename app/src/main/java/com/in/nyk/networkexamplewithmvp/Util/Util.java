package com.in.nyk.networkexamplewithmvp.Util;

import com.in.nyk.networkexamplewithmvp.Model.Repository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by nikhilkanse on 16/02/18.
 */

public class Util {

    public static ArrayList<Repository> retrieveRepositoriesFromResponse(String response) throws
            JSONException {
        if (null == response) {
            return new ArrayList<>();
        }
        JSONArray jsonArray = new JSONArray(response);
        ArrayList<Repository> repositories = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (null != jsonObject) {
                Repository repository = new Repository();
                if (jsonObject.has("owner")) {
                    JSONObject owner = jsonObject.getJSONObject("owner");
                    if (owner.has("login")) {
                        String ownerName = owner.getString("login");
                        repository.setOwner(repository.new Owner(ownerName));
                    }
                }
                if (jsonObject.has("name")) {
                    repository.setName(jsonObject.getString("name"));
                }
                repositories.add(repository);
            }
        }
        return repositories;
    }
}

