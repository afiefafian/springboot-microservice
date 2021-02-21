package com.afiefafian.userservice.service;

import com.afiefafian.userservice.VO.Department;
import com.afiefafian.userservice.VO.ResponseTemplateVo;
import com.afiefafian.userservice.entity.User;
import com.afiefafian.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.getOne(userId);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        ResponseTemplateVo vo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        , Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
