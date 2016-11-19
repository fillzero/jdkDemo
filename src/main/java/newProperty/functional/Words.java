package newProperty.functional;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
*@date: 2016/11/19
*@author: lijl85
*@mail: ljldeepinit@163.com
*@description: 词频统计
* 1. 词频统计方法: 入参为字符串, 工具: TreeMap<String, int>, HashSet 存放多个单词
* 2. 思路
* (1)判断输入单词是否存在
* (2)判断输入单词是否之前已经统计过次数
*/
public class Words {

    /*
    * @description: 虚词集合, 不作为统计单词
    */
    Set<String> NON_WORDS = new HashSet<String>(){{
        add("the"); add("and"); add("of"); add("to");
        add("a"); add("i"); add("it"); add("in");
        add("or"); add("is"); add("d"); add("s");
        add("but"); add("be"); add("so"); add("as");
    }};

    /*
    * @description: 词频统计方法
    * 1. 小写单词
    * 2. 过滤虚词
    * 3. 计算词频
    */
    public TreeMap<String, Integer> wordFreq(String words)
    {
        TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
        Matcher matcher = Pattern.compile("\\w+").matcher(words);
        while (matcher.find())
        {
            String word = matcher.group().toLowerCase();
            if (!NON_WORDS.contains(word)){
                if (wordMap.get(word) == null){
                    wordMap.put(word, 1);
                }else {
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }
        return wordMap;
    }

    /*
    * @description:正则表达式匹配, 匹配结果放入 List
    */
    private List<String> regexToList(String words, String regex)
    {
        List wordList = new ArrayList();
        Matcher matcher = Pattern.compile(regex).matcher(words);
        while (matcher.find())
            wordList.add(matcher.group());
        return wordList;
    }

    public Map wordFreqNew(String words)
    {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        regexToList(words, "\\w+").stream()
                .map(w -> w.toLowerCase())
                .filter(w -> !NON_WORDS.contains(w))
                .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));
        return wordMap;
    }
}
