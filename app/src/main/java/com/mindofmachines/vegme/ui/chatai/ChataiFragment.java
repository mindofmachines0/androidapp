package com.mindofmachines.vegme.ui.chatai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mindofmachines.vegme.databinding.FragmentChataiBinding;

public class ChataiFragment extends Fragment {

    private EditText messageInput;
    private Button sendButton;
    private RecyclerView messageRecyclerView;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;

    private FragmentChataiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ChataiViewModel chataiViewModel =
                new ViewModelProvider(this).get(ChataiViewModel.class);

        binding = FragmentChataiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        messageInput = binding.chatMessageInput;
        sendButton = binding.chatSendButton;
        messageRecyclerView = binding.messageRecyclerView;

        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);

        messageRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        messageRecyclerView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageInput.getText().toString();
                if (!messageText.isEmpty()) {
                    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                    Message message = new Message(messageText, timestamp);
                    messageList.add(message);
                    messageAdapter.notifyItemInserted(messageList.size() - 1);
                    messageRecyclerView.scrollToPosition(messageList.size() - 1);
                    messageInput.setText("");
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}