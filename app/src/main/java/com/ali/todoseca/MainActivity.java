package com.ali.todoseca;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ToDoItemAdapter adapter;

    List<ToDoItem> toDoItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoItemList.add(new ToDoItem(1,"Item A","Some text here...", false));
        toDoItemList.add(new ToDoItem(2,"Item B","Some text here...", false));
        toDoItemList.add(new ToDoItem(3,"Item C","Some text here...", false));
        toDoItemList.add(new ToDoItem(4,"Item D","Some text here...", false));

        listView = findViewById(R.id.lstItems);
        adapter = new ToDoItemAdapter();
        adapter.list = toDoItemList;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //toDoItemList.get(position);
            }
        });


        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivityForResult(intent, 345);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("SECACODE","Requestcode= "+ requestCode);

        if(requestCode == 345)
        {

            Log.i("SECACODE","Result code= "+ resultCode);
            if(resultCode != RESULT_CANCELED) {

                String title = data.getStringExtra("Title");
                String desc = data.getStringExtra("DESC");
                boolean bIsComp = data.getBooleanExtra("ISC",false);

                toDoItemList.add(new ToDoItem(toDoItemList.size()+1, title, desc, bIsComp));
                adapter.notifyDataSetChanged();
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        WriteDataToFile();
    }

    void WriteDataToFile()
    {
        //File sdcard = Environment.getExternalStorageDirectory();

        File sdcard = this.getFilesDir();
        Log.i("SADDAM",sdcard.getAbsolutePath());
        File dir = new File(sdcard.getAbsolutePath() + "/SecA/");
        if(dir.exists() != true)
            dir.mkdir();
        File file = new File(dir, "sample.txt");
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);

            //os.write("Some text for file.....".getBytes());
            for (ToDoItem item:toDoItemList  ) {
                os.write(item.toString().getBytes());
            }
            Log.i("SADDAM","Written successfully");
            os.close();
        } catch (IOException e) {

            Log.i("SADDAM",e.getMessage());
            e.printStackTrace();
        }
    }

    void ReadFromFile()
    {
        File sdcard = getFilesDir();
        File dir = new File(sdcard.getAbsolutePath() + "/text/");
        //dir.mkdir();
        if(dir.exists()) {
            File file = new File(dir, "sample.txt");
            FileInputStream is = null;
            try {
                is = new FileInputStream(file);
                int byteCount = 0;
                StringBuilder stringBuilder = new StringBuilder();
                do {
                    byte[] buffer = new byte[1024];
                    byteCount = is.read(buffer);
                    stringBuilder.append(new String(buffer));
                } while (byteCount != -1);
                Log.i("SADDAM", stringBuilder.toString());
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mnu_context, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        Intent intent;
        switch(item.getItemId()) {
            case R.id.mnuNew:
                //Bundle dataBundle = new Bundle();
                //dataBundle.putInt("id", 0);
                intent = new Intent(getApplicationContext(),DrawActivity.class);
                //intent.putExtras(dataBundle);
                startActivity(intent);
                return true;
            case R.id.mnuSettings:
                intent = new Intent(getApplicationContext(), SettingsActivity.class);
                //intent.putExtras(dataBundle);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}