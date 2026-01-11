package com.dracarys.customInterceptor.interceptor;


import io.micrometer.common.lang.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CustomInterceptor2 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) {
        System.out.println("PreHandle in CustomInterceptor2");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
        System.out.println("PostHandle in CustomInterceptor2");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object  handler, Exception ex) {
        System.out.println("AfterCompletion in CustomInterceptor2");
    }

}
