package com.prakruthi.ui.ui.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedBackTResponse {

    @SerializedName("status_code")
//    private Boolean status_code;
    private Boolean statusCode;



    @SerializedName("status")
     Boolean status;
    @SerializedName("errorCode")
     int errorCode;
    @SerializedName("msg")
     String msg;

    @SerializedName("message")
    @Expose
     String message;



//    public Boolean isStatus_code() {
//        return status_code;
//    }

    public Boolean isStatusCode() {
        return statusCode;
    }


//    public Boolean getStatusCode() {
//        return statusCode;
//    }

//    public void setStatus_code(Boolean status_code) {
//        this.status_code = status_code;
//    }

    public void setStatusCode(Boolean statusCode) {
        this.statusCode = statusCode;
    }



    public Boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
