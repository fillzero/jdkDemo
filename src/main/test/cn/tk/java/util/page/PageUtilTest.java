package cn.tk.java.util.page;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lijinlong3 on 2017/4/24.
 */
public class PageUtilTest {
    /*
    * @description: 打印第 1、11 页数据
    */
    @Test
    public void testGetRangeList() throws Exception {
        List<Person> persons = new ArrayList<>();
        for (int i=0; i<104; i++)
        {
            Person person = new Person();
            person.setName(""+i);
            person.setAge(i);
            persons.add(person);
        }
        List<Person> firstPage = PageUtil.getRangeList(persons, 1, 10);

        System.out.println("第一页：");
        for (Person person : firstPage) {
            System.out.print(person.getName() + ",");
        }

        System.out.println();
        System.out.println("最后一页：");
        List<Person> lastPage = PageUtil.getRangeList(persons, 11, 10);
        for (Person person : lastPage) {
            System.out.print(person.getName() + ",");
        }
    }
}