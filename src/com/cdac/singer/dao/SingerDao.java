package com.cdac.singer.dao;

import com.cdac.singer.model.Singer;

public interface SingerDao {
	
	public boolean insert(Singer s);

	public boolean validate(Singer s);

}
