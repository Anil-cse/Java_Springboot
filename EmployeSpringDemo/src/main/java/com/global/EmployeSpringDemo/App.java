package com.global.EmployeSpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.global.EmployeSpringDemo.modal.Address;
import com.global.EmployeSpringDemo.modal.Employee;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("emp.xml");
        Employee e1 = (Employee) context.getBean("employee");
        Address e2 = (Address) context.getBean("address");
        e1.setAddress(e2);
        System.out.println(e1);
        
    }
}
