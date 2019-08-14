package com.my.java.base;

import java.io.PrintStream;

public class Emp
{
  private String ename;
  private int eno;
  
  public String getEname()
  {
    return ename;
  }
  
  public void setEname(String paramString)
  {
    ename = paramString;
  }
  
  public int getEno()
  {
    return eno;
  }
  
  public void setEno(int paramInt)
  {
    eno = paramInt;
  }
  
  public Emp(String paramString, int paramInt)
  {
    ename = paramString;
    eno = paramInt;
  }
  
  public Emp()
  {
    ename = "11";
  }
  
  public void show()
  {
    System.out.println("哈哈我打印了");
    System.out.println(ename);
  }
}

