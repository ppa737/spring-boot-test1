package com.example.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HelloFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(HelloFilter.class);
    @Override
    public String filterType() {
        log.info("befor router");
        return "pre";
    }

    @Override
    public int filterOrder() {
        log.info("befor router filterOrder");
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run()  {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String s = String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString());
        log.info(s);
        return null;
    }
}
