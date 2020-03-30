package cn.taoqi.emun;

/**
 * @program: SSM001
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2020-03-29 01:24
 **/
public enum ExceptionEnum {
    PARAM_ERROR("9990","参数不匹配"),
    PARAM_IS_NULL("9991","参数为空"),
    DATE_CONVERTER_ERROR("9992","日期转换异常");

    private String code;
    private String msg;

    private ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
