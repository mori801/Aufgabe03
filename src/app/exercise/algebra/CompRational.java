package app.exercise.algebra;

import app.exercise.algebra.*;

public class CompRational extends Rational implements Comparable<CompRational>{

    private Object CompRational;

    public CompRational() {
        super(0, 1);
    }

    public CompRational(long numerator, long denominator) {
        super(numerator, denominator);
    }


    public static void main(String[] args) {
        System.out.println(new CompRational(Long.MAX_VALUE/2, 1).compareTo(new CompRational(1,1)));
    }

    @Override
    public int compareTo(CompRational rat) {
        rat.setND(rat.getN(), rat.getD());
        CompRational tmp_rat = new CompRational(this.getN(), this.getD());
        tmp_rat.sub(rat);
        if (tmp_rat.getN() < 0) {
            return -1;
        } else if (tmp_rat.getN() == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
