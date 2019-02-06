package test.dev.axon.com.adgtestwork.api;

import retrofit2.Call;
import retrofit2.http.GET;
import test.dev.axon.com.adgtestwork.entity.UsersList;

public interface ApiService {

    @GET("/api")
    Call<UsersList> getUsers();
}
