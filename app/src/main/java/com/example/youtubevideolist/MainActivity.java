package com.example.youtubevideolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] vdourlkey = new String[]{
            "YaQh-GLuIwU","VxOJHeFvLZw","l_tJShIF7XY","t9t7x28oZzk","apVKxvdmRXE"
    };
    int length = vdourlkey.length;
    String thumbnailurl1 = "https://img.youtube.com/vi/";
    String thumbnailurl2 = "/hqdefault.jpg";
    String[] ListviewTitle = new String[]{
            "put your preferred video title 1","put your preferred video title 2","put your preferred video title 3","put your preferred video title 4","put your preferred video title 5"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.playlist);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, videoplayerActivity.class);
                intent.putExtra("url", vdourlkey[position]);
                startActivity(intent);
            }
        });
    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.customlist, null);
            ImageView imageView = view.findViewById(R.id.imagelist);
            TextView textView = view.findViewById(R.id.titlelist);
            Picasso.get().load(thumbnailurl1+vdourlkey[position]+thumbnailurl2).into(imageView);
            textView.setText(ListviewTitle[position]);
            return view;
        }
    }
}