/**
 * 作 者: 欧阳超
 * 日 期: 2011-3-20
 * 描 叙:
 */
package com.zte.html5.frame.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * 功能描叙:
 * 编   码: 欧阳超
 * 完成时间: 2011-3-20 下午04:32:50
 */
public class MapUtil
{

	public static HashMap returnMap(Object pojo)
	{
		HashMap hashMap = new HashMap();

		// Class c = BaseObject.class;
		Method m[] = pojo.getClass().getDeclaredMethods();
		Field f[] = pojo.getClass().getDeclaredFields();
		for (Method md : m)
		{
			for (Field d : f)
			{
				String prpName = d.getName();
				String getMetd = "get"
						+ d.getName().substring(0, 1).toUpperCase()
						+ d.getName().substring(1);
				if (getMetd.equals(md.getName()))
				{
					try
					{
						Object v = md.invoke(pojo, new Object[0]);
						if(v != null)
						{
						    hashMap.put(prpName, v);
						}
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		}

		return hashMap;
	}
}

