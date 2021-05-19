package exercise.algebra;

import exercise.algebra.*;

public class CompRational extends Rational implements Comparable<Rational>{

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

    /*@Override
    public int compareTo(Rational o) {
        if (o instanceof CompRational) {
            o.setND(o.numerator, o.denominator);
            CompRational Comp_Rat = new CompRational(super.numerator, super.denominator);
            Comp_Rat.sub(o);
            System.out.println(Comp_Rat);
            return (int) (Comp_Rat.getN()/Comp_Rat.getD());
        }
        throw new IllegalArgumentException("ERROR compareTo expect Parameter of Type CompRational");
    }*/
    @Override
    public int compareTo(Rational rat) {
        if (rat instanceof Rational) {
            rat.setND(rat.numerator, rat.denominator);
            CompRational comp_Rat = new CompRational(super.numerator, super.denominator);
            comp_Rat.sub(rat);
            double a = ((double) Long.MAX_VALUE/ (double) Integer.MAX_VALUE);
            System.out.println(a);
            if (comp_Rat.getN() < 0) {
                return -1;
            } else if (comp_Rat.getN() == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        throw new IllegalArgumentException("ERROR compareTo expects Parameter of Type CompRational");
    }
}
