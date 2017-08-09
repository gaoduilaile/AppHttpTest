package shike.apphttptest;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/7/23.
 */

public class RetrofitUtils {
    //    private static String BASE_URL = "http://krvision2.wx.jaeapp.com/";
//    public static final String BASE_URL = "http://10.10.10.46:8080/VisionCircle/";
    private static String BASE_URL = "http://vc.krvision.cn:8080/VisionCircle/";
    private static String TAG = "HttpUtils;";


    private static OkHttpClient getOkHttpClient() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("aaa", "message====" + message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

             /*拦截器，设置头文件,缓存*/
        OkHttpClient.Builder builder = new OkHttpClient.Builder();


//        builder .addInterceptor(new Interceptor() {
//                    @Override
//                    public okhttp3.Response intercept(Chain chain) throws IOException {
//                        Request request = chain.request();
//                        Request compressedRequest = request.newBuilder()
//                                .header("Content-Type", "application/x-www-form-urlencoded")
//                                .header("osType", "3")
//                                .build();
//                        Log.i("zzz", "request====111111111111111111111111111111");
//                        Log.i("zzz", "request====" + request.headers().toString());
//                        okhttp3.Response proceed = chain.proceed(request);
//                        Log.i("zzz", "proceed====" + proceed.headers().toString());
//                        return proceed;
//                    }
//                })
//                .addInterceptor(httpLoggingInterceptor);

        /**
         * 设置cookie
         */
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        builder.cookieJar(new JavaNetCookieJar(cookieManager));

          /* 设置超时和重连*/
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);

        return builder.build();
    }


    public static ApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                //设置Json转换器
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        return apiService;
    }

    public static void login(final Context context, String account, String password) {
        ApiService apiService = getApiService();
        Call<ResponseBody> call = apiService.login(account, password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {

                        String string = response.body().string();
                        Log.e(TAG, "onResponse: 200 " + string);
                        Gson gson = new Gson();
                        LoginRespondBean bean = gson.fromJson(string, LoginRespondBean.class);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e(TAG, "onResponse: !=200;");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onResponse:   onFailure " + t);
            }
        });
    }

    public static void register(Context context, String account, String password) {
        ApiService apiService = getApiService();
        Call<ResponseBody> call = apiService.register(account, password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {

                    if (response.code() == 200) {
                        //注意response.body().string()中的数据只能获取一次
                        Log.e("onResponsesdf", response.isSuccessful() + "   ;" + response.code() + "  " + response.headers());
                        Log.e("onResponsesdf", response.body().string());
                        Log.e("onResponsesdf", response.raw().toString());
                    } else {
                        Log.e("onResponsesdf", response.isSuccessful() + "   ;" + response.code() + "  " + response.headers());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onResponse:   onFailure " + t);
            }
        });
    }


    public static void getInfo(final Context context, String token) {
        ApiService apiService = getApiService();
        Call<ResponseBody> call = apiService.getInfo(token.trim());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {

                    if (response.code() == 200) {
                        //注意response.body().string()中的数据只能获取一次
                        Log.e("onResponsesdf", response.isSuccessful() + "   ;" + response.code() + "  " + response.headers());
                        Log.e("onResponsesdf", response.body().string());
                        Log.e("onResponsesdf", response.raw().toString());
                    } else {
                        Log.e("onResponsesdf", response.isSuccessful() + "   ;" + response.code() + "  " + response.headers());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onResponse:   onFailure " + t);
            }
        });
    }


    public static void update(String token1, String avaterUrl, String name, String age, String sex
            , String stature, String region, String visionStatus, String introduction, final Func func) {

        String token2 = "kr_v%88";
        StringBuffer buffer = new StringBuffer();
        String tokenStr = buffer.append(token1.trim()).append(token2.trim()).toString().trim();
        String encodedString = Base64.encodeToString(tokenStr.getBytes(), Base64.NO_WRAP);
        Log.e("onResponsesdf", encodedString);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
        ApiService result = retrofit.create(ApiService.class);
        Call<ResponseBody> call = result.update(encodedString, avaterUrl, name, age, sex, stature, region, visionStatus, introduction);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.code() == 200) {
                        //注意response.body().string()中的数据只能获取一次
                        String string = response.body().string();
                        func.onJsonString(string);

                    } else {
                        Log.e("onResponsesdf", response.isSuccessful() + "   ;" + response.code() + "  " + response.headers());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                Log.e("onFailuresdf", throwable.toString());
            }
        });
    }


    public interface Func {
        void onJsonString(String response) throws JSONException;
//        void onError(String response);
//        void onFailure(String response);

    }

}
