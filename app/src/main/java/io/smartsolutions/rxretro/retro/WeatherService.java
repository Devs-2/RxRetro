package io.smartsolutions.rxretro.retro;

import io.smartsolutions.rxretro.model.Github;
import io.smartsolutions.rxretro.model.WeatherData;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by shico on 8/6/17.
 */

public interface WeatherService {
/*
    Note: in Retrofit 2.0, the endpoint path string should NOT start with “/”
    @GET("/weather?") --> incorrect
    @GET("weather?")  --> correct
    */
    @GET("weather?")
    Observable<WeatherData> getWeatherData(@Query("q")String city);

    @GET("users/{username}")
    Observable<Github> getGithubData(@Path("username") String userName);
}
