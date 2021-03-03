package com.example.adapterpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> midList = new ArrayList<String>();
        ListView list = findViewById(R.id.listView1);

        // Context 위치, 디자인, Data jinwoo
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);

        // 버튼, EditText 연결
        final EditText edtItem = findViewById(R.id.edtItem);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // 입력값 리스트 추가 --> 변화됐다고 notify
                midList.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                midList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}