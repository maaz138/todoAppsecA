package com.ali.todoseca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class DetailsActivity extends AppCompatActivity {

    EditText  etTitle, etDesc;
    Switch swCompleted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        etTitle = findViewById(R.id.txtTitle);
        etDesc =  findViewById(R.id.txtDescription);
        swCompleted = findViewById(R.id.swCompleted);

        findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = etTitle.getText().toString();
                String desc = etDesc.getText().toString();
                boolean isC = swCompleted.isChecked();

                Intent intent = new Intent();

                intent.putExtra("Title", title);
                intent.putExtra("DESC", desc);
                intent.putExtra("ISC",isC);

                DetailsActivity.this.setResult(RESULT_OK, intent);
                DetailsActivity.this.finish();
            }
        });


    }

    void WriteDatatoFile()
    {
        

    }

}