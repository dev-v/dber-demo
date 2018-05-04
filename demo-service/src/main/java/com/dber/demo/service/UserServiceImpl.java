package com.dber.demo.service;

import com.dber.demo.entity.User;
import com.dber.demo.mapper.UserMapper;
import com.dber.platform.mapper.IMapper;
import com.dber.platform.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

  @Autowired
  private UserMapper mapper;

  @Override
  protected IMapper<User> getMapper() {
    return mapper;
  }
}
