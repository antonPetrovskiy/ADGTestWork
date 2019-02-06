package test.dev.axon.com.adgtestwork.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class User {
    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("name")
    @Expose
    private Name name;
    public Name getName() {
        return name;
    }
    public class Name {
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("first")
        @Expose
        public String first;
        @SerializedName("last")
        @Expose
        public String last;
    }

    @SerializedName("location")
    @Expose
    private Location location;
    public Location getLocation() {
        return location;
    }
    public class Location {
        @SerializedName("street")
        @Expose
        public String street;
        @SerializedName("city")
        @Expose
        public String city;
    }

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("dob")
    @Expose
    private Dob dob;
    public Dob getDob() {
        return dob;
    }
    public class Dob {
        @SerializedName("date")
        @Expose
        public String date;
    }

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("picture")
    @Expose
    private Picture picture;
    public Picture getPicture() {
        return picture;
    }
    public class Picture {
        @SerializedName("large")
        @Expose
        public String large;
        @SerializedName("medium")
        @Expose
        public String medium;
        @SerializedName("thumbnail")
        @Expose
        public String thumbnail;
    }
}
