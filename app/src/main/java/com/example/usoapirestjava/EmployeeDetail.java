package com.example.usoapirestjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class EmployeeDetail extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    int employeeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);

        tv1 = findViewById(R.id.tv_nombre_empleado);
        tv2 = findViewById(R.id.tv_edad_empleado);
        tv3 = findViewById(R.id.tv_salario_empleado);

        employeeId = getIntent().getIntExtra("id",-1);
        System.out.println(employeeId + "*********************************id");
        new LoadEmployeeDetail().execute();
    }
    private class LoadEmployeeDetail extends AsyncTask<String, Void, String> {
        EmployeeEntity employeeEntity;

        //Aqui se esta accediendo a la BD de ROOM para luego mostrar por pantalla
        @Override
        protected String doInBackground(String... strings) {
            employeeEntity = EmployeeApp.databaseApp.employeeDAO().getEmployeeById(employeeId);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            tv1.setText(employeeEntity.getEmployee_name());
            tv2.setText(Integer.toString(employeeEntity.getEmployee_age()));
            tv3.setText(Integer.toString(employeeEntity.getEmployee_salary()));
        }
    }

}