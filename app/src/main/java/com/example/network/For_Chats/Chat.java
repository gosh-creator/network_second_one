package com.example.network.For_Chats;

public class Chat {
    private String chatid, chat_name, userId1, userId2;

    public Chat(String chatid, String chat_name, String userId1, String userId2) {
        this.chatid = chatid;
        this.chat_name = chat_name;
        this.userId1 = userId1;
        this.userId2 = userId2;
    }

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getUserId1() {
        return userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }

    public String getUserId2() {
        return userId2;
    }

    public void setUserId2(String userId2) {
        this.userId2 = userId2;
    }
}
