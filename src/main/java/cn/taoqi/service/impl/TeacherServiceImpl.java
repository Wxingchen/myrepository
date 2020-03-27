package cn.taoqi.service.impl;

import cn.taoqi.dao.TeacherDao;
import cn.taoqi.dto.Teacher;
import cn.taoqi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-27 15:35
 **/
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherDao.getAllTeacher();
    }
}
