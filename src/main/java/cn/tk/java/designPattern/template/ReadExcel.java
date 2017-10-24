package cn.tk.java.designPattern.template;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/10/24
 * Description:
 */
public class ReadExcel extends AbstractReadTemplate {

    @Override
    protected void downLoadDoc() {
        System.out.println("download excel!");
    }

    @Override
    protected void openDoc() {
        System.out.println("open excel!");
    }

    @Override
    protected void readDoc() {
        System.out.println("read excel!");
    }

    @Override
    protected void closeDoc() {
        System.out.println("close excel!");
    }
}
