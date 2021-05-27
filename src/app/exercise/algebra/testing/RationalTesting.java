package app.exercise.algebra.testing;

import app.exercise.algebra.*;

/**
 * Testklasse für Rational
 */
public class RationalTesting {

	/** main-Methode zum Testen von Rational-Rechenoperationen */
	public static void main(String[] args) {
		Rational r1 = new Rational(5, 4); //Zwei neue Rational-Objekte r1, r2
		Rational r2 = new Rational(3, 2);
		System.out.println("Input: " + r1 + " und " + r2);
		System.out.println();
		Rational r3 = (Rational) r1.clone(); //Koppiere r1 auf r3 und r2 auf r4
		Rational r4 = (Rational) r2.clone();
		r3.add(r4); //Erste Rechenoperation: Adde r4 auf r3
		System.out.println(r1 + " + " + r2 + " = " +  r3); //Gib Rechnung aus
		r3 = (Rational) r1.clone(); //Zurücksetzen von r3 und r4
		r4 = (Rational) r2.clone();
		r3.sub(r4); //Zweite Rechenoperation: Subtrahiere r4 von r3
		System.out.println(r1 + " - " + r2 + " = " +  r3); //...
		r3 = (Rational) r1.clone();
		r4 = (Rational) r2.clone();
		r3.mul(r4);
		System.out.println(r1 + " * " + r2 + " = " +  r3);
		r3 = (Rational) r1.clone();
		r4 = (Rational) r2.clone();
		r3.div(r4);
		System.out.println(r1 + " / " + r2 + " = " +  r3);
		System.out.println();
		System.out.println("HashCode " + r1 + ": " + r1.hashCode()); //Gib Hashcodes von r1 und r2 aus
		System.out.println("HashCode " + r2 + ": " + r2.hashCode());
		System.out.println();
		System.out.println(r1 + " = " + r2 + ": " + r1.equals(r2)); //Ist r1 und r2 gleich? Ausgabe -> true/false

		System.out.println("-----------------------------------------------------");

		r1 = new Rational(-5, 3); //Das gleiche nochmal mit neuen Rational-Objekten
		r2 = new Rational(10, -6);
		System.out.println("Input: " + r1 + " und " + r2);
		System.out.println();
		r3 = (Rational) r1.clone();
		r4 = (Rational) r2.clone();
		r3.add(r4);
		System.out.println(r1 + " + " + r2 + " = " +  r3);
		r3 = (Rational) r1.clone();
		r4 = (Rational) r2.clone();
		r3.sub(r4);
		System.out.println(r1 + " - " + r2 + " = " +  r3);
		r3 = (Rational) r1.clone();
		r4 = (Rational) r2.clone();
		r3.mul(r4);
		System.out.println(r1 + " * " + r2 + " = " +  r3);
		r3 = (Rational) r1.clone();
		r4 = (Rational) r2.clone();
		r3.div(r4);
		System.out.println(r1 + " / " + r2 + " = " +  r3);
		System.out.println();
		System.out.println("HashCode " + r1 + ": " + r1.hashCode());
		System.out.println("HashCode " + r2 + ": " + r2.hashCode());
		System.out.println();
		System.out.println(r1 + " = " + r2 + ": " + r1.equals(r2));
	}
}
