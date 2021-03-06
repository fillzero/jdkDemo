package cn.tk.java.designPattern.template;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/10/24
 * Description:
 */
public class ReadCsvTemplate extends AbstractReadTemplate {

    @Override
    protected void downLoadDoc() {
        System.out.println("download csv!");
    }

    @Override
    protected void openDoc() {
        System.out.println("open csv!");
    }

    @Override
    protected void readDoc() {
        System.out.println("read csv!");
    }

    @Override
    protected void closeDoc() {
        System.out.println("close csv!");
    }
}
