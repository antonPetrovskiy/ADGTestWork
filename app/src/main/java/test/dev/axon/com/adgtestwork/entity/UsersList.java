package test.dev.axon.com.adgtestwork.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UsersList {
    @SerializedName("results")
    @Expose
    private ArrayList<User> list = new ArrayList<>();


    public ArrayList<User> getUsers() {
        return list;
    }
}
