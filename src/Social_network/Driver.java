package Social_network;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Driver {
    public List<Person> list = new ArrayList<>();//store the object of person
    //menu function
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("MiniNet Menu");
            System.out.println("===================================");
            System.out.println("1. Add person");
            System.out.println("2. List everyone");
            System.out.println("3. Select a person");
            System.out.println("4. Display selected person");
            System.out.println("5. Delete selected person");
            System.out.println("6. Connect selected  person to another");
            System.out.println("7. Find selected person’s child");
            System.out.println("8. Find selected person’s parent");
            System.out.println("9. Check friendship between selected person and another");
            System.out.println("0. Exit");
            System.out.println("===================================");
            int n;
            while(true) {
                //input a integer if more than 9 or less than 0 that input again until input a valid integer
                System.out.println("Please input a choice: ");
                n = scanner.nextInt();
                if(n>=0&&n<=9)
                    break;
            }
            switch(n){
                //according the integer select different functions
                case 1:add();break;
                case 2:display();break;
                case 3:select();break;
                case 4:display1();break;
                case 5:delete();break;
                case 6:connect();break;
                case 7:find1();break;
                case 8:find2();break;
                case 9:check();break;
                case 0:System.exit(0);
            }
        }
    }
    //add person information
    public void add(){
        System.out.println("Please input name, age and status: ");
        String name = new Scanner(System.in).next();
        int age = new Scanner(System.in).nextInt();
        String status = new Scanner(System.in).next();
        Person p = new Person(name,age,status);
        System.out.println("Please input the name,age and status of  parents and child : ");
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        int age1 = scanner.nextInt();
        String status1 = scanner.next();
        String name2 = scanner.next();
        int age2 = scanner.nextInt();
        String status2 = scanner.next();
        String name3 = scanner.next();
        int age3 = scanner.nextInt();
        String status3 = scanner.next();
        Person p1 = new Person(name1,age1,status1);
        Person p2 = new Person(name2,age2,status2);
        Person p3 = new Person(name3,age3,status3);
        p.p[0] = p1;
        p.p[1] = p2;
        p.p[2] = p3;
        list.add(p);
    }
    //display person's information
    public void display(){
        for(Person p:list){
            System.out.println(p);
        }
    }
    //according name display person's information
    public void display1(){
        System.out.println("Please input a name of person: ");
        String name = new Scanner(System.in).next();
        for(Person p:list){
            if(p.getName().equals(name)){
                System.out.println(p);
                break;
            }
        }
    }
    //according the num display the person's information
    public void select(){
        System.out.println("Please input a num :");
        int n = new Scanner(System.in).nextInt();
        if(n<=list.size()){
            Person p = list.get(n-1);
            System.out.println(p);
        }
    }
    //delete the object of person
    public void delete(){
        System.out.println("Please input a name of person: ");
        String name = new Scanner(System.in).next();
        for(Person p:list){
            if(p.getName().equals(name)){
                list.remove(p);
                break;
            }
        }
    }
    //connect two object
    public void connect(){
        System.out.println("Please input two names , age and status to connect: ");
        String name1 = new Scanner(System.in).next();
        int age1 = new Scanner(System.in).nextInt();
        String name2 = new Scanner(System.in).next();
        int age2 = new Scanner(System.in).nextInt();
        String status = new Scanner(System.in).next();
        for(Person p:list){
            if(p.getName().equals(name1)&&p.getAge()==age1){
                p.p[3] = new Person(name2,age2,status);
                break;
            }
        }
    }
    //according the name and age display the object information
    public void find1(){
        System.out.println("Please input name and age :");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();
        for(Person p:list){
            if(p.getName().equals(name)&&p.getAge()==age){
                System.out.println(p.p[2].getName()+" "+p.p[2].getAge()+" "+p.p[2].getStatus());
                break;
            }
        }
    }
    //according the name and age display the object information
    public void find2(){
        System.out.println("Please input name and age :");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();
        for(Person p:list){
            if(p.getName().equals(name)&&p.getAge()==age){
                System.out.println(p.p[0].getName()+" "+p.p[0].getAge()+" "+p.p[0].getStatus());
                System.out.println(p.p[1].getName()+" "+p.p[1].getAge()+" "+p.p[0].getStatus());
                break;
            }
        }
    }
    //check whether the two people can have a relationship
    public void check(){
        System.out.println("Please input two name and age: ");
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.next();
        int age1 = scanner.nextInt();
        String name2 = scanner.next();
        int age2 = scanner.nextInt();
        for(Person p:list){
            if(p.getName().equals(name1)){
                int l1 = p.getAge();
                if(l1<2){
                    System.out.println("Your age<2 and have no friend...");
                    return;
                }
                else if(l1<16){
                    if(p.p[3].getName().equals(name2)){
                        int l2 = p.p[3].getAge();
                        if(l2>=2&&l2<16){
                            System.out.println("There are friends!");
                            return ;
                        }else{
                            System.out.println("There are not frineds...");
                            return;
                        }
                    }
                }
                else {
                    if(p.p[3].getName().equals(name2)) {
                        int l2 = p.p[3].getAge();
                        if (l2 > 16) {
                            System.out.println("There are friends!");
                            return;
                        } else {
                            System.out.println("There are not frineds...");
                            return;
                        }
                    }
                }
            }
        }
    }
}
