package com.example.webserver;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Fragment_Graph extends Fragment {
    private LineChart chart1, chart2 , chart3, chart4;
    private Thread thread;
    TextView txt;
    Button button;
    Spinner spinner;

    public Fragment_Graph() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView txt1;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        chart1 = (LineChart) view.findViewById(R.id.chart1);
        chart1.setDrawGridBackground(true);  // 그리드 선택 - 각 칸 마다 선택가능
        chart1.setBackgroundColor(Color.WHITE);  // 그래프 밖에 배경색
        chart1.setGridBackgroundColor(Color.WHITE); // 그래프 안에 배경색

        chart2 = (LineChart) view.findViewById(R.id.chart2);
        chart2.setDrawGridBackground(true);  // 그리드 선택 - 각 칸 마다 선택가능
        chart2.setBackgroundColor(Color.WHITE);  // 그래프 밖에 배경색
        chart2.setGridBackgroundColor(Color.WHITE); // 그래프 안에 배경색

        chart3 = (LineChart) view.findViewById(R.id.chart3);
        chart3.setDrawGridBackground(true);  // 그리드 선택 - 각 칸 마다 선택가능
        chart3.setBackgroundColor(Color.WHITE);  // 그래프 밖에 배경색
        chart3.setGridBackgroundColor(Color.WHITE); // 그래프 안에 배경색

        chart4 = (LineChart) view.findViewById(R.id.chart4);
        chart4.setDrawGridBackground(true);  // 그리드 선택 - 각 칸 마다 선택가능
        chart4.setBackgroundColor(Color.WHITE);  // 그래프 밖에 배경색
        chart4.setGridBackgroundColor(Color.WHITE); // 그래프 안에 배경색

        button = (Button)view.findViewById(R.id.btn_clear);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chart1.clear();
                chart2.clear();
                chart3.clear();
                chart4.clear();
            }
        });

        chart1.invalidate();
        feedMultiple1();

        chart2.invalidate();
        feedMultiple2();

        chart3.invalidate();
        feedMultiple3();

        chart4.invalidate();
        feedMultiple4();


// description text  - 그래프 설명
        chart1.getDescription().setEnabled(true);
        Description des1 = chart1.getDescription();
        des1.setEnabled(false);

       chart2.getDescription().setEnabled(true);
       Description des2 = chart2.getDescription();
       des2.setEnabled(false);

       chart3.getDescription().setEnabled(true);
       Description des3 = chart3.getDescription();
       des3.setEnabled(false);

       chart4.getDescription().setEnabled(true);
       Description des4 = chart4.getDescription();
       des4.setEnabled(false);


       chart1.highlightValue(null);
        //chart.setScaleMinima(10f, 1f);


// touch gestures (false-비활성화) -- 화면 축소 확대 기능
        chart1.setTouchEnabled(true);
        chart2.setTouchEnabled(true);
        chart3.setTouchEnabled(true);
        chart4.setTouchEnabled(true);


// scaling and dragging (false-비활성화)
        chart1.setDragEnabled(false);  // 드래그 비활성화
        //    chart.setScaleEnabled(false); // 크기 조정 비활성화


//auto scale
        //  chart.setAutoScaleMinMaxEnabled(true);
        //       chart2.setAutoScaleMinMaxEnabled(true);// 자동 크기 조절

//  클릭시 줌
        chart1.setPinchZoom(false);
        chart2.setPinchZoom(false);
        chart3.setPinchZoom(false);
        chart4.setPinchZoom(false);

//X축
        chart1.getXAxis().setDrawGridLines(true);
        chart1.getXAxis().setDrawAxisLine(true);
        chart1.getXAxis().setEnabled(true);

        chart2.getXAxis().setDrawGridLines(true);
        chart2.getXAxis().setDrawAxisLine(true);
        chart2.getXAxis().setEnabled(true);

        chart3.getXAxis().setDrawGridLines(true);
        chart3.getXAxis().setDrawAxisLine(true);
        chart3.getXAxis().setEnabled(true);

        chart4.getXAxis().setDrawGridLines(true);
        chart4.getXAxis().setDrawAxisLine(true);
        chart4.getXAxis().setEnabled(true);


        //     chart2.getXAxis().setDrawGridLines(true);
        //     chart2.getXAxis().setDrawAxisLine(false);
        //     chart2.getXAxis().setEnabled(true);

//Legend
       // Legend l = chart.getLegend();   // 그래프 범례 설정
       // l.setEnabled(true);
       // l.setFormSize(20f); // set the size of the legend forms/shapes
       // l.setTextSize(20f);
        //l.setTextColor(Color.BLACK);

        //      Legend l2 = chart.getLegend();   // 그래프 범례 설정
        //    l2.setEnabled(true);
        //    l2.setFormSize(10f); // set the size of the legend forms/shapes
        //     l2.setTextSize(12f);
        //     l2.setTextColor(Color.RED);


//Y축
        YAxis leftAxis = chart1.getAxisLeft();
        // leftAxis.mAxisMaximum =0f;
        // leftAxis.setEnabled(true);
        //leftAxis.setTextColor(getResources().getColor(R.color.black)); // y축에 대한 글자 표시
       // leftAxis.setDrawGridLines(true); // y축 그리드 라인 표시
       // leftAxis.setGridColor(getResources().getColor(R.color.white));// 그리드 라인 색상 표시
        leftAxis.setAxisMaximum((float) 500);
        leftAxis.setAxisMinimum((float) 0);
        YAxis rightAxis = chart1.getAxisRight();
        rightAxis.setEnabled(false); //

        YAxis leftAxis2 = chart2.getAxisLeft();
        leftAxis2.setAxisMaximum((float) 500);
        leftAxis2.setAxisMinimum((float) 0);
        YAxis rightAxis2 = chart2.getAxisRight();
        rightAxis2.setEnabled(false);


        YAxis leftAxis3 = chart3.getAxisLeft();
        leftAxis3.setAxisMaximum((float) 500);
        leftAxis3.setAxisMinimum((float) 0);
        YAxis rightAxis3 = chart3.getAxisRight();
        rightAxis3.setEnabled(false);


        YAxis leftAxis4 = chart4.getAxisLeft();
        leftAxis4.setAxisMaximum((float) 500);
        leftAxis4.setAxisMinimum((float) 0);
        YAxis rightAxis4 = chart4.getAxisRight();
        rightAxis4.setEnabled(false);

// X축
        class MyAxisValueFormatter extends IndexAxisValueFormatter {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                    long Milltime = ((long) value )* 1000;
                   // long dateTime = TimeUnit.DAYS.toMillis((long) (value) *1000);
                    Date timeMillseconds = new Date(Milltime);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                    return dateFormat.format(timeMillseconds);
            }
        }
                XAxis xAxis = chart1.getXAxis();
                xAxis.isEnabled();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                //xAxis.enableGridDashedLine(1, 1, 0);   // 그래프 레이블 표시
                xAxis.setEnabled(true);
                //xAxis.setDrawLabels(true);
                xAxis.setValueFormatter(new MyAxisValueFormatter());


                XAxis xAxis2 = chart2.getXAxis();
                xAxis2.isEnabled();
                xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
        //xAxis.enableGridDashedLine(1, 1, 0);   // 그래프 레이블 표시
                xAxis2.setEnabled(true);
        //xAxis.setDrawLabels(true);
                xAxis2.setValueFormatter(new MyAxisValueFormatter());

                XAxis xAxis3 = chart3.getXAxis();
                xAxis3.isEnabled();
                xAxis3.setPosition(XAxis.XAxisPosition.BOTTOM);
                //xAxis.enableGridDashedLine(1, 1, 0);   // 그래프 레이블 표시
                xAxis3.setEnabled(true);
                //xAxis.setDrawLabels(true);
                xAxis3.setValueFormatter(new MyAxisValueFormatter());

                XAxis xAxis4 = chart4.getXAxis();
                xAxis4.isEnabled();
                xAxis4.setPosition(XAxis.XAxisPosition.BOTTOM);
                //xAxis.enableGridDashedLine(1, 1, 0);   // 그래프 레이블 표시
                xAxis4.setEnabled(true);
                //xAxis.setDrawLabels(true);
                xAxis4.setValueFormatter(new MyAxisValueFormatter());


// don't forget to refresh the drawing
        chart1.invalidate();
        feedMultiple1();

        chart2.invalidate();
        feedMultiple2();

        chart3.invalidate();
        feedMultiple3();

        chart4.invalidate();
        feedMultiple4();

        return view;
    }

    private void addEntry1(int num) {
        LineData data = chart1.getData();
        if (data == null) {
            data = new LineData();
            this.chart1.setData(data);
        }
        ILineDataSet set = data.getDataSetByIndex(0);
        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }
        data.addEntry(new Entry((float) set.getEntryCount(), (float) num), 0);
        data.notifyDataChanged();
        //data.setDrawValues(true);  - 그래프 플롯 이름 표시
        // let the chart know it's data has change
        this.chart1.notifyDataSetChanged();
        //this.chart.setVisibleXRangeMaximum(10);
        //this.chart.setVisibleXRangeMinimum(1);
        // this automatically refreshes the chart (calls invalidate())
        this.chart1.moveViewTo(data.getEntryCount(), 1f, YAxis.AxisDependency.RIGHT);
    }
    private void addEntry2(int num) {

        LineData data = chart2.getData();
        if (data == null) {
            data = new LineData();
            this.chart2.setData(data);
        }
        ILineDataSet set = data.getDataSetByIndex(0);
        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }
        data.addEntry(new Entry((float) set.getEntryCount(), (float) num), 0);
        data.notifyDataChanged();
        //data.setDrawValues(true);  - 그래프 플롯 이름 표시
        // let the chart know it's data has change
        this.chart2.notifyDataSetChanged();
        //this.chart.setVisibleXRangeMaximum(10);
        //this.chart.setVisibleXRangeMinimum(1);
        // this automatically refreshes the chart (calls invalidate())
        this.chart2.moveViewTo(data.getEntryCount(), 1f, YAxis.AxisDependency.RIGHT);
    }
    private void addEntry3(int num) {

        LineData data = chart3.getData();
        if (data == null) {
            data = new LineData();
            this.chart3.setData(data);
        }
        ILineDataSet set = data.getDataSetByIndex(0);
        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }
        data.addEntry(new Entry((float) set.getEntryCount(), (float) num), 0);
        data.notifyDataChanged();
        //data.setDrawValues(true);  - 그래프 플롯 이름 표시
        // let the chart know it's data has change
        this.chart3.notifyDataSetChanged();
        //this.chart.setVisibleXRangeMaximum(10);
        //this.chart.setVisibleXRangeMinimum(1);
        // this automatically refreshes the chart (calls invalidate())
        this.chart3.moveViewTo(data.getEntryCount(), 1f, YAxis.AxisDependency.RIGHT);
    }
    private void addEntry4(int num) {

        LineData data = chart4.getData();
        if (data == null) {
            data = new LineData();
            this.chart4.setData(data);
        }
        ILineDataSet set = data.getDataSetByIndex(0);
        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }
        data.addEntry(new Entry((float) set.getEntryCount(), (float) num), 0);
        data.notifyDataChanged();
        //data.setDrawValues(true);  - 그래프 플롯 이름 표시
        // let the chart know it's data has change
        this.chart4.notifyDataSetChanged();
        //this.chart.setVisibleXRangeMaximum(10);
        //this.chart.setVisibleXRangeMinimum(1);
        // this automatically refreshes the chart (calls invalidate())
        this.chart4.moveViewTo(data.getEntryCount(), 1f, YAxis.AxisDependency.RIGHT);
    }


    @SuppressLint("ResourceType")
    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "Temp Avg Data");
        set.setLineWidth(3f);   // 그래프 라인 굵기 설정
        set.setDrawValues(false);
        // set.setValueTextColor(getResources().getColor(Color.WHITE));
        set.setColor(Color.rgb(249,170,51));
        set.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        set.setDrawCircles(false);
        set.setDrawHighlightIndicators(false);  /// 커서 없애기
       // set.setColor(R.color.my_color);
        return set;
    }
            private void feedMultiple1() {
                if (thread != null)
                    thread.interrupt();
                final Runnable runnable1 = new Runnable() {
                    @Override
                    public void run() {
                        FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                        DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("test2").child("0");
                        rootRef_th0.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                StringBuffer buffer1 = new StringBuffer(0);
                                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                    String data = snapshot1.getValue(String.class);
                                    buffer1.append(data);
                                    addEntry1(Integer.parseInt(data));
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }

                        });
                    }
                };
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            if(getActivity()!=null)
                                getActivity().runOnUiThread(runnable1);
                            else
                                return;
                            try {
                                Thread.sleep(7000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });
                thread.start();
            }
            private void feedMultiple2() {
                    if (thread != null)
                        thread.interrupt();
                    final Runnable runnable2 = new Runnable() {
                        @Override
                        public void run() {
                            FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                            DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("test2").child("1");
                            rootRef_th0.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    StringBuffer buffer1 = new StringBuffer(0);
                                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                        String data = snapshot1.getValue(String.class);
                                        buffer1.append(data);
                                        addEntry2(Integer.parseInt(data));
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }

                    };
                    thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (true) {
                                if(getActivity()!=null)
                                    getActivity().runOnUiThread(runnable2);
                                else
                                    return;
                                try {
                                    Thread.sleep(7000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    });
                    thread.start();
                }
            private void feedMultiple3() {
               if (thread != null)
            thread.interrupt();
        final Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("test2").child("3");
                rootRef_th0.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                            addEntry3(Integer.parseInt(data));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        };
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if(getActivity()!=null)
                        getActivity().runOnUiThread(runnable3);
                    else
                        return;
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
    }
            private void feedMultiple4() {
        if (thread != null)
            thread.interrupt();
        final Runnable runnable4 = new Runnable() {
            @Override
            public void run() {
                FirebaseDatabase firebaseDatabase0 = FirebaseDatabase.getInstance();
                DatabaseReference rootRef_th0 = firebaseDatabase0.getReference("test2").child("4");
                rootRef_th0.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        StringBuffer buffer1 = new StringBuffer(0);
                        for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                            String data = snapshot1.getValue(String.class);
                            buffer1.append(data);
                            addEntry4(Integer.parseInt(data));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        };
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if(getActivity()!=null)
                        getActivity().runOnUiThread(runnable4);
                    else
                        return;
                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
    }

}

