package com.my.java.util.javassist;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 *  需要这个包：javassist-3.18.1-GA.jar
 *  javassist动态生成class，通过使用Javassist对字节码操作为JBoss实现动态"AOP"框架
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Aug 14, 2019 10:12:04 AM
 */
public class main {

	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		//制定类全路径
        CtClass ctClass = pool.makeClass("com.my.java.util.javassist.Emp");
        //创建属性,参数是属性的类型，属性名称，属性所在类
        CtField enameFiled  = new CtField(pool.getCtClass("java.lang.String"), "ename", ctClass);
        enameFiled.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enameFiled);
        CtField enoFiled  = new CtField(CtClass.intType, "eno", ctClass);
        enoFiled.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enoFiled);
        //创建属性的getxxx setxxx方法
        CtMethod enameFiledMethod = CtNewMethod.getter("getEname", enameFiled);
        ctClass.addMethod(enameFiledMethod);
        CtMethod enameFiledMethod2 = CtNewMethod.setter("setEname", enameFiled);
        ctClass.addMethod(enameFiledMethod2);
        CtMethod enoFiledMethod = CtNewMethod.getter("getEno", enoFiled);
        ctClass.addMethod(enoFiledMethod);
        CtMethod enoFiledMethod2 = CtNewMethod.setter("setEno", enoFiled);
        ctClass.addMethod(enoFiledMethod2);
        //添加构造器,参数int，String
        CtConstructor  constructor2 = new CtConstructor(
           new CtClass[]{pool.get("java.lang.String"),CtClass.intType}
           ,ctClass);
        //构造器的方法体,$0表示this，$1$2表示第1个参数第2个参数
        constructor2.setBody("{$0.ename=$1; $0.eno = $2; }");
        ctClass.addConstructor(constructor2);
        //默认构造函数
        CtConstructor  constructor = new CtConstructor(new CtClass[]{},ctClass);
        //构造器的方法体
        constructor.setBody("{this.ename=\"11\";}");
        ctClass.addConstructor(constructor);
        //添加自定义方法,参数返回值类型,方法名称，参数，要放入的类
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "show", new CtClass[]{}, ctClass);
        ctMethod.setBody("{System.out.println(\"哈哈我打印了\");System.out.println(ename);}");
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctClass.addMethod(ctMethod);
        //将构造好的类写到文件中
        ctClass.writeFile("/Users/min.zhang/workspace/java-base/src");
        System.out.println("类生成功");
        //最后生成一个class
        Class<?> clazz = ctClass.toClass();
        
        //调用有参数构造函数
        Constructor  constructor3 = clazz.getConstructor(String.class,int.class);
        Object object = constructor3.newInstance("邯郸",13);
       
        //调用无参数构造函数
        //Object object = clazz.newInstance();
        
        //反射调用show方法
        Method method = clazz.getMethod("show", new Class[] {});
        method.invoke(object, new Object[] {});
        
	}

}
