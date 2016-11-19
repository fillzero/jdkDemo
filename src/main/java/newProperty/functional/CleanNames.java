package newProperty.functional;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
  *@date: 2016/11/19
  *@author: lijl85
  *@mail: ljldeepinit@163.com
  *@description: 名称清洗
  * 1. 列表筛去单字符条目
  * 2. 所有条目首字母大写
  * 3. 用逗号分隔拼接成字符串
  */
public class CleanNames {

        /*
        * @description: 数据清洗函数
        * @param: listOfNames: 项目列表
        */
        public String cleanNames(List<String> listOfNames)
        {
            StringBuffer sBuffer = new StringBuffer();
            for (int i=0; i<listOfNames.size(); i++)
            {
                if (listOfNames.get(i).length() <= 1)
                    continue;
                sBuffer.append(capitalize(listOfNames.get(i)) + ",");
            }
            return sBuffer.substring(0, sBuffer.length()-1).toString();
        }

        public String cleanNamesNew(List<String> names)
        {
            if (names == null) return "";
            return names
                    .stream()
                    .filter(name -> name.length() > 1)
                    .map(name -> capitalize(name))
                    .collect(Collectors.joining(","));

        }

        /*
        * @description: 首字母大写函数
        */
        public String capitalize(String name)
        {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
}

