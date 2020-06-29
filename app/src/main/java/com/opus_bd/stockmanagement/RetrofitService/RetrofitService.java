package com.opus_bd.stockmanagement.RetrofitService;


import com.opus_bd.stockmanagement.Model.CurrentFebricDetails;
import com.opus_bd.stockmanagement.Model.DashBoard.AllStorageDetailsInfo;
import com.opus_bd.stockmanagement.Model.FabricDetails;
import com.opus_bd.stockmanagement.Model.FinishFabricStorageByRecevedNo;
import com.opus_bd.stockmanagement.Model.GrayFabric.GrayFebricDetails;
import com.opus_bd.stockmanagement.Model.GrayFabric.MultipleRollRackInModel;
import com.opus_bd.stockmanagement.Model.GrayFabric.RackIn.GrayFabricRackingList;
import com.opus_bd.stockmanagement.Model.GrayFabric.RackOut.Rackout;
import com.opus_bd.stockmanagement.Model.GrayFabric.RackOut.RackoutById;
import com.opus_bd.stockmanagement.Model.GrayFabric.ReceivedGrayFabric;
import com.opus_bd.stockmanagement.Model.GrayFabric.Scan.GrayRollDetailInfo;
import com.opus_bd.stockmanagement.Model.GrayFabric.StockIn.GrayFabricStorageList;
import com.opus_bd.stockmanagement.Model.LoginResponce;
import com.opus_bd.stockmanagement.Model.Stockout.GetFinishFabricListForIssue;
import com.opus_bd.stockmanagement.Model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface RetrofitService {
    @POST("api/AccountInfo/LogIn")
    Call<LoginResponce> login(@Body UserModel userModel);


    //Gray fabric
    @GET("api/GrayFabric/GetGrayFabricStorageList")
    Call<GrayFabricStorageList> GetGrayFabricStorageList(@Header("Authorization") String token);

    @GET("api/GrayFabric/GetGrayFabricRackingList")
    Call<GrayFabricRackingList> GetGrayFabricRackingList(@Header("Authorization") String token);


    @GET("api/GrayFabric/GetAllCurrentGrayFebricDetailsByReceiveIdApi/{Id}")
    Call<GrayFebricDetails> GetAllCurrentGrayFebricDetailsByReceiveIdApi(@Header("Authorization") String token, @Path("Id") int id);

    @GET("api/GrayFabric/GetReceivedGrayFabricBeforeRackIn")
    Call<List<ReceivedGrayFabric>> GetReceivedGrayFabricBeforeRackIn(@Header("Authorization") String token);

    @GET("api/GrayFabric/GetGrayRollDetailInfo/{rollNo}")
    Call<GrayRollDetailInfo> GetGrayRollDetailInfo(@Header("Authorization") String token, @Path("rollNo") String rollNo);
    @GET("api/GrayFabric/GetReceivedGrayFabricStorageList  ")
    Call<List<ReceivedGrayFabric>> GetReceivedGrayFabricStorageList(@Header("Authorization") String token);


    @GET("api/GrayFabric/RackOutGrayFabricsListAPI")
    Call<Rackout> RackOutGrayFabricsListAPI(@Header("Authorization") String token);


    @GET("api/GrayFabric/GrayFabricRackOutEditListAPI/{id}")
    Call<RackoutById> GrayFabricRackOutEditListAPI(@Header("Authorization") String token, @Path("id") int id);


    @PUT("api/GrayFabric/GrayFabricRackOutEditAPI/{detailsId}")
    Call<String> GrayFabricRackOutEditAPI(@Header("Authorization") String token, @Path("detailsId") int id);

    @PUT("api/GrayFabric/UpdateGrayFabricReceiveStatusAPI/{rackId}/{detailsId}")
    Call<String> UpdateGrayFabricReceiveStatusAPI(@Header("Authorization") String token, @Path("rackId") int masterId, @Path("detailsId") int id);



    @PUT("api/GrayFabric/UpdateGrayFabricReceiveStatusAndLocationAPI/{detailsId}/{qrCode}")
    Call<String> UpdateGrayFabricReceiveStatusAndLocationAPI(@Header("Authorization") String token, @Path("detailsId") int detailsId, @Path("qrCode") String qrCode);

    //Finished fabric




    @GET("api/FinishFabric/GetFinishFabricReceivedList")
    Call<FabricDetails> GetFinishFabricReceivedList(@Header("Authorization") String token);

    @GET("api/FinishFabric/GetFinishFabricStorageByRecevedNo/{ID}")
    Call<List<FinishFabricStorageByRecevedNo>> GetFinishFabricStorageByRecevedNo(@Header("Authorization") String token, @Path("ID") int ID);

    @GET("api/FinishFabric/GetAllCurrentFebricDetailsByReceiveId/{id}")
    Call<List<CurrentFebricDetails>> GetAllCurrentFebricDetailsByReceiveId(@Header("Authorization") String token, @Path("id") int id);

    @PUT("api/FinishFabric/UpdateFinishFabricReceiveStatus/{masterId}/{id}/{status}")
    Call<String> UpdateFinishFabricReceiveStatus(@Header("Authorization") String token, @Path("masterId") int masterId, @Path("id") int id, @Path("status") int status);


    //Stock Out

    @GET("api/FinishFabric/GetFinishFabricListForIssue")
    Call<List<GetFinishFabricListForIssue>> GetFinishFabricListForIssue(@Header("Authorization") String token);

    @GET("api/FinishFabric/GetFinishFabricDetailsListForIssueById/{id}")
    Call<List<CurrentFebricDetails>> GetFinishFabricDetailsListForIssueById(@Header("Authorization") String token, @Path("id") int id);

    @GET("api/FinishFabric/GetFinishFabricRackStorageForIssue/{id}")
    Call<List<FinishFabricStorageByRecevedNo>> GetFinishFabricRackStorageForIssue(@Header("Authorization") String token, @Path("id") int id);

    @GET("api/FinishFabric/GetAllStorageDetailsInfo")
    Call<List<AllStorageDetailsInfo>> GetAllStorageDetailsInfo(@Header("Authorization") String token);
//Gray Febric

    @POST("api/GrayFabric/UpdateGrayFabricMultipleRollRackIn")
    Call<String> UpdateGrayFabricMultipleRollRackIn(@Header("Authorization") String token, @Body MultipleRollRackInModel multipleRollRackInModel);

    @PUT("api/GrayFabric/GrayFabricRackOutEditAPI/{derailsId}")
    Call<String> UpdateFinishFabricReceiveStatus(@Header("Authorization") String token, @Path("derailsId") int derailsId);


}
