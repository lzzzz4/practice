package cn.dubidubi.dao;

import cn.dubidubi.model.biliCos;

import java.util.List;

public interface biliCosMapper {
	List<String> selectByPrimaryKey();

	void save(String name);
}