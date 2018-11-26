package com.example.cedri_000.thomasianjourney;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class homepage extends AppCompatActivity {
    private int[] mImages = new int[] {
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic3

    };

    private String[] mImagesTitle = new String[] {
            "Pic 1", "Pic 2", "Pic 3"
    };

    ListView list;
    String dates [] = {"Nov 29", "Dec 03", "Dec 04", "Dec 21"};
    String titles[] = {"Recollection 2CSA, 2ITA, 2ITB, 2ISA", "Lighting Ceremony", "UST Christmas Concert", "Paskuhan"};
    String descriptions[] = {"Thursday, 7:00AM, UST Medicine Auditorium ", "Monday, 5:30PM, UST Campus", "Tuesday, 7:00PM, UST Chapel", "Friday, 3:00PM, Grandstand"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(homepage.this, mImagesTitle[position], Toast.LENGTH_SHORT).show();
            }
        });

        list = findViewById(R.id.list1);

        //create instance of class MyAdapter
        MyAdapter adapter = new MyAdapter(this, dates, titles, descriptions);

        list.setAdapter(adapter);


        //handle item clicks

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==0){
                    Toast.makeText(homepage.this, "Item One Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==1){
                    Toast.makeText(homepage.this, "Item Two Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(homepage.this, "Item Three Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==3){
                    Toast.makeText(homepage.this, "Item Four Clicked...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myDates[];
        String myTitles[];
        String myDescriptions[];

        MyAdapter(Context c, String[] dates, String[] titles, String[] descriptions){
            super(c,R.layout.row, R.id.text1, titles);
            this.context=c;
            this.myDates=dates;
            this.myTitles=titles;
            this.myDescriptions=descriptions;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            Button myDate = row.findViewById(R.id.button1);
            TextView myTitle = row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);
            myDate.setText(dates[position]);
            myTitle.setText(titles[position]);
            myDescription.setText(descriptions[position]);
            return row;

        }
    }

    public void ViewEvents (View v) {
        Intent intent = new Intent(this, TabbedEvents.class);
        startActivity(intent);
    }

}

