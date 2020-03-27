package cn.taoqi.dao;

import cn.taoqi.dto.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SSM001
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2020-03-27 15:33
 **/

public interface TeacherDao {
    Teacher getTeacherById(Integer id);
    List<Teacher> getAllTeacher();
}
