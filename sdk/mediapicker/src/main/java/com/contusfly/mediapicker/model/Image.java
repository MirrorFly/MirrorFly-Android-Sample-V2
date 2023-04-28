package com.contusfly.mediapicker.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Image implements Parcelable {

    private int id;

    private String path;

    private long imageDate;

    private String categoryName;

    private boolean isVideo;

    public Image(int id, String path,long imageDate, boolean isVideo) {
        this.id = id;
        this.path = path;
        this.imageDate = imageDate;
        this.isVideo = isVideo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getImageDate() {
        return imageDate;
    }

    public void setImageDate(long imageDate) {
        this.imageDate = imageDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.path);
        dest.writeLong(this.imageDate);
        dest.writeByte(this.isVideo ? (byte) 1 : (byte) 0);
        dest.writeString(this.categoryName);
    }

    protected Image(Parcel in) {
        this.id = in.readInt();
        this.path = in.readString();
        this.imageDate = in.readLong();
        this.isVideo = in.readByte() != 0;
        this.categoryName = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }
}

