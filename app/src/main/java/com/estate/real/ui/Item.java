package com.estate.real.ui;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String name, price, publisher, area, time;
    private Uri thumbnail, publisherLogo;

    public Item(String name, String price, String publisher, String area, String time) {
        this.name = name;
        this.price = price;
        this.publisher = publisher;
        this.area = area;
        this.time = time;
    }

    public Item(String name, String price, String publisher, String area, String time, Uri thumbnail, Uri publisherLogo) {
        this.name = name;
        this.price = price;
        this.publisher = publisher;
        this.area = area;
        this.time = time;
        this.thumbnail = thumbnail;
        this.publisherLogo = publisherLogo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Uri getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Uri thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Uri getPublisherLogo() {
        return publisherLogo;
    }

    public void setPublisherLogo(Uri publisherLogo) {
        this.publisherLogo = publisherLogo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.price);
        dest.writeString(this.publisher);
        dest.writeString(this.area);
        dest.writeString(this.time);
        dest.writeParcelable(this.thumbnail, flags);
        dest.writeParcelable(this.publisherLogo, flags);
    }

    protected Item(Parcel in) {
        this.name = in.readString();
        this.price = in.readString();
        this.publisher = in.readString();
        this.area = in.readString();
        this.time = in.readString();
        this.thumbnail = in.readParcelable(Uri.class.getClassLoader());
        this.publisherLogo = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
