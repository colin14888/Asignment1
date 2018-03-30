package Social_network;

import java.util.Arrays;

/**
 * The class of Person and have three attributes,
 * have three getter and setter functions
 * also have a toString function to show information of a person
 */

public class Person {
    private String name;
    private int age;
    private String status;
    public Person p[] = new Person[10000];
    //construction
    public Person(String name,int age,String status){
        this.name = name;
        this.age= age;
        this.status =status;
    }
    //get name
    public String getName() {
        return name;
    }
    //get status
    public String getStatus() {
        return status;
    }
    //set status
    public void setStatus(String status) {
        this.status = status;
    }
    //set name
    public void setName(String name) {
        this.name = name;
    }
    //get age
    public int getAge() {
        return age;
    }
    //set age
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    //show information
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
}
