package de.tum.in.ase;

import java.io.File;
import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Change paths to Absolute Path
        File inputFile = new File("resources/input.txt");
        File testFile = new File("resources/test.txt");

        Service service = new Service();
        int total = 0;
        total = service.cleaner(inputFile);
        System.out.println(total);
    }
}