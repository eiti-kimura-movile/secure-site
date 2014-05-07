package com.movile.project.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class BasicHandlerInterceptor extends HandlerInterceptorAdapter implements InitializingBean {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        printRequestInfo(request);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
        printRequestInfo(request);
        super.postHandle(request, response, handler, modelAndView);
    }

    public void printRequestInfo(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        sb.append("host: ").append(request.getRemoteHost()).append("\n");
        sb.append("uri: ").append(request.getRequestURI()).append("\n");
        sb.append("qstring: ").append(request.getQueryString()).append("\n");
        sb.append("--------------------------").append("\n");
        sb.append("request parameters =>").append("\n");
        
        @SuppressWarnings("unchecked")
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            sb.append("param_name: ").append(paramName).append("\n");

            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                sb.append("\tvalue: ").append(paramValue).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        
    }
}
