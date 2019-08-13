package com.mind.bst.Interface;

import com.mind.bst.Model.Clients;

import java.util.List;

public interface IFirebaseLoadDone {

    void onFirebaseLoadSuccess(List<Clients> clientsList);
    void onFirebaseLoadFail(String message);
}
