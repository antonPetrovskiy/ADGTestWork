package test.dev.axon.com.adgtestwork.screen;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import test.dev.axon.com.adgtestwork.R;

public class SecondScreen extends AppCompatActivity {

    private int id;
    private ImageView img;
    private TextView text1;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        init();
        buttons();
        setUser();
    }

    public void init(){
        id = getIntent().getIntExtra("id",0);
        img = findViewById(R.id.imageProfile);
        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView1);
    }

    public void buttons(){

    }

    public void setUser(){
        Picasso.with(getApplicationContext()).load(FirstScreen.userList.get(id).getPicture().large).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(img);
        text1.setText("My name is");
        text2.setText(FirstScreen.userList.get(id).getName().first + " " + FirstScreen.userList.get(id).getName().last);
    }
}
