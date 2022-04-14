package com.zzm.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("JWT:123123123");
        System.out.println("JWT:123123123");
        String JWT = request.getHeader("Authorization");

        try {
            // 1.校验JWT字符串
            System.out.println("JWT:"+JWT);
            return true;
        }catch (SignatureVerificationException e){
            System.out.println("无效签名");
            e.printStackTrace();
        }catch (TokenExpiredException e){
            System.out.println("token已经过期");
            e.printStackTrace();
        }catch (AlgorithmMismatchException e){
            System.out.println("算法不一致");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("token无效");
            e.printStackTrace();
        }
        return false;
    }

    @Autowired
    private JWTInterceptor userInterceptor;


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }


    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("JWT:123123123q");
        System.out.println("JWT:123123123w");
        registry.addInterceptor(userInterceptor).addPathPatterns("/api/*");
    }
}