package  com.example.webserver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;


import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;


import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private EditText edt1;
    private EditText edt2;
    private Fragment fragment0, fragment1, fragment2, fragment3;
    private Button play_btn, stop_btn;

    final ArrayList<Integer> list = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_btn = (Button) findViewById(R.id.Play);
        stop_btn = (Button) findViewById(R.id.Stop);

        fragment0 = new Fragment_InOutput();
        fragment1 = new Fragment_temp();
        fragment2 = new Fragment_Graph();
        fragment3 = new Fragment_DIO();

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment0).commit();
        TabLayout tabs = (TabLayout) findViewById(R.id.tablayout);
        list.add(R.drawable.outline_home_black_24dp);
        list.add(R.drawable.outline_thermostat_black_24dp);
        list.add(R.drawable.outline_show_chart_black_24dp);
        list.add(R.drawable.gray);

        tabs.setTabTextColors(Color.rgb(255, 255, 255), Color.rgb(249, 170, 51));
        for (int i = 0; i < 4; i++) {
            tabs.getTabAt(i).setIcon(list.get(i));
        }
        tabs.setTabIconTint(ColorStateList.valueOf(Color.rgb(255, 255, 255)));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                @SuppressLint("ResourceType")

                int position = tab.getPosition();
                @SuppressLint("ResourceType") int tabIconColor = (Color.rgb(249, 170, 51));
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

                Fragment selected = null;
                if (position == 0) {
                    selected = fragment0;

                } else if (position == 1) {

                    selected = fragment1;


                } else if (position == 2) {

                    selected = fragment2;


                } else if (position == 3) {
                    selected = fragment3;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame, selected).commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor2 = getResources().getColor(R.color.white);
                tab.getIcon().setColorFilter(tabIconColor2, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference("Start_Controller");
                int data = 1;
                rootRef.setValue(data);
                createNofitication_start();
            }
        });
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef = firebaseDatabase.getReference("Start_Controller");
                int data = 0;
                rootRef.setValue(data);
                createNofitication_stop();

            }
        });
    }

    public void clicked(View view) {
        String data = edt2.getText().toString();  // edt 텍스트 문자열 data에저장

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();  // 웹서버의 참조 저장

        DatabaseReference rootRef = firebaseDatabase.getReference("test2").child("0");
        rootRef.setValue(data);
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue(String.class);
                Fragment fragment0 = new Fragment_InOutput();
                Bundle bundle = new Bundle();
                bundle.putString("value", "123");
                fragment0.setArguments(bundle);
                edt1.setText(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

// 1초 100개 랩뷰 데이터 전송 - 웹서버 데이터 전송 측정 /  넣었을때 웹서버 부하나 안드로이드 부하

// 탭이나 서브 패널 , 그래프 , 가로 세로 , UI  - 쉬운방향으로


    }

    private void createNofitication_start() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");
        builder.setSmallIcon(R.mipmap.ic_launcher_sw);
        builder.setContentTitle("측정이 시작되었습니다");
        builder.setContentText("측정중입니다");

        builder.setColor(Color.RED);
        builder.setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            {
                notificationManager.createNotificationChannel(new NotificationChannel("default", "기본채널", NotificationManager.IMPORTANCE_HIGH));
            }
            notificationManager.notify(1, builder.build());
        }
    }
    private void createNofitication_stop() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");
        builder.setSmallIcon(R.mipmap.ic_launcher_sw);
        builder.setContentTitle("측정이 종료되었습니다.");
        builder.setContentText("측정 종료");

        builder.setColor(Color.RED);
        builder.setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            {
                notificationManager.createNotificationChannel(new NotificationChannel("default", "기본채널", NotificationManager.IMPORTANCE_HIGH));
            }
            notificationManager.notify(1, builder.build());
        }
    }
}