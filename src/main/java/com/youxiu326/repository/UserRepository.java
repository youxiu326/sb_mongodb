package com.youxiu326.repository;

import com.youxiu326.entity.User;

public interface UserRepository {

    public void saveUser(User user);

    public User findUserByUserName(String userName);

    long updateUser(User user);

    void deleteUserById(Long id);

} 