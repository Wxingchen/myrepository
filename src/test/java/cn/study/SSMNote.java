package cn.study;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-26 15:12
 **/
public class SSMNote {
    /**
     * 1.0 ssm整合导包
     *     spring:aop\aspects\beans\context\core\expression\jdbc\test\tx
     *            \orm\cglib\weaver\aopalliance\commons-logging(此依赖存在spring-core中)
     *
     *     springmvc:web\webmvc
     *               fileupload\commons-io(此依赖存在在上传里)
     *               jstl\standard
     *               hibernate-validator\hibernate-validator-annotation-processor\(classmate\jboss-logging\validation-api 这三个存在hibernate-validator中)
     *               jackson-databind\jack-core\jackson-annotations(此依赖存在于jackson-databind中)
     *               jackson-mapper-asl这个待定 暂不需要
     *
     *     mybatis:mybatis
     *            \mysql-connector-java\c3p0
     *            slf4j-api\slf4j-log4j12\log4j
     *    mybatis整合包:可以将dao实现加入到容器中 mybatis-spring
     *
     *     其他：hutool-all
     *          kaptcha(验证码)用法的参考地址https://www.cnblogs.com/java-spring/p/7793149.html

     *     注意：依赖冲突 可以在idea 右侧 maven project-----dependencies----小工具show dependencies 查看依赖图---actul size 这是查看实际尺寸
     *          也可结合maven helper 插件 在pom文件的左下测 dependency Ana----conflicts 查看是否有冲突
     *
     *  2.0 写配置
     *      spring:
     *
     *
     *
     *      springmvc:
     *
     *
     *
     *      mybatis:
     *
     *
     *
     *      其他小框架的配置:
     *
     *  3.0
     *    a.配置/的话，url不会拦截诸如：jsp，html ， .action的请求
     *    b. /*，因为这个url会拦截所有请求，包括：.jsp  .html  .action  .do   .css
     *       如果访问以上的资源会报404错误 ，所以配置时，不要用/*， 这个一般是过滤器，配置时候才用的
     *    c.不会拦截诸如 .jsp .html 等资源请求，只会拦截.action请求，所有在spring-mvc.xml中配
     */
}
