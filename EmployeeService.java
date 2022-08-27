package com.arikaran.service;

import com.arikaran.Dto.EmployeeDto;
import com.arikaran.model.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto getUserByid(int id);
    EmployeeDto saveUser(Employee e);
    EmployeeDto updateUser(Employee e);
    void deleteUser(int id);
    List<EmployeeDto>getALl();

}
