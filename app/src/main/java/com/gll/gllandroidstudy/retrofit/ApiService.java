package com.gll.gllandroidstudy.retrofit;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 网络请求
 */
public interface ApiService {


    //baseUrl
    String API_SERVER_URL = "http://maccms.nacy.online";


    @Streaming //大文件时要加不然会OOM
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);


    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);


}
