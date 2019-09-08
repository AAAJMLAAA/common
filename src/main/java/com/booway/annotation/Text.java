package com.booway.annotation;

import java.lang.reflect.Field;

public class Text 
{
	public static void main(String[] args)
	{
		Field[] fields = User.class.getDeclaredFields();
		
		for (Field field : fields)
		{
			// 是否包含这个注解
			if (field.isAnnotationPresent(SqlAnnonation.class))
			{
				SqlAnnonation annonation = field.getAnnotation(SqlAnnonation.class);
				if (annonation.value().equals(SqlEnum.like))
				{
					System.out.println("使用了like的方法");
				}
			}
		}
		
	}
}
