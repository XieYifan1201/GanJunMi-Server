package com.train.service;

import com.train.dto.UserLoginDTO;
import com.train.entity.User;

public interface UserService {
    User wxLogin(UserLoginDTO userLoginDTO);
}
