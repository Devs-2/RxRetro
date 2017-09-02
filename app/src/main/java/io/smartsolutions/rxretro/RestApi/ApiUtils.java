package io.smartsolutions.rxretro.RestApi;

/**
 * Created by Chike on 12/4/2016.
 */

public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BASE_URL = "http://www.mocky.io/v2/";//"http://1024-apps.com/maktabti/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
