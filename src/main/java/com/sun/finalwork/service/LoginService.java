package com.sun.finalwork.service;

import com.sun.finalwork.bean.User;
import com.sun.finalwork.bean.UserDate;

public interface LoginService {
    UserDate getStuByUserNamePassowrd(User user);
}
