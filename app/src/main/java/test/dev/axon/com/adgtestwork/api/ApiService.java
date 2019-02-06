package test.dev.axon.com.adgtestwork.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.dev.axon.com.adgtestwork.entity.UsersList;

public interface ApiService {

    @GET("/api")
    Call<UsersList> getUsers(@Query("page") String page,
                             @Query("results") String results,
                             @Query("seed") String seed);
}
