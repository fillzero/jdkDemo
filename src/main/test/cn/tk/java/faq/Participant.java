package cn.tk.java.faq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Date;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/5/8
 * Description: 参与人数据模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    /**
     * Description: 唯一分布式主键
     */
    private Long id;

    /**
     * Description: 姓名
     */
    private String name;

    /**
     * Description: 参与时间
     * 参与时间越晚值越大
     */
    private Date pTime;

    @Override
    public String toString() {
        return "id:" + id + " ";
    }
}
