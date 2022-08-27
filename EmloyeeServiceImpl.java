package com.arikaran.serviceImpl;

import com.arikaran.Dto.EmployeeDto;
import com.arikaran.exception.ResourceNotFoundException;
import com.arikaran.model.Employee;
import com.arikaran.repository.EmployeeRepository;
import com.arikaran.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmloyeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository empRepo;
    @Override
    public EmployeeDto getUserByid(int id) {

       if(empRepo.findById(id).isEmpty()){
          throw  new ResourceNotFoundException("not found : id"+id);
       }
       else{
           return convertToDto(empRepo.findById(id).get());
       }
    }

    @Override
    public EmployeeDto saveUser(Employee e) {
        return convertToDto(empRepo.save(e));
    }

    @Override
    public EmployeeDto updateUser(Employee e) {
        if (empRepo.findById(e.getId()).isEmpty()) {
            throw new ResourceNotFoundException("no user found to update: "+e.getId());
        }
        else{
            return convertToDto(empRepo.save(e));
        }
    }

    @Override
    public void deleteUser(int id) {

        if (empRepo.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("no user found: "+id);
        }
        else{
            empRepo.deleteById(id);
        }
    }

    @Override
    public List<EmployeeDto> getALl() {
        return empRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public EmployeeDto convertToDto(Employee e){
        EmployeeDto ed = new EmployeeDto();
        ed.setId(e.getId());
        ed.setName(e.getName());
        ed.setSal(e.getSal());

        return ed;
    }
}
