package com.provoyants.iper.utils;

import com.kittyapplication.core.utils.Applog;
import com.provoyants.iper.model.AttendanceDataResponse;
import com.provoyants.iper.model.DownloadResponse;
import com.provoyants.iper.model.GalleryMainResponse;
import com.provoyants.iper.model.Notice;
import com.provoyants.iper.model.NoticeDetailResponse;
import com.provoyants.iper.model.NoticeResponse;
import com.provoyants.iper.model.NotificationResponse;
import com.provoyants.iper.model.ServerRequest;
import com.provoyants.iper.model.ServerResponse;
import com.provoyants.iper.model.SubGalleryResponse;
import com.provoyants.iper.model.TimetableResponse;
import com.provoyants.iper.rest.RestClient;
import com.provoyants.iper.rest.Singleton;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by MIT on 10/24/2016.
 */
public class APIManager {
    private static final String TAG = APIManager.class.getSimpleName();
    private static APIManager instance = new APIManager();
    private RestClient restClient;
    private Call<ServerResponse<GalleryMainResponse>> mCallPhotosMain;
    private Call<ServerResponse<SubGalleryResponse>> mCallPhotosSub;
    private Call<ServerResponse<NoticeResponse>> mCallNotices;
    private Call<ServerResponse<AttendanceDataResponse>> mCallAttendance;
    private Call<ServerResponse> mCallLogout;
    private Call<ServerResponse<NoticeDetailResponse>> mCallNoticeDetail;
    private Call<ServerResponse<NotificationResponse>> mCallNotification;
    private Call<ServerResponse<Notice>> mCallbackNoticeCount;
    private Call<ServerResponse> mCallbackResetCred;
    private Call<ServerResponse<TimetableResponse>> mCallTimetable;
    private Call<ServerResponse<DownloadResponse>> mCallDownload;

    public static APIManager getInstance() {
        if (instance == null) {
            instance = new APIManager();
        }
        return instance;
    }

    private APIManager() {
        try {
            restClient = Singleton.getInstance().getRestAuthenticatedOkClient();
        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public static void doRegisterId(Callback<ServerResponse> registerCallback, ServerRequest reqRegister) {
        try {
            Call<ServerResponse> callRegister = Singleton.getInstance().
                    getRestAuthenticatedOkClient().registerid(reqRegister);
            callRegister.enqueue(registerCallback);
        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void getPhotosCategory(Callback<ServerResponse<SubGalleryResponse>>
                                          categoryGalleryMainCallBack, ServerRequest object) {
        try {
            mCallPhotosSub = restClient.photoscategory(object);
            mCallPhotosSub.enqueue(categoryGalleryMainCallBack);
        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void getPhotos(Callback<ServerResponse<GalleryMainResponse>> categoryGalleryMainCallBack,
                          ServerRequest object) {
        try {
            mCallPhotosMain = restClient.photos(object);
            mCallPhotosMain.enqueue(categoryGalleryMainCallBack);
        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void cancelApiCall() {
        try {
            if (mCallPhotosMain != null || mCallPhotosSub != null) {
                if (!mCallPhotosMain.isCanceled()) {
                    mCallPhotosMain.cancel();
                    mCallPhotosMain = null;
                } else if (!mCallPhotosSub.isCanceled()) {
                    mCallPhotosSub.cancel();
                    mCallPhotosSub = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getNotices(Callback<ServerResponse<NoticeResponse>> noticesCallback,
                           ServerRequest request) {
        try {
            mCallNotices = restClient.notices(request);
            mCallNotices.enqueue(noticesCallback);
        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void getAttendance(Callback<ServerResponse<AttendanceDataResponse>> attendanceCallBack,
                              ServerRequest request) {
        try {
            mCallAttendance = restClient.attendance(request);
            mCallAttendance.enqueue(attendanceCallBack);
        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void logout(Callback<ServerResponse> logoutCallback, ServerRequest request) {
        try {

            mCallLogout = restClient.logout(request);
            mCallLogout.enqueue(logoutCallback);

        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void getNoticeDetail(Callback<ServerResponse<NoticeDetailResponse>> noticeDetailCallback,
                                ServerRequest request) {
        try {

            mCallNoticeDetail = restClient.noticedetails(request);
            mCallNoticeDetail.enqueue(noticeDetailCallback);

        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void notification(Callback<ServerResponse<NotificationResponse>> callback, ServerRequest request) {
        try {

            mCallNotification = restClient.notifications(request);
            mCallNotification.enqueue(callback);

        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void getNoticeCount(Callback<ServerResponse<Notice>> callback, ServerRequest request) {
        try {

            mCallbackNoticeCount = restClient.notificationscount(request);
            mCallbackNoticeCount.enqueue(callback);

        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void resetCred(Callback<ServerResponse> callback, ServerRequest request) {
        try {

            mCallbackResetCred = restClient.resetcred(request);
            mCallbackResetCred.enqueue(callback);

        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void getTimetable(Callback<ServerResponse<TimetableResponse>> timetableCallback,
                             ServerRequest request) {
        try {
            mCallTimetable = restClient.timetable(request);
            mCallTimetable.enqueue(timetableCallback);
        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }

    public void getDownloads(Callback<ServerResponse<DownloadResponse>> downloadCallback,
                             ServerRequest request) {
        try {
            mCallDownload = restClient.downloads(request);
            mCallDownload.enqueue(downloadCallback);
        } catch (Exception e) {
            Applog.e(TAG, e.getMessage(), e);
        }
    }
}
