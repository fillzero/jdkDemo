package newProperty.functional.lambda;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
/*
* @description: Lambda 表达式测试场景类: Animal
* social networking application: 客户类
*/
public class Person {
    /*
    * @description: 性别枚举
    */
    public enum Sex {
        MALE, FEMALE
    }
    @Getter String name;
    @Getter Sex gender;
    @Getter String emailAddress;
    LocalDate birthday;

    Person(String nameArg, LocalDate birthdayArg,
           Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }

    /*
    * @description: 获取年龄
    */
    public int getAge() {
        return birthday
                .until(IsoChronology.INSTANCE.dateNow())//birthday 与当前日期的差值
                .getYears();
    }

    /*
    * @description: 打印姓名: 年龄
    */
    public void printPerson() {
        System.out.println(name + ": " + this.getAge());
    }

    /*
    * @description: 获取生日
    */
    public LocalDate getBirthday() {
        return birthday;
    }

    /*
    * @description: 比较年龄大小 -1, 1, 0
    */
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    /*
    * @description: 社交网络花名册
    */
    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com"));
        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Person.Sex.MALE, "bob@example.com"));

        return roster;
    }
}

