package test.dev.axon.com.adgtestwork.screen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.dev.axon.com.adgtestwork.R;
import test.dev.axon.com.adgtestwork.UserAdapter;
import test.dev.axon.com.adgtestwork.api.ApiService;
import test.dev.axon.com.adgtestwork.api.RetroClient;
import test.dev.axon.com.adgtestwork.entity.User;
import test.dev.axon.com.adgtestwork.entity.UsersList;

public class FirstScreen extends AppCompatActivity {

    ListView list;
    public static ArrayList<User> userList;
    private static UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        init();
        buttons();
        loadUsers("1", "20", "abc");
    }

    public void init(){
        list = findViewById(R.id.list);
    }

    public void buttons(){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SecondScreen.class);
                intent.putExtra("id",i);
                startActivity(intent);
            }
        });
    }

    public void loadUsers(String page, String results, String seed){
        ApiService api = RetroClient.getApiService();
        Call<UsersList> call = api.getUsers(page,results,seed);

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    userList = response.body().getUsers();
                    adapter = new UserAdapter(getApplicationContext(), userList);
                    if(list!=null)
                        list.setAdapter(adapter);
                    Log.i("GETUSERS" , "OK");
                } else {
                    JSONObject jObjError = null;
                    try {
                        jObjError = new JSONObject(response.errorBody().string());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Log.i("GETUSERS" , jObjError.getString("message")+"1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Log.i("GETUSERS" , t.getMessage()+" ");
            }
        });
    }


}
