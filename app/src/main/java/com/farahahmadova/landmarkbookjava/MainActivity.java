package com.farahahmadova.landmarkbookjava;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.farahahmadova.landmarkbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ArrayList<Landmark>landmarkArrayList;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressWarnings("Convert2Lambda")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        RecyclerView recyclerView=findViewById(R.id.myrecyclerView);
        //Data
        landmarkArrayList = new ArrayList<>();

        Landmark pisa = new Landmark("Pisa", "Italy", R.drawable.pisa);
        Landmark eiffel = new Landmark("Eiffel", "France", R.drawable.eiffel);
        Landmark colosseum = new Landmark("Colosseum", "Italy", R.drawable.colosseum);
        Landmark londonBridge = new Landmark("London Bridge", "UK", R.drawable.londonbridge);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(londonBridge);

        //RecyclerView

        binding.myrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter=new LandmarkAdapter(landmarkArrayList);
        binding.myrecyclerView.setAdapter(landmarkAdapter);

       /*
        //Adapter
        //Listview
        //mapping


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
        landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,landmarkArrayList.get(position).name,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));
                startActivity(intent);
            }
        });
         */
         }

    }