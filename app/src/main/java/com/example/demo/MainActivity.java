package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;

public class MainActivity<level> extends AppCompatActivity {
    FloatingActionButton btn,next;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView Sugarlevel,respiration,oxygen,glucose,cholestrol,bodytemparature,bloodpressure,Heartrate;
    List data,dataList;

    HashMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.refresh);
        Sugarlevel = findViewById(R.id.Sugarlevel);
        respiration=findViewById(R.id.Respiration);
        oxygen=findViewById(R.id.oxygen);
        cholestrol=findViewById(R.id.Cholestrol);
        bodytemparature=findViewById(R.id.Bodytemparature);
        bloodpressure=findViewById(R.id.Bloodpressure);
        glucose=findViewById(R.id.glocose);
        Heartrate=findViewById(R.id.heartrate);
        next=findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this,Disease.class);
                startActivity(intent);
            }
        });

        getData();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }


    void getData(){

        DocumentReference docRef=db.collection("users").document("Id1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isComplete()) {
                    try{
                        DocumentSnapshot data=task.getResult();
                        HashMap<String,String> da= (HashMap)data.getData();
//                        listSize=dataList.size()-1;
                        Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                        SystemClock.sleep(50);
                        Sugarlevel.setText(da.get("Sugarlevel"));
                        respiration.setText(da.get("respiration").toString());
                        oxygen.setText(da.get("oxygen").toString());
                        cholestrol.setText(da.get("cholestrol").toString());
                        bodytemparature.setText(da.get("bodytemparature").toString());
                        bloodpressure.setText(da.get("bloodpressure").toString());
                        glucose.setText(da.get("glucose").toString());
                        Heartrate.setText(da.get("heartrate").toString());

                    }catch (Exception e){
//                        Toast.makeText(MainActivity.this, "No user Found With This ID", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

}