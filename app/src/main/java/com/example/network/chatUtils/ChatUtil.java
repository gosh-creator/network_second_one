package com.example.network.chatUtils;

import com.example.network.users.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class ChatUtil {
    public static void createChat(User user){
        String uid = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser().getUid()).toString();
        HashMap<String, String> chatInfo = new HashMap<>();
        chatInfo.put("userId1", uid);
        chatInfo.put("userId2", user.uid);

        String chatId = generateChatId(uid, user.uid);
        FirebaseDatabase.getInstance().getReference().child("ChatsId").child(chatId).setValue(chatInfo);

        addChatIdToUser(uid, chatId);
        addChatIdToUser(user.uid, chatId);
    }

    private static String generateChatId(String userId1, String userId2){
        String sumuserIds = userId2 + userId1;

        char[] charArray = sumuserIds.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static void addChatIdToUser(String uid, String chatId) {
        FirebaseDatabase.getInstance().getReference().child("Users").child(uid).child("chats").
                get().addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        String chats = task.getResult().getValue().toString();
                        String chatsUpd = addIdToStr(chats, chatId);

                        FirebaseDatabase.getInstance().getReference().
                                child("Users").child(uid).child("chats").setValue(chatsUpd);
                    }
                });

    }

    private static String addIdToStr(String str, String chatId){
        if (str.isEmpty()){
            str += chatId;
        }else {
            str += "," + chatId;
        }
        return str;
    }
}
