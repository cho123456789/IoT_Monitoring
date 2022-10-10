package com.example.webserver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.ArrayList;

public class Raw_Data extends AppCompatActivity {
    Spinner spinner;
    final ArrayList<String> list_0 = new ArrayList<String>();
    final ArrayList<String> list_2 = new ArrayList<String>();
    final ArrayList<String> list_3 = new ArrayList<String>();
    final ArrayList<String> list_4 = new ArrayList<String>();
    final ArrayList<String> list_5 = new ArrayList<String>();
    final ArrayList<String> list_6 = new ArrayList<String>();
    final ArrayList<String> list_7 = new ArrayList<String>();
    private int value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        spinner = findViewById(R.id.spinner2);
        ListView listView =(ListView)findViewById(R.id.list_0);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.채널, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = spinner.getSelectedItem().toString();
                if (item.equals("0channel")) {
                    //n1= data;
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("0");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

                String item1 = spinner.getSelectedItem().toString();
                if (item1.equals("1channel")) {
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("1");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                String item2 = spinner.getSelectedItem().toString();
                if (item2.equals("2channel")) {
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("2");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                String item3 = spinner.getSelectedItem().toString();
                if (item3.equals("3channel")) {
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("3");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                String item4 = spinner.getSelectedItem().toString();
                if (item4.equals("4channel")) {
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("4");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                String item5 = spinner.getSelectedItem().toString();
                if (item5.equals("5channel")) {
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("5");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                String item6 = spinner.getSelectedItem().toString();
                if (item6.equals("6channel")) {
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("6");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                String item7 = spinner.getSelectedItem().toString();
                if (item7.equals("7channel")) {
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("7");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
/*  String item1 = spinner.getSelectedItem().toString();
                if (item1.equals("1번 채널")) {
                    FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                    ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list_0);
                    listView.setAdapter(adapter0);
                    DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("temperature").child("1");
                    rootRef_th0.addValueEventListener(new ValueEventListener() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            adapter0.clear();
                            StringBuffer buffer1 = new StringBuffer(0);
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                String data = snapshot1.getValue(String.class);
                                buffer1.append(data);
                                list_0.add(data);
                            }
                            adapter0.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th2 = firebaseDatabase2.getReference("test2").child("2");
                rootRef_th2.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                        }
                        String item = spinner.getSelectedItem().toString();
                        if (item.equals("2번 채널")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString() + "c");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                FirebaseDatabase firebaseDatabase3 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th3 = firebaseDatabase3.getReference("test2").child("3");
                rootRef_th3.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                        }
                        String item = spinner.getSelectedItem().toString();
                        if (item.equals("3번 채널")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString() + "c");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                FirebaseDatabase firebaseDatabase4 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th4 = firebaseDatabase4.getReference("test2").child("4");
                rootRef_th4.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                        }
                        String item = spinner.getSelectedItem().toString();
                        if (item.equals("4번 채널")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString() + "c");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                FirebaseDatabase firebaseDatabase5 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th5 = firebaseDatabase5.getReference("test2").child("5");
                rootRef_th5.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                        }
                        String item = spinner.getSelectedItem().toString();
                        if (item.equals("5번 채널")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString() + "c");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                FirebaseDatabase firebaseDatabase6 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th6 = firebaseDatabase6.getReference("test2").child("6");
                rootRef_th6.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                        }
                        String item = spinner.getSelectedItem().toString();
                        if (item.equals("6번 채널")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString() + "c");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                FirebaseDatabase firebaseDatabase7 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th7 = firebaseDatabase7.getReference("test2").child("7");
                rootRef_th7.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                        }
                        String item = spinner.getSelectedItem().toString();
                        if (item.equals("7번 채널")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString() + "c");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void home_btn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}


