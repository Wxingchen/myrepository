package cn.taoqi.commons;

import cn.hutool.core.util.StrUtil;
import cn.taoqi.controller.TeacherController;
import cn.taoqi.dto.CommonsException;
import cn.taoqi.emun.ExceptionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-28 22:43
 * 把字符串转换为日期
 **/
public class StringToDateConverter implements Converter<String,Date> {
    private static final Logger log = LoggerFactory.getLogger(StringToDateConverter.class);

    /**
     *
     * @param source 传入进来的值
     * @return
     */
    @Override
    public Date convert(String source) {
        // 判断传过来的是否有值 没得话直接抛出自定义的异常
        if (null == source || ""==source){
            log.error("日期转换时传的参数是空....");
            throw  new CommonsException("传值错误！",ExceptionEnum.PARAM_IS_NULL.getCode(),ExceptionEnum.PARAM_IS_NULL.getMsg());
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(source);

        } catch (ParseException e) {
            log.error("时间参数转换异常:{}",e.getMessage());
            StringWriter stringWriter = new StringWriter();
            PrintWriter pw = new PrintWriter(stringWriter);
            e.printStackTrace(pw);
            throw new CommonsException(stringWriter.toString(),"9993","解析异常");
        }
        return date;
    }
}
