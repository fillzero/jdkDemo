package cn.tk.java.fastjson.upcast;

/*
* @author: lijinlong
* @mail: lijinlong3@jd.com
* @date: 2017/4/21
* @description: 鸟类
*
**/
public class Bird extends Animal{

    // 翅膀
    private String wing;

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bird)) return false;
        if (!super.equals(o)) return false;

        Bird bird = (Bird) o;

        return wing != null ? wing.equals(bird.wing) : bird.wing == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wing != null ? wing.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "wing='" + wing + '\'' +
                '}';
    }
}
