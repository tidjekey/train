package com.example.train.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("userId")
    @Expose
    public String userId;

    @SerializedName("firstName")
    @Expose
    public String firstName;

    @SerializedName("lastName")
    @Expose
    public String lastName;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("avatar")
    @Expose
    public String avatar;
}
