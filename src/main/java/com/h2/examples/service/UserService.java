package com.h2.examples.service;

import com.h2.examples.model.Employee;
import com.h2.examples.model.User;
import com.h2.examples.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getUsersList() {

    List<Employee> employees = (List<Employee>) userRepository.findAll();

    log.info("size of employees {}", employees.size());

    return employees.stream().map(employee -> {
      return User.builder().id(employee.getId().intValue()).
          firstName(employee.getFirstName()).lastName(employee.getLastName()).build();
    }).collect(Collectors.toList());

  }

  public void saveUser(final User user) {
    Employee employee = new Employee();
    employee.setFirstName(user.getFirstName());
    employee.setLastName(user.getLastName());
    employee.setGender("M");

    userRepository.save(employee);
  }

}
