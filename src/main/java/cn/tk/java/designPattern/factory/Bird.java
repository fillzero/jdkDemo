package cn.tk.java.designPattern.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Bird extends Animal {
    private String name;

    private Integer size;

    @Override
    protected Animal build() {
        System.out.println("Bird is eating!");
        return Bird.builder()
                .name("bird")
                .size(234)
                .build();
    }
}
