package com.mall.service;

import com.mall.mbg.model.TUser;

import java.util.List;

public interface UserService {
    TUser getUser(int id);
    int deleteUser(int id);
    List<TUser> getAll();
    int addUser(TUser tUser);
    int updateUser(int id, TUser tUser);

    List<TUser> getPageUser(int pageNum, int pageSize);
}
