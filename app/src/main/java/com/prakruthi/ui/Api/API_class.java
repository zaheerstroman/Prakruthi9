package com.prakruthi.ui.Api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface API_class {



    //payment_gateway.php:---
    @FormUrlEncoded
    @POST(DZ_URL.AKRUTHTEST)
    Call<JsonElement> AKRUTHTEST(@Field("user_id") String user_id , @Field("token") String token , @Field("address") String address,
                                 @Field("product_ids") String product_ids, @Field("total_amount") String total_amount);


//-----
//    paymentSucess:--
//    ----


    //paymentCheck:-----
    @FormUrlEncoded
    @POST(DZ_URL.AKRUTHSI1)
//    Call<JsonElement> AKRUTHTEST1(@Field("user_id") String user_id , @Field("token") String token , @Field("invoice_num") String invoice_num);
    Call<JsonElement> AKRUTHTEST1(@Field("user_id") String user_id , @Field("token") String token , @Field("invoice_id") String invoice_id,@Field("invoice_num") String invoice_num);



    //My Order / Tracking Order
    @FormUrlEncoded
    @POST(DZ_URL.trackingOrders)
//    Call<JsonElement> AKRUTHTEST1(@Field("user_id") String user_id , @Field("token") String token , @Field("invoice_num") String invoice_num);
    Call<JsonElement> TrackOrderStatus(@Field("user_id") String user_id , @Field("token") String token , @Field("cart_id") String cart_id);


    //----------------

    //Feedback
    @FormUrlEncoded
    @POST(DZ_URL.FEEDAKRUTHTEST1)
//    Call<JsonElement> AKRUTHTEST1(@Field("user_id") String user_id , @Field("token") String token , @Field("invoice_num") String invoice_num);
    Call<JsonElement> FEEDAKRUTHTEST1(@Field("user_id") String user_id , @Field("token") String token , @Field("description") String description);




}
