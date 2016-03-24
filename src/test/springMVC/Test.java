package test.springMVC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext act=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println(act);
		System.out.println(act.getBean("dataSource"));
	}
}
