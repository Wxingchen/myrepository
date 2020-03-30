package cn.taoqi.controller;

import cn.hutool.json.JSONUtil;
import cn.taoqi.dto.CommonsException;
import cn.taoqi.dto.Teacher;
import cn.taoqi.dto.User;
import cn.taoqi.emun.ExceptionEnum;
import cn.taoqi.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-27 16:03
 **/
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);
    @Autowired
    private TeacherService teacherService;
    @RequestMapping("/get/{id}")
    public String getTeacher(@PathVariable("id") Integer id, Map<String,Object> map){
        log.info("getTeacher入参信息是：{}",id);
        if (id !=1){
            throw  new CommonsException("id有误的描述",ExceptionEnum.PARAM_ERROR.getMsg(),ExceptionEnum.PARAM_ERROR.getCode());
        }
        Teacher teacher = teacherService.getTeacherById(id);
        log.info("teacher信息是：{}",JSONUtil.toJsonStr(teacher));
        map.put("teacher",teacher);
        return "success";
    }

    @RequestMapping("/getAll")
    public String getAllTeacher(Map<String,Object> map, @RequestParam(value = "pn",defaultValue = "1") Integer pn){
        log.info("getAllTeacher入参信息是pn：{}",pn);
        // 紧跟的这个就是分页查询
        PageHelper.startPage(pn,2);
        List<Teacher> teachers = teacherService.getAllTeacher();
        // 将查询的结果封装到PageInfo对象中  p
        /**
         * pageNum 当前的页码
         * pages 总页码
         * total 总记录数
         * pageSize 每页固定的数据条数
         * size  当前页有几条记录
         * prePage 前一页
         * nextPage 后一页
         *
         * pageInfo.getNavigatepageNums();这个返回的是数据 就是包含的页码数组
         * 连续分页的页码数组 前提是pageInfo(list,6)6表示页面总共展示总共6页
         *  1 2 3 【4】5 6
         */
        PageInfo pageInfo = new PageInfo<>(teachers,6);

        log.info("teacher信息是：{}",JSONUtil.toJsonStr(pageInfo.getNavigatepageNums()));
        map.put("info",pageInfo);
        return "success";
    }


}
