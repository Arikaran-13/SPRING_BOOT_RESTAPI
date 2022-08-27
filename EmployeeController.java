package com.arikaran.controller;


import com.arikaran.Dto.EmployeeDto;
import com.arikaran.model.Employee;
import com.arikaran.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService es;

    @GetMapping("/test")
    public String test() {
        return "Helo world";
    }

    @PostMapping("/save")
    public EmployeeDto createEmployee( @RequestBody Employee e){
        return es.saveUser(e);
    }
    @GetMapping("/{id}")
    public EmployeeDto getEmpById(@PathVariable("id")int id){
        return es.getUserByid(id);
    }
    @GetMapping("/all")
    public List<EmployeeDto>getAll(){
        return es.getALl();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")int id){
        es.deleteUser(id);
    }

    @PutMapping("/update")
    public EmployeeDto update(Employee e){
       return es.updateUser(e);
    }
    @GetMapping("/get")
    public EmployeeDto getByid(@RequestParam("id")int id){
        return es.getUserByid(id);
    }
}
