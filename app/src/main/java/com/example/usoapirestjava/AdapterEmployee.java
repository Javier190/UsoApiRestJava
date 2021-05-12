package com.example.usoapirestjava;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
        //final Employee employee = employees_list.get(position);
        try {
            holder.nombre.setText(employees_list.get(position).getEmployee_name());
            holder.salary.setText(Integer.toString(employees_list.get(position).getEmployee_salary()));
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