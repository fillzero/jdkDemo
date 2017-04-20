package cn.tk.java.util.collections.set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/20
* @description: java 实现分类去重
*
**/
public class Classification {
    public static void main(String[] args) {
        StringBuffer equivalentBuffer = new StringBuffer();
        equivalentBuffer.append("4-12345678904,4-12345678905,4-12345678904,2-12345678905");
        String[] equivalentArr = equivalentBuffer.toString().split(",");
        Map<Integer, Set<String>> equivalentMap = classify(equivalentArr);

        System.out.println(equivalentMap);
    }

    private static Map<Integer, Set<String>> classify(String[] equivalentArr) {
        Map<Integer, Set<String>> equivalentMap = Maps.newHashMap();
        for (String typeAndCode : equivalentArr) {
            String[] equivalent = typeAndCode.split("-");
            if (equivalent.length == 2)
            {
                int type = Integer.valueOf(equivalent[0]);
                String code = equivalent[1];
                Set<String> equivalentCodes = equivalentMap.get(type);
                if (equivalentCodes == null)
                {
                    equivalentCodes = Sets.newHashSet();
                    equivalentMap.put(type, equivalentCodes);
                }
                equivalentCodes.add(code);
            }
        }
        return equivalentMap;
    }

    //TODO
    private static Map<Integer, Set<String>> classifyByJava8(String[] equivalentArr) {
        Map<Integer, Set<String>> equivalentMap = Maps.newHashMap();
        return equivalentMap;
    }
}
