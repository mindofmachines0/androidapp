package com.mindofmachines.vegme.ui.chatai;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChataiViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ChataiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is vegmeai fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}