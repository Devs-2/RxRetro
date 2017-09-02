package io.smartsolutions.rxretro.RestApi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Chike on 12/3/2016.
 */

public interface APIService {

 @GET("59920877100000b5075576f7")
   // @GET("599208f4100000b5075576f9")
    Call<ResponseBody> savePostNormal();

//    @POST("/posts")
//    @FormUrlEncoded
//    Call<ResponseBody> savePostNormal(@Field("title") String title,
//                                      @Field("body") String body,
//                                      @Field("userId") long userId);

//     @POST("/posts")
//    @FormUrlEncoded
//     Call<Post> savePostNormal(@Field("title") String title,
//                         @Field("body") String body,
//                        @Field("userId") long userId);

    // RxJava
   /*  @POST("login")
    @FormUrlEncoded
     Observable<ResponseBody> savePostRX(@Field("mobile") String mobile,
                                         @Field("password") String password);*/

//    // RxJava
//    @POST("/posts")
//    @FormUrlEncoded
//    Observable<ResponseBody> savePostRX(@Field("title") String title,
//                                        @Field("body") String body,
//                                        @Field("userId") long userId);

//    // RxJava
//    @POST("/posts")
//    @FormUrlEncoded
//    Observable<Post> savePostRX(@Field("title") String title,
//                                @Field("body") String body,
//                                @Field("userId") long userId);

   /* @POST("/posts")
    Call<Post> savePost(@Body Post post);

    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<Post> updatePost(@Path("id") long id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);

    @DELETE("/posts/{id}")
    Call<Post> deletePost(@Path("id") long id);*/

}
