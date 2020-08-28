package com.lan.web.controller;

import com.lan.domain.RespBean;
import com.lan.utils.VerifyCodeUtils;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录!");
    }

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public Map getCode(HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap();
        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 唯一标识
        String uuid = UUID.randomUUID().toString();
        String verifyKey = "captcha_codes" + uuid;

        ValueOperations<String, Object> operation = redisTemplate.opsForValue();
        operation.set(verifyKey, verifyCode, 2, TimeUnit.MINUTES);

        // 生成图片
        int w = 111, h = 36;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(w, h, stream, verifyCode);
        try {
            map.put("uuid", uuid);
            map.put("img", Base64.encode(stream.toByteArray()));
            map.put("code", 200);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        } finally {
            stream.close();
        }
    }
}
