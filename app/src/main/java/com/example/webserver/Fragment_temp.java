package com.example.webserver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Fragment_temp extends Fragment {

    TextView txt1, txt_data;
    EditText editText;
    Fragment fragment1, fragment4;
    ProgressBar progressBar;
    Spinner spinner;
    Button button_data,button_Start,button_stop;
    private final long time = System.currentTimeMillis();
    final ArrayList<String> list_0 = new ArrayList<String>();

    public Fragment_temp() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        button_data = (Button) view.findViewById(R.id.row_data);
        txt1 = (TextView) view.findViewById(R.id.txt1);
        //  editText = (EditText)view.findViewById(R.id.txt_data);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        spinner = view.findViewById(R.id.spinner);

        if (getArguments() != null) {
            String name = getArguments().getString("name");
            txt1.setText(name);
        }
        button_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Raw_Data.class);
                startActivity(intent);
            }
        });
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.채널, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("test2").child("0");
                rootRef_th0.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                        }
                            String item = spinner.getSelectedItem().toString();
                            if (item.equals("0channel")) {
                                progressBar.setProgress((int) Double.parseDouble(buffer1.toString()));
                                txt1.setText(buffer1.toString());
                            }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                    FirebaseDatabase firebaseDatabase1 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th1 = firebaseDatabase1.getReference("test2").child("1");
                rootRef_th1.addValueEventListener(new ValueEventListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                        }
                        String item = spinner.getSelectedItem().toString();
                        if (item.equals("1channel")) {
                            //n1= data;
                            progressBar.setProgress((int) Double.parseDouble(buffer1.toString()));
                            txt1.setText(buffer1.toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


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
                        if (item.equals("2channel")) {
                            //n1= data;
                            progressBar.setProgress((int) Double.parseDouble(buffer1.toString()));
                            txt1.setText(buffer1.toString());
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
                        if (item.equals("3channel")) {
                            //n1= data;
                            progressBar.setProgress((int) Double.parseDouble(buffer1.toString()));
                            txt1.setText(buffer1.toString());
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
                        if (item.equals("4channel")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString());
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
                        if (item.equals("5channel")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString());
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
                        if (item.equals("6channel")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString());
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
                        if (item.equals("7channel")) {
                            //n1= data;
                            progressBar.setProgress(Integer.parseInt(buffer1.toString()));
                            txt1.setText(buffer1.toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
                return view;
    }
}