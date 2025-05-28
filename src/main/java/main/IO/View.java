package main.IO;

import main.logic.Hashtable;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class View {
    public void menu(Hashtable hashTable) {
        Scanner scanner = new Scanner(System.in);
        int option =1;
        while (option!=0) {
            System.out.println("""
                    1.insert element
                    2.delete element
                    3.find element
                    4.show table
                    5.task 2
                    0.exit
                    """);
            option = scanner.nextInt();
            String element;
            switch (option) {
                case 1:
                    System.out.print("Enter element to insert:");
                    element = scanner.next();
                    hashTable.insert(element);
                    break;
                case 2:
                    System.out.print("Enter element to delete:");
                    element = scanner.next();
                    hashTable.delete(element);
                    break;
                case 3:
                    System.out.print("Enter element to find:");
                    element = scanner.next();
                    System.out.println(hashTable.find(element));
                    break;
                case 4:
                    System.out.println(hashTable.display());
                    break;
                case 5:
                    task2();
                    break;
            }
        }
    }

    private void task2() {
        Random r=new Random();
        long start=System.currentTimeMillis();
        Hashtable hashTable = new Hashtable(10);
        for (int i = 0; i < 1_000_000; i++) {
            int t = r.nextInt(100_000_000);
            hashTable.insert(String.valueOf(t));
        }
        for (int i = 0; i < 1000; i++) {
            int t = r.nextInt(100_000_000);
            hashTable.find(String.valueOf(t));
        }
        long end=System.currentTimeMillis();
        System.out.println("Time needed to add 10^6 elements in custom hashTable: "+(end-start));
        start=System.currentTimeMillis();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 1_000_000; i++) {
            int t = r.nextInt(100_000_000);
            set.add(String.valueOf(t));
        }
        for (int i = 0; i < 1000; i++) {
            int t = r.nextInt(100_000_000);
            set.contains(String.valueOf(t));
        }
        end=System.currentTimeMillis();
        System.out.println("Time needed to add 10^6 elements in Java HashSet: "+(end-start));
    }
}
