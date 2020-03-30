package cn.taoqi.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-29 23:01
 **/
@Controller
@RequestMapping("/user")
public class FileUploadController {
    /**
     * 2 System.out.println(request.getSession().getServletContext().getRealPath("/"));
     *    G:\apache-tomcat-8.5.24\webapps\servlet\
     * @param request
     * @param
     * @param
     * @return
     */

    // 传统的文件上传 注意：测试传统方法之前不要在springmvc中配置文件上传解析器
    @RequestMapping("/commonsUploadFile")
    public String commonsUploadFile(HttpServletRequest request) throws Exception {
        // 获得servlet容器对象 相当于tomcat容器中的水桶容器
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        // 文件即将上传的位置
        System.out.println("realPath-------为："+realPath);
        // 判断路径是否存在 如不存在则创建
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        // 创建下面的2个对象准备解析request里的数据
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        // 开始解析request list集合里装的全是文件项
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            System.out.println("进入list集合中...");
            // 进行判断 当前的文件项是否是上传文件项 还是普通的表单项
            if (fileItem.isFormField()){
                // 是普通表单项
            }else{
                // 上传文件项 获取上传文件的名称
                String name = fileItem.getName();
                System.out.println("开始上传的文件的名称是:"+name);
                String replace = UUID.randomUUID().toString().replace("-", "");
                name = replace+"_"+name;
                // a3c579d2799e4cbbb756b2ff96a6c433_123.jpg
                System.out.println("开始上传的文件的名称是:"+name);
                // 文件开始上传 把文件名为name的上传到realPath路径下
                fileItem.write(new File(realPath,name));
                // 上传临时文件 >10KB则会生成临时文件，小于的话则是在缓存中
                fileItem.delete();
            }
        }
        System.out.println("文件上传成功");
        return "uploadSuccess";
    }


    // MVC文件上传 注意表单的file 域的name ="upload" 必须和方法形参一致
    @RequestMapping("/springmvcUploadFile")
    public String springmvcUploadFile(HttpServletRequest request,@RequestParam("upload") MultipartFile multipartFile) throws Exception{
        // 获得servlet容器对象 相当于tomcat容器中的水桶容器
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        // 文件即将上传的位置
        System.out.println("realPath-------为："+realPath);
        // 判断路径是否存在 如不存在则创建
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        // 获取文件的名字
        String originalFilename = multipartFile.getOriginalFilename();
        String replace = UUID.randomUUID().toString().replace("-", "");
        originalFilename = replace +"_"+originalFilename;
        System.out.println("文件上传成功");
        multipartFile.transferTo(new File(realPath,originalFilename));
        return "uploadSuccess";
    }
    // 跨服务器文件上传
    @RequestMapping("/springmvcCrossUploadFile")
    public String springmvcCrossUploadFile(@RequestParam("upload") MultipartFile multipartFile) throws Exception{
        // 定义文件服务器的路径   webapp目录下的新建uploads
        String crossPath = "localhost:8088/uploads/";

        // 获取文件的名字
        String originalFilename = multipartFile.getOriginalFilename();
        String replace = UUID.randomUUID().toString().replace("-", "");
        originalFilename = replace +"_"+originalFilename;

        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource resource = client.resource(crossPath + originalFilename);
        // 上传文件
        resource.put(multipartFile.getBytes());
        return "uploadSuccess";
    }
}
