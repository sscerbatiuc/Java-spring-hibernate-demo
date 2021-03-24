package edu.spring.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Bike bike = (Bike)context.getBean("bike");
        bike.run();

        Car car = (Car)context.getBean("car");
        car.run();
        System.out.println(car.getName());

        Vehicle vehicle = (Vehicle) context.getBean("vehicle");
        vehicle.run();
    }
}
