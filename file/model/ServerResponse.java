package com.provoyants.iper.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dhaval Soneji Riontech on 9/11/16.
 */
public class ServerResponse<T> {
    @SerializedName("status")
    private boolean status;

    @SerializedName("result")
    private T result;

    @SerializedName("switchUserId")
    private String switchUserId;

    @SerializedName("switchUser")
    private boolean isSwitchUser;

    private String limit;

    private String offset;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getSwitchUserId() {
        return switchUserId;
    }

    public void setSwitchUserId(String switchUserId) {
        this.switchUserId = switchUserId;
    }

    public boolean isSwitchUser() {
        return isSwitchUser;
    }

    public void setSwitchUser(boolean switchUser) {
        isSwitchUser = switchUser;
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
}
