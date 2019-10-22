package com.tReAsures.demo.dao;

import com.tReAsures.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User getUserName(String UserName)throws Exception;
}
