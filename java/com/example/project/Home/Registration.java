package com.example.project.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project.R;

public class Registration extends AppCompatActivity {

    EditText edt_name , edt_pwd ;
    Button btn_Reg ;
    public DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edt_name =  findViewById(R.id.names);
        edt_pwd = findViewById(R.id.pwds);
        btn_Reg = findViewById(R.id.btn_regs);

        dbHandler = new DBHandler(Registration.this);

        btn_Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String U_name , password ;
                U_name = edt_name.getText().toString();
                password = edt_pwd.getText().toString();

                if(U_name.equals(null) && password.equals(null)){
                    Toast.makeText(Registration.this, "Fill All Data", Toast.LENGTH_SHORT).show();
                }else{
                    dbHandler.addNewUser(U_name, password);
                    Toast.makeText(Registration.this, "New User Added Successfully.", Toast.LENGTH_SHORT).show();
                    edt_pwd.setText("");
                    edt_name.setText("");
                }

            }
        });

    }
}