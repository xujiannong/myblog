package com.lan.service;

import com.lan.domain.User;
import com.lan.mapper.UserMapper;
import com.lan.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    //@Autowired
   // HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        user.setRoles(userMapper.getRolesByUserId(user.getId()));
        return user;
    }

    public List<User> getAllUsersExceptCurrentHr() {
        return userMapper.getAllUsersExceptCurrentUser(UserUtils.getCurrentUser().getId());
    }

//    public Integer updateHr(Hr hr) {
//        return hrMapper.updateByPrimaryKeySelective(hr);
//    }

//    @Transactional
//    public boolean updateHrRole(Integer hrid, Integer[] rids) {
//        hrRoleMapper.deleteByHrid(hrid);
//        return hrRoleMapper.addRole(hrid, rids) == rids.length;
//    }
//
//    public Integer deleteHrById(Integer id) {
//        return hrMapper.deleteByPrimaryKey(id);
//    }
//
//    public List<Hr> getAllHrsExceptCurrentHr() {
//        return hrMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrentHr().getId());
//    }
//
//    public Integer updateHyById(Hr hr) {
//        return hrMapper.updateByPrimaryKeySelective(hr);
//    }
//
//    public boolean updateHrPasswd(String oldpass, String pass, Integer hrid) {
//        Hr hr = hrMapper.selectByPrimaryKey(hrid);
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (encoder.matches(oldpass, hr.getPassword())) {
//            String encodePass = encoder.encode(pass);
//            Integer result = hrMapper.updatePasswd(hrid, encodePass);
//            if (result == 1) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Integer updateUserface(String url, Integer id) {
//        return hrMapper.updateUserface(url, id);
//    }
}
