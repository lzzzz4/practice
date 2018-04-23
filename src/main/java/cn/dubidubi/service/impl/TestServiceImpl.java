package cn.dubidubi.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.druid.filter.AutoLoad;

import cn.dubidubi.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public void hello() {
		System.out.println("hello");
	}

}
