package com.dracarys.customInterceptor.config;


import com.dracarys.customInterceptor.filter.MyFilter1;
import com.dracarys.customInterceptor.filter.MyFilter2;
import com.dracarys.customInterceptor.interceptor.CustomInterceptor;
import com.dracarys.customInterceptor.interceptor.CustomInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {


//    @Autowired
//    MyFilter2 myFilter2;
//
//    @Bean
//    public FilterRegistrationBean<MyFilter1> customfilter1() {
//        FilterRegistrationBean<MyFilter1> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new MyFilter1());
//        filterRegistrationBean.setOrder(1);
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean<MyFilter2> customfilter2() {
//        FilterRegistrationBean<MyFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(myFilter2);
//        filterRegistrationBean.setOrder(2);
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }
//
//
//    CustomInterceptor customInterceptor1;
//
//    CustomInterceptor2 customInterceptor2;
//
//    @Autowired
//    public AppConfig(CustomInterceptor interceptor1, CustomInterceptor2 interceptor2) {
//        this.customInterceptor1 = interceptor1;
//        this.customInterceptor2 = interceptor2;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(customInterceptor1)
//                .addPathPatterns("/api/*");
//
//
//        registry.addInterceptor(customInterceptor2)
//                .addPathPatterns("/api/*");
//
//    }



}
