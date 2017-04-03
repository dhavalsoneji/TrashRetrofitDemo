package com.provoyants.iper.rest;


import com.provoyants.iper.model.AttendanceDataResponse;
import com.provoyants.iper.model.AttendanceResponse;
import com.provoyants.iper.model.DownloadResponse;
import com.provoyants.iper.model.GalleryMainResponse;
import com.provoyants.iper.model.LoginResponse;
import com.provoyants.iper.model.Notice;
import com.provoyants.iper.model.NoticeDetailResponse;
import com.provoyants.iper.model.NoticeResponse;
import com.provoyants.iper.model.NotificationResponse;
import com.provoyants.iper.model.ServerRequest;
import com.provoyants.iper.model.ServerResponse;
import com.provoyants.iper.model.SubGalleryResponse;
import com.provoyants.iper.model.TimetableResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Scorpion .
 */
public interface RestClient {
    @POST("login")
    Call<ServerResponse<LoginResponse>> login(@Body ServerRequest request);

    @POST("photos")
    Call<ServerResponse<GalleryMainResponse>> photos(@Body ServerRequest request);

    @POST("photoscategory")
    Call<ServerResponse<SubGalleryResponse>> photoscategory(@Body ServerRequest request);

    @POST("registerid")
    Call<ServerResponse> registerid(@Body ServerRequest request);

    @POST("notices")
    Call<ServerResponse<NoticeResponse>> notices(@Body ServerRequest request);

    @POST("noticedetails")
    Call<ServerResponse<NoticeDetailResponse>> noticedetails(@Body ServerRequest request);

    @POST("attendance")
    Call<ServerResponse<AttendanceDataResponse>> attendance(@Body ServerRequest request);

    @POST("logout")
    Call<ServerResponse> logout(@Body ServerRequest request);

    @POST("generateCode")
    Call<ServerResponse> generateCode(@Body ServerRequest request);

    @POST("validateCode")
    Call<ServerResponse> validateCode(@Body ServerRequest request);

    @POST("reset")
    Call<ServerResponse> reset(@Body ServerRequest request);

    @POST("notifications")
    Call<ServerResponse<NotificationResponse>> notifications(@Body ServerRequest request);

    @POST("notificationscount")
    Call<ServerResponse<Notice>> notificationscount(@Body ServerRequest request);

    @POST("resetcred")
    Call<ServerResponse> resetcred(@Body ServerRequest request);

    @POST("timetable")
    Call<ServerResponse<TimetableResponse>> timetable(@Body ServerRequest request);

    @POST("downloads")
    Call<ServerResponse<DownloadResponse>> downloads(@Body ServerRequest request);
}
