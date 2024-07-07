package com.mindofmachines.vegme.ui.chatai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mindofmachines.vegme.databinding.FragmentChataiBinding;

public class ChataiFragment extends Fragment {

    private FragmentChataiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ChataiViewModel chataiViewModel =
                new ViewModelProvider(this).get(ChataiViewModel.class);

        binding = FragmentChataiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textChatai;
        chataiViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}