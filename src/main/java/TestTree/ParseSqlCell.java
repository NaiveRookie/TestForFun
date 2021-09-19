package TestTree;

/**
 * @author coolestyue
 * 2021/8/30
 * 要努力呀.
 */
public class ParseSqlCell {

    public static String parseSqlCell(SqlCell sqlCell) {


        return dfs(sqlCell);
    }
    private static String dfs(SqlCell sqlCell) {
        if (sqlCell == null) {
            return "";
        }

        // 当前即为根目录
        String condition = String.valueOf(sqlCell.getType());
        String fin = "";
        if (sqlCell.getLeftChild() == null && sqlCell.getRightChild() == null) {
            fin = sqlCell.getField() + condition + sqlCell.getValue();
            return "(" + fin + ")";
        }

        String left = "";
        if (sqlCell.getLeftChild() != null) {
            left = dfs(sqlCell.getLeftChild());
        }
        String right = "";
        if (sqlCell.getRightChild() != null) {
            right = dfs(sqlCell.getRightChild());
        }

        if (left != "" && right != "") {
            fin = "(" + left + condition + right + ")";
            return fin;
        }
        fin = left == "" ? right : left;
        return "(" + fin + ")";
    }

    public static void main(String[] args) {
        SqlCell root = new SqlCell();
        // 二级部门
        SqlCell twoBg = new SqlCell();
        twoBg.setField("bgname");
        twoBg.setValue("数据中台");
        twoBg.setType(SqlTypeEnum.OR.getCode());
        // 一级部门
        SqlCell oneBg = new SqlCell();
        twoBg.setField("companyName");
        twoBg.setValue("京东零售");
        oneBg.setType(SqlTypeEnum.OR.getCode());
        // 上半部分
        SqlCell left = new SqlCell();
        left.setLeftChild(twoBg);
        left.setRightChild(oneBg);
        left.setType(SqlTypeEnum.OR.getCode());
        // 下半部分
        SqlCell time = new SqlCell();
        twoBg.setField("time");
        twoBg.setValue("2018");
        time.setType(SqlTypeEnum.THAN.getCode());
        // 一级部门
        SqlCell id = new SqlCell();
        twoBg.setField("id");
        twoBg.setValue("99");
        id.setType(SqlTypeEnum.LESS.getCode());

        SqlCell right = new SqlCell();
        right.setLeftChild(time);
        right.setRightChild(id);
        right.setType(SqlTypeEnum.AND.getCode());
        // 根
        root.setLeftChild(left);
        root.setRightChild(right);
        root.setType(SqlTypeEnum.AND.getCode());
        // 此时的根

        System.out.println(parseSqlCell(root));
    }
}
