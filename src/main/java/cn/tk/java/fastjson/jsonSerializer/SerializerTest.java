package cn.tk.java.fastjson.jsonSerializer;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/12/8
 * Description:
 */
public class SerializerTest {
    @Test
    public void testJson() {
        Comment comment = new Comment();
        comment.setImages("1,2,3");
        String res = JSON.toJSONString(comment);
        System.out.println(comment);
        Comment commentParse = JSON.parseObject(res, Comment.class);
        System.out.println(commentParse);
    }
}
