package newProperty.functional.lambda;

/*
* @date: 2016/12/2
* @author: lijl85
* @mail: ljldeepinit@163.com
* @description:
* 
*/
public class DefaultCheckPerson implements CheckPerson {

    @Override
    public boolean test(Person person) {
        return person.getGender() == Person.Sex.MALE
                && person.getAge() >= 18
                && person.getAge() <= 30;
    }
}
