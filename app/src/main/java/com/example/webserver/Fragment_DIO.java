package com.example.webserver;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_DIO#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_DIO extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button input_btn0,input_btn1,input_btn2,input_btn3;
    Switch Switch0, Switch1,Switch2,Switch3;
    ImageView img1,img2,img3,img4;
    TextView txt3;
    boolean i = true;

    public Fragment_DIO() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_DIO newInstance(String param1, String param2) {
        Fragment_DIO fragment = new Fragment_DIO();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        //  btn_DIO = (Button) view.findViewById(R.id.btn_DIO);
          img1 = (ImageView) view.findViewById(R.id.gray0);
        img2 = (ImageView) view.findViewById(R.id.gray1);
        img3 = (ImageView) view.findViewById(R.id.gray2);
        img4 = (ImageView) view.findViewById(R.id.gray3);
        Switch0 = (Switch)view.findViewById(R.id.switch_0);
        Switch1 = (Switch)view.findViewById(R.id.switch_1);
        Switch2 = (Switch)view.findViewById(R.id.switch_2);
        Switch3 = (Switch)view.findViewById(R.id.switch_3);

        txt3 = (TextView) view.findViewById(R.id.textView3);


        Switch0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                               @Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                         FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                         DatabaseReference rootRef1 = firebaseDatabase.getReference("test1").child("4");
                             if (isChecked) {
                                 rootRef1.setValue("0");
                             } else {
                                 rootRef1.setValue("1");
                             }
                             rootRef1.addValueEventListener(new ValueEventListener() {
                                 @Override
                               public void onDataChange(@NonNull DataSnapshot snapshot) {
                               String data = snapshot.getValue(String.class);
                                if (data.equals("1")) {
                                     img1.setImageResource(R.drawable.gray);
                                          i = false;
                                } else {
                                    img1.setImageResource(R.drawable.green);
                                    i = true;
                                       }
                                 }

                                 @Override
                                 public void onCancelled(@NonNull DatabaseError error) {
                                 }
                             }); }
        });

        Switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef1 = firebaseDatabase.getReference("test1").child("5");
                if (isChecked) {
                    rootRef1.setValue("0");
                } else {
                    rootRef1.setValue("1");
                }
                rootRef1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String data = snapshot.getValue(String.class);
                        if (data.equals("1")) {
                            img2.setImageResource(R.drawable.gray);
                            i = false;
                        } else {
                            img2.setImageResource(R.drawable.green);
                            i = true;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }); }
        });

        Switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef1 = firebaseDatabase.getReference("test1").child("6");
                if (isChecked) {
                    rootRef1.setValue("0");
                } else {
                    rootRef1.setValue("1");
                }
                rootRef1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String data = snapshot.getValue(String.class);
                        if (data.equals("1")) {
                            img3.setImageResource(R.drawable.gray);
                            i = false;
                        } else {
                            img3.setImageResource(R.drawable.green);
                            i = true;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }); }
        });

        Switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference rootRef1 = firebaseDatabase.getReference("test1").child("7");
                if (isChecked) {
                    rootRef1.setValue("0");
                } else {
                    rootRef1.setValue("1");
                }
                rootRef1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String data = snapshot.getValue(String.class);
                        if (data.equals("1")) {
                            img4.setImageResource(R.drawable.gray);
                            i = false;
                        } else {
                            img4.setImageResource(R.drawable.green);
                            i = true;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }); }
        });


        return view;
    }

}