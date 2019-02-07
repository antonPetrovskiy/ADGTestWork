package test.dev.axon.com.adgtestwork.screen;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import test.dev.axon.com.adgtestwork.R;

public class SecondScreen extends AppCompatActivity {

    private int id;
    private ImageView img;
    private TextView text1;
    private TextView text2;
    private ImageView back;

    private ImageView btnName;
    private ImageView btnAddress;
    private ImageView btnBirthday;
    private ImageView btnEmail;
    private ImageView btnPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        init();
        buttons();
        setUser();
        btnName.performClick();
    }

    public void init(){
        id = getIntent().getIntExtra("id",0);
        img = findViewById(R.id.imageProfile);
        back = findViewById(R.id.imageView2);
        text1 = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView1);

        btnName = findViewById(R.id.imageView3);
        btnEmail = findViewById(R.id.imageView4);
        btnBirthday = findViewById(R.id.imageView5);
        btnAddress = findViewById(R.id.imageView6);
        btnPhone = findViewById(R.id.imageView7);
    }

    public void buttons(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnName.setImageResource(R.drawable.name_pressed);
                btnEmail.setImageResource(R.drawable.email);
                btnBirthday.setImageResource(R.drawable.birthday);
                btnAddress.setImageResource(R.drawable.address);
                btnPhone.setImageResource(R.drawable.phone);
                text1.setText("My name is");
                text2.setText(FirstScreen.userList.get(id).getName().first + " " + FirstScreen.userList.get(id).getName().last);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnName.setImageResource(R.drawable.name);
                btnEmail.setImageResource(R.drawable.email_pressed);
                btnBirthday.setImageResource(R.drawable.birthday);
                btnAddress.setImageResource(R.drawable.address);
                btnPhone.setImageResource(R.drawable.phone);
                text1.setText("My email address is");
                text2.setText(FirstScreen.userList.get(id).email);
            }
        });

        btnBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnName.setImageResource(R.drawable.name);
                btnEmail.setImageResource(R.drawable.email);
                btnBirthday.setImageResource(R.drawable.birthday_pressed);
                btnAddress.setImageResource(R.drawable.address);
                btnPhone.setImageResource(R.drawable.phone);
                text1.setText("My birthday is");
                text2.setText(FirstScreen.userList.get(id).getDob().date);
            }
        });

        btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnName.setImageResource(R.drawable.name);
                btnEmail.setImageResource(R.drawable.email);
                btnBirthday.setImageResource(R.drawable.birthday);
                btnAddress.setImageResource(R.drawable.address_pressed);
                btnPhone.setImageResource(R.drawable.phone);
                text1.setText("My address is");
                text2.setText(FirstScreen.userList.get(id).getLocation().street);
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnName.setImageResource(R.drawable.name);
                btnEmail.setImageResource(R.drawable.email);
                btnBirthday.setImageResource(R.drawable.birthday);
                btnAddress.setImageResource(R.drawable.address);
                btnPhone.setImageResource(R.drawable.phone_pressed);
                text1.setText("My phone number is");
                text2.setText(FirstScreen.userList.get(id).phone);
            }
        });
    }

    public void setUser(){
        Picasso.with(getApplicationContext()).load(FirstScreen.userList.get(id).getPicture().large).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(img);
        text1.setText("My name is");
        text2.setText(FirstScreen.userList.get(id).getName().first + " " + FirstScreen.userList.get(id).getName().last);
    }
}
