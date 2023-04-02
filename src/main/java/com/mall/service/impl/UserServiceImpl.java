package com.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.mbg.mapper.TUserMapper;
import com.mall.mbg.model.TUser;
import com.mall.mbg.model.TUserExample;
import com.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    TUserMapper tUserMapper;

    public TUser getUser(int id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteUser(int id) {
        return tUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TUser> getAll() {
        return tUserMapper.selectByExample(new TUserExample());
    }

    @Override
    public int addUser(TUser tUser) {
        return tUserMapper.insert(tUser);
    }

    @Override
    public int updateUser(int id, TUser tUser) {
        tUser.setId(id);
        return tUserMapper.updateByPrimaryKeySelective(tUser);
    }

    @Override
    public List<TUser> getPageUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return tUserMapper.selectByExample(new TUserExample());
    }

}
