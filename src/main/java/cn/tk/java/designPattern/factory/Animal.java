package cn.tk.java.designPattern.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/12/15
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal {
    private String name;

    private Integer size;

    abstract Animal build();
}
