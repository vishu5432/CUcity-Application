package com.vishugahlot.cucity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.messaging.FirebaseMessaging;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.navigation.findNavController;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.navigateUp;
//import androidx.navigation.ui.setupActionBarWithNavController;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;


public class MainActivity extends AppCompatActivity{

//    FloatingActionButton fb , ex1 ,ex2 , ex3;
//    Animation fbopen , fbclose , rotateopen , rotateclose;

    boolean isOpen= false; // by default it is false

    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fb = (FloatingActionButton) findViewById(R.id.floating_button);
//        ex1 = (FloatingActionButton) findViewById(R.id.extra1);
//        ex2 = (FloatingActionButton) findViewById(R.id.extra2);
//        ex3 = (FloatingActionButton) findViewById(R.id.extra3);

        // animation

//        fbopen = AnimationUtils.loadAnimation(this,R.anim.from_bottom_anim);
//        fbclose = AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim);
//        rotateopen = AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim);
//        rotateclose = AnimationUtils.loadAnimation(this,R.anim.rotate_close_anim);


        // click listener on the main fb

//        fb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                animatefb();
//            }
//        });
//
//        ex1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                animatefb();
//                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//        ex2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                animatefb();
//                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        ex3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                animatefb();
//                Toast.makeText(MainActivity.this,"clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

        //Notification code
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        //topic for notification code
        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfull";
                        if (!task.isSuccessful()) {
                            msg = "failed";
                        }
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });




        // navigation bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        navigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                Fragment fragment =null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.nav_map:
                        fragment = new SecondFragment();
                        break;

                    case R.id.nav_search:
                        fragment = new ThirdFragment();
                        break;

                    case R.id.nav_shop:
                        fragment = new FourthFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });
    }

}