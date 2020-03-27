package cn.taoqi.dto;

/**
 * @program: SSM001
 * @description:
 * @author:
 * @create: 2020-03-27 20:11
 **/
public class CommonsException extends RuntimeException {
    private String msg;
    private String code;
    private String desc;

    public CommonsException() {
    }

    public CommonsException(String s, String msg, String code) {
        super("errcode:"+code+",errmsg:"+msg);
        this.msg = msg;
        this.code = code;
        this.desc =s;
    }

    public CommonsException(String desc, Throwable throwable) {
        super(desc,throwable);
        this.desc  = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CommonsException{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
