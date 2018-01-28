package cn.tk.java.fastjson.jsonSerializer;

import cn.tk.java.util.hash.SimpleHashMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/12/8
 * Description:
 */
public class Comment {
    /**
     * images列表
     */
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<Integer> getImageList() {
        return Lists.newArrayList(4, 5, 6);
//        return Arrays.asList(4,5,6);
    }

    /**
     * Description：ES 中存放多于 JavaBean 的数据项，为了前端显示，但是反序列化的时候会出现问题
     * 序列化：JavaBean --> String （会调用 getImageMap 方法，序列化对象）
     * 反序列化：String --> JavaBean （也会调用 getImageMap 方法，用于反序列化对象）
     * 反序列化的过程中 setValue 时，如果是 Map 类型会调用
     */
    public Map<Integer, String> imageMap()
    {
        return Maps.asMap(Sets.newHashSet(1, 2), e -> String.valueOf(e));
    }
}
