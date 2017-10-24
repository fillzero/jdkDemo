package cn.tk.java.designPattern.template;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: lijinlong
 * Mail: lijinlong3@jd.com
 * Date: 2017/10/24
 * Description:
 */
@Slf4j
public abstract class AbstractReadTemplate implements IReadTemplate{
    @Override
    public void read()
    {
        long startTime = System.currentTimeMillis();

        downLoadDoc();

        openDoc();

        readDoc();

        closeDoc();

        long endTime = System.currentTimeMillis();
        if (endTime - startTime > 500)
        {
            log.error("It's waste too long time to read!");
        }
    }

    // 下载文档
    protected abstract void downLoadDoc();

    // 打开文档
    protected abstract void openDoc();

    // 阅读文档
    protected abstract void readDoc();

    // 关闭文档
    protected abstract void closeDoc();
}
