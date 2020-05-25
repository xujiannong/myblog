package com.lan.mapper;


import com.lan.domain.Role;
import com.lan.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mr.Xu on 2019/05/28.
 */
public interface UserMapper {
    public User loadUserByUsername(String username);

    List<Role> getRolesByUserId(Integer id);

    int UserReg(@Param("username") String username, @Param("password") String password);

    List<User> getUsersByKeywords(@Param("keywords") String keywords);

    int updateUser(User User);

    int deleteRoleByUserId(Long UserId);

    int addRolesForUser(@Param("UserId") Long UserId, @Param("rids") Long[] rids);

    User getUserById(Long UserId);

    int deleteUser(Long UserId);

    List<User> getAllUsers(@Param("currentId") Long currentId);
}
