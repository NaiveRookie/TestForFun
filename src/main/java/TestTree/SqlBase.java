package TestTree;

/**
 * @author coolestyue
 * * 2021/8/30
 * 要努力呀.
 */

public class SqlBase {

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public SqlBase(String field, String value, Integer type) {
        this.field = field;
        this.value = value;
        this.type = type;
    }

    public SqlBase() {

    }

    private String field;
    private String value;
    private Integer type;
}
