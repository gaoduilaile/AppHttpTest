package shike.apphttptest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Created by Administrator on 2017/7/23.
 */

public interface ApiService {

    /*表单提交数据，返回内容未知*/
    @Headers({
            "osType: 3"
    })
    @FormUrlEncoded
    @POST("user/login")
    Call<ResponseBody> login(@Field("account") String count, @Field("password") String password);


    @Headers({
            "osType: 3"
    })
    @FormUrlEncoded
    @POST("user/register")
    Call<ResponseBody> register(@Field("account") String account, @Field("password") String password);


    @Headers({
            "osType: 3",
    })
    @POST("user/getInfo")
    Call<ResponseBody> getInfo(@Header("token") String token);


    @Headers({
            "osType: 3"
    })
    @FormUrlEncoded
    @POST("user/update")
    Call<ResponseBody> update(
            @Header("token") String token,
            @Field("avaterUrl") String avaterUrl,
            @Field("name") String name,
            @Field("age") String age,
            @Field("sex") String sex,
            @Field("stature") String stature,
            @Field("region") String region,
            @Field("visionStatus") String visionStatus,
            @Field("introduction") String introduction);

    /*返回一个对象*/
//    @GET("onebox/weather/query?cityname=深圳")
//    Call<WeatherDataBean> getWeather(@Query("key") String key);

   /*返回一个对象*/
//   @GET("api/data/Android/10/{page}")
//   Call<GankBean> getAndroidInfo(@Path("page") int page);

    /**/
//    @GET("onebox/weather/query?")
//    Call<WeatherDataBean> getWeather(@QueryMap Map<String, String> params);


}
