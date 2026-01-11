package com.dracarys.customInterceptor.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class MyFilter1 implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("Myfilter1  starting ");
        chain.doFilter(request, response);
        System.out.println("Myfilter1  end ");
    }

    public void destroy() {
        Filter.super.destroy();
    }

}
