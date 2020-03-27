package cn.study;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-26 20:24
 **/
public class LOGNote {
    /**
     * 1.0 常用的Appender 前三个
     *   ConsoleAppender 控制台
     *   FileAppender 文件
     *   DailyRollingFileAppender 每天产生一个日志文件
     *   RollingFileAppender 文件大小到达指定尺寸的时候产生一个新的文件
     *   WriterAppender 将日志信息以流的方式发送到任意指定的位置
     * 2.0 layout
     *   PatternLayout 可以灵活的指定布局模式 自定义的
     *   HTMLLayout 以html表格形式布局
     *
     * 3.0 每个appender 后必然跟随layout
     *     每个logger可以指定一个级别，可以引用多个appender
     *     每个appender 可以被多个logger引用
     * 4.0 当 log4j.properties 和log4j.xml 同时存在resources 目录下，日志执行的是xml的配置
     *
     *
     *
     *
     * 5.0 log4j配置mybatis日志
     *   a. web.xml
     *      <context-param>
     *         <param-name>log4jConfigLocation</param-name>
     *         <param-value>classpath:log4j.xml</param-value> 在resources 的直接目录下
     *      </context-param>
     *      <listener>
     *         <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
     *      </listener>
     *   b. mybatis里
     *      <setting name="logImpl " value="LOG4J"/>
     *
     *
     */
}
