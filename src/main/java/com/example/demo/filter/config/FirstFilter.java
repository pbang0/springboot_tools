package com.example.demo.filter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(filterName = "FirstFilter", urlPatterns = "/first")
@Slf4j
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("进入 FirstFilter.......");
        chain.doFilter(request, response);
        log.info("离开 FirstFilter.......");
    }

    @Override
    public void destroy() {

    }
}
