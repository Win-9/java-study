package com.example.interceptor.interceptor;

import com.example.interceptor.annotation.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;


@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url=request.getRequestURI();
        URI uri =UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();


        log.info("request url:{}",url);
        boolean hasAnnotaion=checkAnnotation(handler, Auth.class);
        log.info("has annotation:{}",hasAnnotaion);

        //all Public
        //Auth권한을 가진 요청에 대해서는 세션,쿠키

        if(hasAnnotaion){
            //권한체크
            String query=uri.getQuery();
            if(query.equals("name=steve")){
                return true;
            }
            return false;
        }

        return true;
    }

    public boolean checkAnnotation(Object handler,Class clazz){
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod) handler;

        if(null!=handlerMethod.getMethodAnnotation(clazz)||null!=handlerMethod.getBeanType().getAnnotation(clazz)){
            return true;
        }
        return false;
    }
}
