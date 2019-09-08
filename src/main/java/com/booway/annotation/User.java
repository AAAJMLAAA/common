package com.booway.annotation;

public class User
{
	@SqlAnnonation(SqlEnum.equal)
	private String name;
	@SqlAnnonation(SqlEnum.like)
	private String pwd;
	
	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd) 
	{
		this.pwd = pwd;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	
}
