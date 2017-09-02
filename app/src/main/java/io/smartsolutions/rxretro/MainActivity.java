package io.smartsolutions.rxretro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.smartsolutions.rxretro.RestApi.APIService;
import io.smartsolutions.rxretro.RestApi.ApiUtils;
import io.smartsolutions.rxretro.RestApi.RetrofitCallback;
import io.smartsolutions.rxretro.model.Github;
import io.smartsolutions.rxretro.model.WeatherData;
import io.smartsolutions.rxretro.retro.WeatherService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements RetrofitCallback.WebServiceInterFace {
    public APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);
        Observable<Github> london = weatherService.getGithubData("ahmedrizwan");

        london.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherData -> {
                    Log.e("Current Weather", weatherData.getBio());
                });*/




        mAPIService = ApiUtils.getAPIService();
        mAPIService.savePostNormal().enqueue(new RetrofitCallback(this,this));


    }

    @Override
    public void parseString(String call, String response) {

    }

    @Override
    public void parseString(String call, String response, String url, String methodType) {

    }

    @Override
    public void failResponse(Throwable t) {

    }
}
