package cn.dubidubi.dao;

import cn.dubidubi.model.biliCos;

public interface biliCosMapper {
	biliCos selectByPrimaryKey(Integer id);

	void save(String name);
}