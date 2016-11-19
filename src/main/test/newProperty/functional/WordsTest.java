package newProperty.functional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordsTest {

    Words wordIns = new Words();
    public final String words = "i am play the basketball, i don't know what will happen in the future, so don't scare me," +
            "ok? ";

    @Test
    public void wordFreq() {
        System.out.println(wordIns.wordFreq(words));
    }

    @Test
    public void wordFreqNew()
    {
        System.out.println(wordIns.wordFreqNew(words));
    }
}