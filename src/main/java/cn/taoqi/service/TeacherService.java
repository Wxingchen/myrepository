package cn.taoqi.service;

import cn.taoqi.dto.Teacher;

import java.util.List;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-27 15:34
 **/
public interface TeacherService {
    Teacher getTeacherById(Integer id);
    List<Teacher> getAllTeacher();
}
