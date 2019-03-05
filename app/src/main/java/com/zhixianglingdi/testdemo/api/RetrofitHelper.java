package com.zhixianglingdi.testdemo.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhixianglingdi.testdemo.data.Connector;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/***
 * ----------BigGod be here!----------/
 * ***┏┓******┏┓*********
 * *┏━┛┻━━━━━━┛┻━━┓*******
 * *┃             ┃*******
 * *┃     ━━━     ┃*******
 * *┃             ┃*******
 * *┃  ━┳┛   ┗┳━  ┃*******
 * *┃             ┃*******
 * *┃     ━┻━     ┃*******
 * *┃             ┃*******
 * *┗━━━┓     ┏━━━┛*******
 * *****┃     ┃神兽保佑*****
 * *****┃     ┃代码无BUG！***
 * *****┃     ┗━━━━━━━━┓*****
 * *****┃              ┣┓****
 * *****┃              ┏┛****
 * *****┗━┓┓┏━━━━┳┓┏━━━┛*****
 * *******┃┫┫****┃┫┫********
 * *******┗┻┛****┗┻┛*********
 * ━━━━━━神兽出没━━━━━━
 * <p/>
 * <p/>
 * 项目名称：beetle
 * 类描述：com.csj.beetle.beetle.Api
 * 创建人：kevin
 * 创建时间：2016/12/26
 * 修改人：kevin
 * 修改时间：
 * 修改备注：
 */
public class RetrofitHelper {
    private static volatile RetrofitHelper instance = null;

    private RetrofitHelper() {

    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitHelper.class) {
                if (instance == null) {
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }


    //设置Gson
    public Gson createGson() {
        return new GsonBuilder()
                .serializeNulls()
                .enableComplexMapKeySerialization()
                .setDateFormat("")
                .create();
    }

    public Retrofit createRetrofittoString() {
        return new Retrofit.Builder()
              .baseUrl(Connector.bUrl)
                .client(createHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build();
    }


    public Retrofit createRetrofittoModule() {
        return new Retrofit.Builder()
                .baseUrl(Connector.bUrl)
                .client(createHttpClient2())
               .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build();
    }





    private static int DEFAULT_TIMEOUT = 10;
    public OkHttpClient createHttpClient() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(logInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request=chain.request().newBuilder()
                                .addHeader("Cookie","------")
                                .build();


                        return chain.proceed(request);
                    }
                })
                .build();
        return client;


    }

    public OkHttpClient createHttpClient2() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addNetworkInterceptor(logInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request request=chain.request().newBuilder()
                                .addHeader("name","kevin")
                                .build();


                        return chain.proceed(request);
                    }
                })
                .build();
        return client;


    }


    public ApiService getServiceToString() {
        Retrofit retrofit = createRetrofittoString();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }

    public ApiService getServiceToModule() {
        Retrofit retrofit = createRetrofittoModule();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }




    public class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Log.i("---网络访问接口---", message);
        }
    }






}
