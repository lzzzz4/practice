package cn.dubidubi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.filter.AutoLoad;

import cn.dubidubi.dao.biliCosMapper;
import cn.dubidubi.model.User;
import cn.dubidubi.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	biliCosMapper biliCosMapper;

	@Override
	public void hello(String Username, User user) {
		System.out.println("hello");
	}

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = false, propagation = Propagation.REQUIRED)
	public void save(String name) {
		biliCosMapper.save(name);
		int b = 1 / 0;
	}

}
