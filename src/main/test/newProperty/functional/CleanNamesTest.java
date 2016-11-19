package newProperty.functional;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijl85 on 2016/11/19.
 */
public class CleanNamesTest {

    private CleanNames instance = new CleanNames();

    public List<String> nameList = new ArrayList<String>(){{
        add("lijinlong"); add("is"); add("a"); add("cool"); add("boy");
    }};

    @Test
    public void cleanNames() throws Exception {
        System.out.println(instance.cleanNames(nameList));
    }

    @Test
    public void cleanNamesNew() throws Exception {
        System.out.println(instance.cleanNamesNew(nameList));
    }

    @Test
    public void capitalize() throws Exception {
        assertEquals("Lijinlong", instance.capitalize("lijinlong"));
        assertNotEquals("lijinlong", instance.capitalize("lijinlong"));
    }
}