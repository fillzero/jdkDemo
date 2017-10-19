package cn.tk.java.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/10/19
 * Description:
 */
public class PatternDemo {

    /**
     * Description: [] 表示可以出现的字符，? 表示该字符串最多出现 1 次（0 或 1）。
     */
    public static void main(String[] args) {
        String regex = "http[s]?://1\\.jd\\.com.*";
        String httpDomain = "http://1.jd.com";
        String httpsDomain = "https://1.jd.com";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher(httpDomain).find());
        System.out.println(pattern.matcher(httpsDomain).find());
    }
}
