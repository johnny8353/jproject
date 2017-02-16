package com.zte.util.config;

import java.util.*;

import org.dom4j.*;
import org.dom4j.io.*;

/**
 * XML配置文件读取工具类
 * 
 * @author 10027909
 */
public class ApplicationConfig
{
    private static Map<String, String> config = null;

    static
    {
        config = init();
    }

    public static Map<String, String> init()
    {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader saxReader = new SAXReader();
        try
        {
            Document document = saxReader.read(ApplicationConfig.class.getResourceAsStream("/config.xml"));
            Element root = document.getRootElement();

            // 遍历根结点,最多遍历3级节点,读出所有节点的TEXT放到map中保存
            readSubElement(map, root);

        }
        catch (DocumentException e)
        {
            System.err.println("配置文件装载出错!");
            e.printStackTrace();
        }

        return map;
    }

    public static void readSubElement(Map<String, String> map, Element element)
    {
        if (element.elements().size() > 0)
        {
            @SuppressWarnings("unchecked")
			Iterator<Element> itr = element.elementIterator();
            while (itr.hasNext())
            {
                Element subelement = itr.next();
                readSubElement(map, subelement);
            }
        }
        else
        {
            String key = element.getName();
            Element parent = element.getParent();
            while (parent != null && !parent.isRootElement())
            {
                key = parent.getName() + "." + key;
                parent = parent.getParent();
            }
            String val = element.getTextTrim();
            map.put(key, val);
            System.out.println(key + "=" + val);
        }
    }

    /**
     * 获取配置参数
     * 
     * @param key
     *            :配置项名称,格式为 parentname.name.subname
     * @return
     */
    public static String getValueByKey(String key)
    {
        return config.get(key);
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        init();
    }

}
