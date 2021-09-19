package TestTree;

/**
 * @author coolestyue
 *  2021/8/30
 * 要努力呀.
 */
public enum SqlTypeEnum {
    THAN(0,">"),LESS(1,"<"),OR(3,"or"),AND(4,"=");

    SqlTypeEnum(Integer code, String des) {
        this.code = code;
        this.des = des;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    private Integer code;
    private String des;


}
