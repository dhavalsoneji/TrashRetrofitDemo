package com.provoyants.iper.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dhaval Soneji Riontech on 9/11/16.
 */
public class ServerRequest extends APIRequest{
    private String password;

    private String limit;

    private String offset;

    private String noticeid;

    private String search;

    private String month;

    private String year;

    private String selectedDate;

    private String yearid;

    private String termid;

    @SerializedName("regid")
    private String regId;

    @SerializedName("categoryid")
    private String categoryId;

    private String otherUsername;

    @SerializedName("message")
    private String sendMessage;

    @SerializedName("feedbackid")
    private String feedbackId;

    @SerializedName("result")
    private List<FeedbackAnswer> answerList;

    @SerializedName("code")
    private String codePwdReset;

    @SerializedName("fromNotice")
    private boolean fromNotice;

    public List<FeedbackAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<FeedbackAnswer> answerList) {
        this.answerList = answerList;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTermid() {
        return termid;
    }

    public void setTermid(String termid) {
        this.termid = termid;
    }

    public String getYearid() {
        return yearid;
    }

    public void setYearid(String yearid) {
        this.yearid = yearid;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(String noticeid) {
        this.noticeid = noticeid;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getOtherUsername() {
        return otherUsername;
    }

    public void setOtherUsername(String otherUsername) {
        this.otherUsername = otherUsername;
    }

    public String getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getCodePwdReset() {
        return codePwdReset;
    }

    public void setCodePwdReset(String codePwdReset) {
        this.codePwdReset = codePwdReset;
    }

    public boolean isFromNotice() {
        return fromNotice;
    }

    public void setFromNotice(boolean fromNotice) {
        this.fromNotice = fromNotice;
    }
}
