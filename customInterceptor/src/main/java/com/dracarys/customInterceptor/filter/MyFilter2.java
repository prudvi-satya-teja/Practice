package com.dracarys.customInterceptor.filter;

import jakarta.servlet.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("MyFilter2 starting");
        chain.doFilter(request, response);
        System.out.println("MyFilter2 done");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
