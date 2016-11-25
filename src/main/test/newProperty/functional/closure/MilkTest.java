package newProperty.functional.closure;

import org.junit.jupiter.api.Test;

/**
 * Created by lijl85 on 2016/11/24.
 */
public class MilkTest {

    @Test
    public void testHaveMilk()
    {
        Milk milk = new Milk();
        Person person = milk.getPerson();

        person.haveMilk();
        milk.currentNum();
        person.haveMilk();
        milk.currentNum();
        person.haveMilk();
        milk.currentNum();
        person.haveMilk();
    }

    @Test
    public void testWithoutClosure()
    {
        Milk milk = new Milk();

        milk.haveMilk();
        milk.currentNum();
        milk.haveMilk();
        milk.currentNum();
        milk.haveMilk();
        milk.currentNum();
        milk.haveMilk();
    }
}