package main;

import main.IO.View;
import main.logic.Hashtable;

public class Main {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(10);
        View view = new View();
        view.menu(hashtable);
    }
}
