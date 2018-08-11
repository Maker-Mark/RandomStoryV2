package com.company;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class Main {

    public static Random randMach = new Random();
    public static PrintStream ps;

    public static void main(String[] args) throws Exception {
        final int MAX_VAL = 100;
        int countArt = 0, countVerb = 0, countNoun = 0, countPrep = 0;
        Scanner artFile = new Scanner(new File("Article.txt"));
        Scanner nounFile = new Scanner(new File("Noun.txt"));
        Scanner verbFile = new Scanner(new File("Verb.txt"));
        Scanner prepFile = new Scanner(new File("Preposition.txt"));

        String[] article = new String[MAX_VAL];
        String[] noun = new String[MAX_VAL];
        String[] verb = new String[MAX_VAL];
        String[] preposition = new String[MAX_VAL];
        countArt = populateArr(article, artFile);
        countNoun = populateArr(noun, nounFile);
        countVerb = populateArr(verb, verbFile);
        countPrep = populateArr(preposition, prepFile);
        printSent(article, countArt, noun, countNoun, verb, countVerb,
                preposition, countPrep);
    }

    public static int populateArr(String[] x, Scanner file) {
        int count = 0;
        while (file.hasNext()) {
            x[count] = file.nextLine();
            count++;
        }
        return count;
    }

    public static String random(String[] x, int y) {
        int rand = 0;
        rand = randMach.nextInt(y);

        return x[rand];
    }

    public static void printSent(String[] art, int countArt, String nou[], int countNoun, String ver[], int countVerb,
                                 String prep[], int countPrep) throws Exception {
        ps = new PrintStream("ChildrensStory.txt");
        for (int a = 1; a <= 2; a++) {
            for (int i = 1; i <= 5; i++) {
                String randArt = random(art, countArt), randNoun = random(nou, countNoun),
                        randVer = random(ver, countVerb), randPrep = random(prep, countPrep),
                        randArt2 = random(art, countArt),
                        randNoun2 = random(nou, countNoun);
                ps.printf(randArt.substring(0, 1).toUpperCase() + randArt.substring(1) + " " + randNoun + " " + randVer +
                        " " + randPrep + " " + randArt2 + " " + randNoun2 + ".%n");
            }
            ps.printf("%n%n");
        }
    }
}
