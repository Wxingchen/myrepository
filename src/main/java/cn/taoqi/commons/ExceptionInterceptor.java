package cn.taoqi.commons;

import cn.hutool.json.JSONUtil;
import cn.taoqi.controller.TeacherController;
import cn.taoqi.dto.CommonsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-27 20:09
 **/
//@ControllerAdvice
public class ExceptionInterceptor implements HandlerExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(ExceptionInterceptor.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        log.info("进入异常拦截组件里....");

        if (e instanceof CommonsException){
            CommonsException exception = (CommonsException) e;
            String desc = exception.getDesc();
            String code = exception.getCode();
            String msg = exception.getMsg();
            Map<String,String> map = new HashMap<>();
            map.put("desc",desc);
            map.put("code",code);
            map.put("msg",msg);
            String jsonStr = JSONUtil.toJsonStr(map);
            log.info("异常信息jsonStr：{}",jsonStr);
            ModelAndView mv = new ModelAndView();
            mv.addObject("exception",jsonStr);
            mv.setViewName("error/err");
            return mv;
        }
        return new ModelAndView("error/error");
    }
}
