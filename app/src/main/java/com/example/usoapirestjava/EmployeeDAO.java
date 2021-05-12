package com.example.usoapirestjava;

//ROOM

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EmployeeDAO {

    // DAO para manipular la tabla cake_entity
    @Insert
    public void addEmployee(EmployeeEntity employeeEntity);

    @Query("SELECT * from employee_entity")
    public List<EmployeeEntity> getAllEmployees();

    @Query("SELECT * from employee_entity WHERE id=:id")
    public EmployeeEntity getEmployeeById(int id);





/*

    // DAO para manipular la tabla cake_detail_entity
    @Insert
    public void addCakeDetails(EmployeeEntity cakeDetailEntity);

    @Query("SELECT * from cake_detail_entity WHERE id=:id")
    public EmployeeEntity getCakeDetailsById(int id);
    */

}
