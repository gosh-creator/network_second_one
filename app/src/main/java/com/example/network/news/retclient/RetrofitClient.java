//package com.example.network.news.retclient;
//
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
//
//public class RetrofitClient {
//    private static Retrofit instanse = null;
//
//    public static Retrofit getInstanse() {
//        if (instanse == null) instanse = new Retrofit.Builder().baseUrl("https://youtube.com")
//                .addConverterFactory(SimpleXmlConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        return instanse;
//    }
//}
