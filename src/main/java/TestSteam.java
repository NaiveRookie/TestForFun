import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

/**
 * @author coolestyue
 * 要努力呀.
 */
public class TestSteam {

    public static void main(String[] args) throws SQLSyntaxErrorException {

        String sql = "select  user.name ,user.id   from app.user limit 10 ";
        String dbType = "mysql";
        System.out.println("原始SQL 为 ： "+sql);
        SQLSelectStatement statement = (SQLSelectStatement) parser(sql, dbType);
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        statement.accept(visitor);
        System.out.println(visitor.getTables().toString());
    }

    public static SQLStatement parser(String sql,String dbType) throws SQLSyntaxErrorException {
        List<SQLStatement> list = SQLUtils.parseStatements(sql, dbType);
        if (list.size() > 1) {
            throw new SQLSyntaxErrorException("MultiQueries is not supported,use single query instead ");
        }
        return list.get(0);
    }

}
