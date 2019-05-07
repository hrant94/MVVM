package com.armboldmind.mvvmtest.model.requestModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ResponseModel<T> implements Parcelable {
    private Boolean success;
    private T data;
    private List<MessageModel> messages;


    protected ResponseModel(Parcel in) {
        byte tmpSuccess = in.readByte();
        success = tmpSuccess == 0 ? null : tmpSuccess == 1;
        messages = in.createTypedArrayList(MessageModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success == null ? 0 : success ? 1 : 2));
        dest.writeTypedList(messages);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseModel> CREATOR = new Creator<ResponseModel>() {
        @Override
        public ResponseModel createFromParcel(Parcel in) {
            return new ResponseModel(in);
        }

        @Override
        public ResponseModel[] newArray(int size) {
            return new ResponseModel[size];
        }
    };

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageModel> messageModels) {
        this.messages = messageModels;
    }
}