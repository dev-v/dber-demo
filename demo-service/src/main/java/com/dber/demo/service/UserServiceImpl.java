package com.dber.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dber.platform.mapper.IMapper;
import com.dber.platform.service.AbstractService;
import com.dber.demo.api.entity.User;
import com.dber.demo.mapper.UserMapper;

/**
 * <li>文件名称: UserService.java</li>
 * <li>修改记录: ...</li>
 * <li>内容摘要: ...</li>
 * <li>其他说明: ...</li>
 * 
 * @version 1.0
 * @since 2017年12月20日
 * @author dev-v
 */
@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	protected IMapper<User> getMapper() {
		return this.mapper;
	}

}
