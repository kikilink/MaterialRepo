package com.newbee.material.repo.dao;

import com.newbee.material.repo.domain.User;

public interface IUserDao {

	User getUser(String userName);
}
