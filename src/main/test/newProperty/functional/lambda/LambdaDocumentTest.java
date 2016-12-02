package newProperty.functional.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lijl85 on 2016/12/2.
 */
public class LambdaDocumentTest {
    List<Person> roster = Person.createRoster();

    @Test
    @DisplayName("1. 打印年龄大于18岁的: 按单个条件查询")
    public void printPersonsOlderThan() throws Exception {
        LambdaDocument.printPersonsOlderThan(roster, 30);
    }

    @Test
    @DisplayName("2. 增加查询条件")
    public void printPersonsWithinAgeRange() throws Exception{
        LambdaDocument.printPersonsWithinAgeRange(roster, 25, 50);
    }

    @Test
    @DisplayName("3. 编写功能性接口(只有一个方法的接口)")
    public void printPersons() throws Exception{
        LambdaDocument.printPersons(roster, new DefaultCheckPerson());
    }

    @Test
    @DisplayName("4. 匿名类实现接口: 代码看起来不好看")
    public void printPersonsAnonymous() throws Exception
    {
        LambdaDocument.printPersonsAnonymous(roster);
    }

    @Test
    @DisplayName("5. 使用 Lambda 表达式代替匿名类实现功能性接口")
    public void printPersonsLambda() throws Exception
    {
        LambdaDocument.printPersonsLambda(roster);
    }

    @Test
    @DisplayName("6. 使用 匿名类/Lambda 表达式实现 JDK 功能性接口")
    public void printPersonsAnonymousPredicate() throws Exception{
        LambdaDocument.printPersonsAnonymousPredicate(roster);
    }
    @Test
    @DisplayName("6. 使用 匿名类/Lambda 表达式实现 JDK 功能性接口")
    public void printPersonsLambdaPredicate() throws Exception{
        LambdaDocument.printPersonsLambdaPredicate(roster);
    }

    @Test
    @DisplayName("7. 进一步引入 Lambda 表达式")
    public void processPersons() throws Exception{
        LambdaDocument.processPersons(roster);
    }
    @Test
    @DisplayName("7. 进一步引入 Lambda 表达式")
    public void processPersonsFunction() throws Exception{
        LambdaDocument.processPersonsFunction(roster);
    }

    @Test
    @DisplayName("8. 聚合操作使用 Lambda 表达式, 无需实现各种接口")
    public void printPersonsByAggregate() throws Exception{
        LambdaDocument.processPersonsFunction(roster);
    }
}