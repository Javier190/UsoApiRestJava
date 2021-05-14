package com.example.usoapirestjava;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdapterEmployee extends RecyclerView.Adapter<AdapterEmployee.ViewHolder> {
    List<Employee> employees_list;
    Context context;

    public AdapterEmployee(List<Employee> employees_list, Context context) {
        this.employees_list = employees_list;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterEmployee.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_employees, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {
            holder.id.setText("ID: " + Integer.toString(employees_list.get(position).getId()));
            holder.nombre.setText("Name: " +employees_list.get(position).getEmployee_name());
            holder.salary.setText("Salary: $" +Integer.toString(employees_list.get(position).getEmployee_salary()));
            holder.age.setText("Age: " +Integer.toString(employees_list.get(position).getEmployee_age()) + " years");



            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Empleado: " + employees_list.get(position).getEmployee_name(), Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, EmployeeDetail.class)
                            .putExtra("id",employees_list.get(position).getId())
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    );
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return employees_list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView nombre;
        public TextView salary;
        public TextView age;
        public TextView profileImg;

        public ViewHolder(View itemView) {
            super(itemView);
            this.id = (TextView) itemView.findViewById(R.id.tv_id);
            this.nombre = (TextView) itemView.findViewById(R.id.tv_name);
            this.salary = (TextView) itemView.findViewById(R.id.tv_salary);
            this.age = (TextView) itemView.findViewById(R.id.tv_age);
            this.profileImg = (TextView) itemView.findViewById(R.id.tv_profileimg);
        }
    }

}