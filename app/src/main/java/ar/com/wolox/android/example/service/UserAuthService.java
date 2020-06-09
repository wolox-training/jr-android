package ar.com.wolox.android.example.service;

import java.util.List;

import ar.com.wolox.android.example.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserAuthService {

    @GET("users")
    Call<List<User>> findUserByEmail(@Query("email") String email);
}
