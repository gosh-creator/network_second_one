//package com.example.network.news.models;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.ViewModel;
//
//import com.example.network.news.main_rep.MainRepository;
//
//public class MainViewModel extends ViewModel {
//
//    public MainRepository mainRepository;
//
//    public MainViewModel() {
//        mainRepository = new MainRepository();
//    }
//
//    public LiveData<Rss> getRss() {
//        return mainRepository.getRssMutableLiveData();
//    }
//
//    public LiveData<String> getStringMutableLiveData() {
//        return mainRepository.getStringMutableLiveData();
//    }
//
//    public void clear() {
//        mainRepository.clear();
//    }
//
//}
