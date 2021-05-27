package app.exercise.testing;

import java.util.ArrayList;
import java.util.List;

import app.exercise.adt.BSTree;
import app.exercise.algebra.CompRational;
import app.exercise.visualtree.DrawableTreeElement;
import app.exercise.visualtree.RedBlackTreeDrawer;

public class BSTreeTester {
    private static BSTree<CompRational> primaryTree;
    private static BSTree<CompRational> secondaryTreeA;
    private static BSTree<CompRational> secondaryTreeB;

    /*
     * @param String[] args
     */
    public static void main(String[] args) {

        if (args.length % 2 != 0) {
            System.out.println("Gerade Anzahl an Argumenten benötigt");
            return;
        }

        if (args.length == 0) {
            System.out.println("Parameter angeben!");
            return;
        }

        CompRational first = new CompRational(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        CompRational last = new CompRational(Integer.parseInt(args[args.length-2]), Integer.parseInt(args[args.length-1]));
        primaryTree = new BSTree<>();
        secondaryTreeA = new BSTree<>();
        secondaryTreeB = new BSTree<>();

        RedBlackTreeDrawer<CompRational> visual = new RedBlackTreeDrawer<>();

        for (int i = 0; i < args.length; i += 2) {
            CompRational compRational = new CompRational(Integer.parseInt(args[i]), Integer.parseInt(args[i+1]));
            primaryTree.add(compRational);
            if ((i/2) % 2 == 0)  secondaryTreeA.add(compRational);
            else secondaryTreeB.add(compRational);
        }

        System.out.println(primaryTree);
        visual.draw((DrawableTreeElement<CompRational>) primaryTree.getRoot());

        System.out.println(secondaryTreeA);
        System.out.println(secondaryTreeB);

        System.out.println(primaryTree.containsAll(secondaryTreeA));
        System.out.println(primaryTree.containsAll(secondaryTreeB));

        System.out.println(primaryTree.contains(first));
        System.out.println(primaryTree.contains(last));

        System.out.println(primaryTree.size());
        primaryTree.remove(first);
        primaryTree.remove(last);
        System.out.println(primaryTree.size());

        System.out.println(primaryTree.contains(first));
        System.out.println(primaryTree.contains(last));

        System.out.println();
        System.out.println("Zahlen, die random generiert und entfernt werden");

        CompRational minRat = first;
        CompRational maxRat = first;
        int minNum = Integer.valueOf(args[0]);
        int maxNum = Integer.valueOf(args[0]);
        for (int i = 0; i < args.length; i += 2) {
            int input_a = Integer.valueOf(args[i]);
            int input_b = Integer.valueOf(args[i+1]);

            CompRational tmpRat = new CompRational(input_a, input_b);
            if (tmpRat.compareTo(minRat) < 0) minRat = tmpRat;
            if (tmpRat.compareTo(maxRat) > 0) maxRat = tmpRat;

            if (input_a < minNum) minNum = input_a;
            if (input_a > maxNum) maxNum = input_a;
            if (input_b < minNum) minNum = input_b;
            if (input_b > maxNum) maxNum = input_b;
        }

        System.out.println("min: " + minRat + "; max: " + maxRat + ";");

        List<CompRational> newNumbers = new ArrayList<>();
        while (newNumbers.size() < 100){
            CompRational rand_compRat;
            try {
                int random_a = (int) (Math.random()*100);
                int random_b = (int) (Math.random()*100);
                rand_compRat = new CompRational(random_a, random_b);
            } catch (IllegalArgumentException a) {
                continue;
            }
            if (minRat.compareTo(rand_compRat) < 0 && maxRat.compareTo(rand_compRat) > 0) {
                newNumbers.add(rand_compRat);
            }
        }

        for (CompRational z : newNumbers) {
            if (primaryTree.contains(z)) {
                primaryTree.remove(z);
                System.out.println("removed: " + z);
            }
        }

        visual.draw((DrawableTreeElement<CompRational>) primaryTree.getRoot());
    }
}