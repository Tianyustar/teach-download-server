package com.teach.download.demo.global;

import com.google.gson.Gson;
import com.teach.download.demo.utils.TResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = "com.teach.download.demo.controller")
public class GlobalControllerAdvice   implements ResponseBodyAdvice {

    /*
     * 此组件是否支持给定的控制器方法返回类型
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return !methodParameter.getGenericParameterType().getTypeName().equals(TResult.class.getTypeName());
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        TResult result = TResult.success(o);

        // (1)如果方法的返回结果是String类，则会调用方法的返回值，调用StringMessageConverter。
        //    而这个Convert只接收String类型的参数，所以再转换成其他类，Convert处理时会出错，所以这里再将TResult转换为String
        // (2)另外一种解决方案是重写StringMessageConvert或添加自己的Convert
        if (o instanceof String) {
            Gson gson = new Gson();
            return gson.toJson(result);
        }

        return result;
    }

}
