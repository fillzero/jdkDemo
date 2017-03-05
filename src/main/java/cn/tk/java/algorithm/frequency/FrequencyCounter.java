package cn.tk.java.algorithm.frequency;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;

/*
*@date: 2017/3/5 0005
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 统计词频
* 1. 制作字典
* 2. 遍历字典找出 max 值和对应 words
*/
public class FrequencyCounter {

    @SneakyThrows
    public String getMax(String filePath)
    {
        String max = "";
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        final String article = FileUtils.readFileToString(new File(filePath), Charset.forName("UTF-8"));
        final String[] words = article.split(" ");
        for (String word : words) {
            if (word.length() < 2)//minLength
                continue;
            if (!counter.containsKey(word))
                counter.put(word, 1);
            else
                counter.put(word, counter.get(word) + 1);
        }

        counter.put(max, 0);
        for (String word : counter.keySet())
            if (counter.get(word) > counter.get(max))
                max = word;
        return max + " : " + counter.get(max);
    }
}
