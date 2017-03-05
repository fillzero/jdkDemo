package cn.tk.java.algorithm.frequency;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@date: 2017/3/5 0005
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 词频统计器
* 要求：
* （1）单词长度不得小于 2
* （2）最大词频是多个单词的时候都要打印
* 策略：
* 1. 制作字典
* 2. 遍历字典找出 max 值和对应 word 值
*/
public class FrequencyCounter {

    @SneakyThrows
    public HashMap<String, Integer> getMax(String filePath)
    {
        String max = "";
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        HashMap<String, Integer> maxCounter = new HashMap<String, Integer>();
        final String article = FileUtils.readFileToString(new File(filePath), Charset.forName("UTF-8"));
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]+\\b");
        final Matcher matcher = pattern.matcher(article);
        while (matcher.find()){
            String word = matcher.group();
            if (word.length() < 2)
                continue;
            if (!counter.containsKey(word))
                counter.put(word, 1);
            else
                counter.put(word, counter.get(word) + 1);
        }
        maxCounter.put(max, 0);
        for (String word : counter.keySet())
        {
            if (counter.get(word) < maxCounter.get(max)){
                continue;
            }else if (counter.get(word) == maxCounter.get(max)){
                maxCounter.put(word, counter.get(word));
            }else{
                maxCounter.clear();
                max = word;
                maxCounter.put(max, counter.get(word));
            }
        }
        return maxCounter;
    }
}
