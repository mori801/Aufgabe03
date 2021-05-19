package exercise.algebra;

/**
 * Interface, welches Vorschriften zu Bruchoperationen bietet
 */
public interface Fractional {
    /** get numerator */
    long getN();
    /** get denominator */
    long getD();
    /** add operand to object */
    void add(Fractional operand);
    /** subtract operand from object
     * @return*/
    void sub(Fractional operand);
    /** multiply object by operand */
    void mul(Fractional operand);
    /** divide object by operand */
    void div(Fractional operand);
    /** new additive inverse object */
    Fractional negation ();
    /** new multiplicative inverse object */
    Fractional reciprocal ();
}
