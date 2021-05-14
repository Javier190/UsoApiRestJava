package com.example.usoapirestjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Vamos a hacer un programa que cargue solo la lista de empleados
//Y solo con una activity. por ahora
//Es decir, al iniciar la app que me consuma la API, se guarde esa info en un arraylidt, ademas,
// se guarde en ROOM y tirar los datos a la pantalla cargando el adadpter con el arraylist.

public class MainActivity extends AppCompatActivity {

    List<Employee> lista_empleados;
    EmployeeResponse response_empleados;
    RecyclerView recycler_employees;
    AdapterEmployee adapterEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista_empleados = new ArrayList<Employee>();
        recycler_employees = findViewById(R.id.recycler_employees);
        recycler_employees.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        loadEmployees();
    }

    private void loadEmployees() {
        new LoadEmployees().execute();
    }

    private class LoadEmployees extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                Response<EmployeeResponse> call = getRetrofit().create(APIService.class).getEmployees("employees").execute();
                response_empleados = call.body();
                lista_empleados = response_empleados.getData();
                cargarEmpleadosBD();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        //Agregar empleados a tabla employee_entity ROOM y se agregan uno por uno
        private void cargarEmpleadosBD() {
            try {
                for (int i = 0; i < lista_empleados.size(); i++) {
                    EmployeeApp.databaseApp.employeeDAO().addEmployee(new EmployeeEntity(
                                    lista_empleados.get(i).getId(),
                                    lista_empleados.get(i).getEmployee_name(),
                                    lista_empleados.get(i).getEmployee_salary(),
                                    lista_empleados.get(i).getEmployee_age(),
                                    lista_empleados.get(i).getProfile_image()
                            )
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            adapterEmployee = new AdapterEmployee(lista_empleados, getApplicationContext());
            recycler_employees.setAdapter(adapterEmployee);
        }

        private Retrofit getRetrofit() {
            return new Retrofit.Builder().baseUrl(getString(R.string.endpointEmployees)).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
        }
    }
}