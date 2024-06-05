//package com.example.network.news.main_rep;
//
//import androidx.lifecycle.MutableLiveData;
//
//import com.example.network.news.interfaces.IApiService;
//import com.example.network.news.models.Rss;
//import com.example.network.news.retclient.RetrofitClient;
//
//import io.reactivex.disposables.CompositeDisposable;
//import io.reactivex.schedulers.Schedulers;
//
//public class MainRepository {
//    private MutableLiveData<Rss> rssMutableLiveData = new MutableLiveData<>();
//    private MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();
//
//    private CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//    private IApiService iApiService;
//
//    public MainRepository() {
//        iApiService = RetrofitClient.getInstanse().create(IApiService.class);
//    }
//
//    public MutableLiveData<Rss> getRssMutableLiveData() {
//        compositeDisposable.add(
//                iApiService.getRss().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(rss -> {
//                }, throwable -> {
//                    stringMutableLiveData.setValue(throwable.getMessage());
//                })
//        );
//        return rssMutableLiveData;
//    }
//
//    public MutableLiveData<String> getStringMutableLiveData() {
//        return stringMutableLiveData;
//    }
//
//    public void clear(){
//        compositeDisposable.clear();
//    }
//}
