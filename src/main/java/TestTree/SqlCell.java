package TestTree;

/**
 * @author coolestyue
 * * 2021/8/30
 * 要努力呀.
 */
public class SqlCell extends SqlBase {

    public SqlCell(String field, String value, Integer type, String conditionJson, SqlCell leftChild, SqlCell rightChild, Integer type1) {
        super(field, value, type);
        this.conditionJson = conditionJson;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.type = type1;
    }

    public SqlCell() {

    }

    private String conditionJson;
    private SqlCell leftChild;
    private SqlCell rightChild;
    private Integer type;

    public String getConditionJson() {
        return conditionJson;
    }

    public void setConditionJson(String conditionJson) {
        this.conditionJson = conditionJson;
    }

    public SqlCell getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(SqlCell leftChild) {
        this.leftChild = leftChild;
    }

    public SqlCell getRightChild() {
        return rightChild;
    }

    public void setRightChild(SqlCell rightChild) {
        this.rightChild = rightChild;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


}
