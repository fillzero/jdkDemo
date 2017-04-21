package cn.tk.java.fastjson.upcast;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/21
* @description: 动物类
*
**/
public class Animal {

    // 脚
    private String foot;

    // 嘴
    private String mouse;

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;

        Animal animal = (Animal) o;

        if (foot != null ? !foot.equals(animal.foot) : animal.foot != null) return false;
        return mouse != null ? mouse.equals(animal.mouse) : animal.mouse == null;

    }

    @Override
    public int hashCode() {
        int result = foot != null ? foot.hashCode() : 0;
        result = 31 * result + (mouse != null ? mouse.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "foot='" + foot + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}
