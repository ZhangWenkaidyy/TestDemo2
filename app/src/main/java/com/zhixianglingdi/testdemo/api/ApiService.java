package com.zhixianglingdi.testdemo.api;


public interface ApiService {


/*
    @GET("version_client.json")
    Call<String> getUpdataApk();




    */
/**
     判断接受的手机号是否注册
     *http://localhost:8080/yearnfor/inter/login/phoneIsRegister/15855545454
     *//*

    @GET("yearnfor/inter/login/phoneIsRegister/{phone}")
    Call<EaseBean> phoneIsRegister(@Path("phone") String phone);


    */
/**
     * 忘记密码 获取验证码
     * http://localhost:8080/yearnfor/inter/login/mobelSendMessage
     *
     *//*


    @POST("yearnfor/inter/login/mobelSendMessage")
    Call<EaseBean> mobelSendMessage(@Query("str") String str);


    */
/**
     *
     *
     * 注册
     *http://localhost:8080/yearnfor/inter/login/register?str=
     *//*


    @POST("yearnfor/inter/login/register")
    Call<EaseBean> register(@Query("str") String str);


    */
/**
     * 登录
     http://localhost:8080/yearnfor/inter/login/login?
     *//*

    // TODO: 2018/9/11 登录
    @POST("yearnfor/inter/login/login")
    Call<LoginBean> login(@Query("str") String str);


    */
/**
     *
     *注册获取验证码
     *http://localhost:8080/yearnfor/inter/login/mobelSendMessageIsRegister?str=
     *//*


    @POST("yearnfor/inter/login/mobelSendMessageIsRegister")
    Call<EaseBean> mobelSendMessageIsRegister(@Query("str") String str);


    */
/**
     *
     *忘记密码
     http://localhost:8080/yearnfor/inter/login/editPassword?str=
     *//*

    @POST("yearnfor/inter/login/editPassword")
    Call<EaseBean> editPassword(@Query("str") String str);


    */
/***
     *首页活动列表
     * http://39.106.113.252:8085/yearnfor/inter/activity/selectActivityList/1/5/1/4/111/222
     *
     *     type  1:关注2：最新 3：距离远近4：距离进远
     *//*

    @GET("yearnfor/inter/activity/selectActivityList")
    Call<SelectActivityListBean> selectActivityList(
            @Query("pageNumber") String pageNumber,
            @Query("displayNumber") String displayNumber,
            @Query("userId") String userId,
            @Query("type") String type,
            @Query("longitude") String longitude,
            @Query("latitude ") String latitude
    );

    */
/**
     * 首页活动大图
     *
     * http://localhost:8080/yearnfor/inter/activity/indexActivityList/1/5
     *//*

    @GET("yearnfor/inter/activity/indexActivityList/{pageNumber}/{displayNumber}")
    Call<IndexActivityListBean> indexActivityList(
            @Path("pageNumber") String pageNumber,
            @Path("displayNumber") String displayNumber

    );

    */
/**
     *
     *
     * 首页话题大图
     *
     *http://39.106.113.252:8085/yearnfor/inter/topic/indexTopicList/1/5
     *
     *//*

    @GET("yearnfor/inter/topic/indexTopicList/{pageNumber}/{displayNumber}")
    Call<IndexTopicListBean> indexTopicList(
            @Path("pageNumber") String pageNumber,
            @Path("displayNumber") String displayNumber
    );


*/



}