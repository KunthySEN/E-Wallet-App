package com.example.welcome;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {
    ListView listView;
    String mtitle[]= {"men","thy","vun","sana","men"};
    String mdescription[] ={"men desc","thy desc","vun smosne","sana bek ngang","men desc"};
    int images[] = {R.drawable.daipi,R.drawable.rose,R.drawable.sad,R.drawable.glasses,R.drawable.daipi};
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_show);

        listView = findViewById(R.id.list_item);

        MyAdapter adapter = new MyAdapter( this,mtitle,mdescription,images);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if(position == 0){
//                    Toast.makeText(ShowActivity.this,"thy desc", Toast.LENGTH_SHORT).show();
//                };
//                if(position == 0){
//                    Toast.makeText(ShowActivity.this,"vun desc", Toast.LENGTH_SHORT).show();
//                };
//                if(position == 0){
//                    Toast.makeText(ShowActivity.this,"sana desc", Toast.LENGTH_SHORT).show();
//                };
//                if(position == 0){
//                    Toast.makeText(ShowActivity.this,"men desc", Toast.LENGTH_SHORT).show();
//                };
//            }
//        });
    };

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rimage[];
        MyAdapter(Context c, String title[], String description[], int imgs[]){
            super(c,R.layout.row, R.id.main_text,title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rimage = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.main_text);
            TextView myDesc = row.findViewById(R.id.sub_text);

            images.setImageResource(rimage[position]);
            myTitle.setText(rTitle[position]);
            myDesc.setText(rDescription[position]);


            return row;
        }
    };
}