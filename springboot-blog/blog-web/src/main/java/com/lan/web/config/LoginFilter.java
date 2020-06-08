package com.lan.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lan.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    SessionRegistry sessionRegistry;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        // String verify_code = (String) request.getSession().getAttribute("verify_code");
        //获取存在redis的验证码
        ValueOperations<String, Object> operation = redisTemplate.opsForValue();


        String uuid = request.getParameter("uuid");
        String code = request.getParameter("code");

        String verifyKey = "captcha_codes" + uuid;
        if (operation.get(verifyKey) == null) {
            throw new AuthenticationServiceException("验证码已过期，请刷新后再提交");
        }

        String verify_code = operation.get(verifyKey).toString();

        checkCode(response, code, verify_code);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);
        setDetails(request, authRequest);
        User principal = new User();
        principal.setUsername(username);
       // sessionRegistry.registerNewSession(request.getSession(true).getId(), principal);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

        public void checkCode (HttpServletResponse resp, String code, String verify_code){
            if (code == null || verify_code == null || "".equals(code) || !verify_code.toLowerCase().equals(code.toLowerCase())) {
                //验证码不正确
                throw new AuthenticationServiceException("验证码不正确");
            }
        }
    }
