package app.exercise.adt;

import java.util.AbstractCollection;
import java.util.Collection;

import app.exercise.algebra.CompRational;

/**
 * Klasse zum Erstellen eines BSTree-Objektes
 * @param <E> typ
 */
public class BSTree<E extends Comparable<E>> extends AbstractCollection<E> implements Iterable<E> {

    /**
     * Wurzelknoten
     */
    private Node<E> root;

    /**
     * Add-Methode zum Hinzufügen eines neuen Knotens
     *
     * @param E element
     * @return boolean
     */
    @Override
    public boolean add(E element) {
        return insert(root, element);
    }

    /**
     * Eigentliche Methode zum hinzufügen eines neuen Knotens
     * @param Node node
     * @param E element
     * @return booelean
     */
    private boolean insert(Node<E> node, E element) {
        //Falls Baum leer ist
        if (root == null) {
            root = new Node<E>(element);
            return true;
        }
        //wenn der Wert des Knotens kleiner als der Wert des elements & der linke Knoten frei ist lege einen Neuen Knoten mit dem Wert von element an
        CompRational nodeValue = (CompRational) node.getValue();
        int result = nodeValue.compareTo((CompRational) element);
        if (result < 0) {
            if (node.getRight() == null) {
                node.setRightNode(new Node<>(element));
            } else {
                insert(node.getRightNode(), element);
            }
            return true;
        } else if (result > 0) {
            if (node.getLeft() == null) {
                node.setLeftNode(new Node<>(element));
            } else {
                insert(node.getLeftNode(), element);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove-Methode zum Löschen eines Knotens
     *
     * @param Objekt o
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object o) {
        root = remove(root, (E) o);
        return root != null;
    }

    /**
     * Eigentliche Methode zum Löschen eines Knotens
     * @param Node parent
     * @param E value
     * @return boolean
     */
    Node<E> remove(Node<E> root, E key) {
        // Wenn der (Teil-) Baum leer ist
        if (root == null) {
            return null;
        }

        // Iteriere rekursiv durch den Baum
        if (key.compareTo(root.getValue()) < 0) {
            root.setLeftNode(remove(root.getLeftNode(), key));
        } else if (key.compareTo(root.getValue()) > 0) {
            root.setRightNode(remove(root.getRightNode(), key));
        } else { // Wenn key der gleiche ist wie root's key dann wird dieser Knoten gelöscht
            // Knoten mit einem oder keinem Nachfolgerknoten
            if (root.getLeftNode() == null) {
                return root.getRightNode();
            } else if (root.getRightNode() == null) {
                return root.getLeftNode();
            }

            // Knoten mit zwei Nachfolgern: erhalte kleinsten Knoten im rechten Teilbaum
            root.setValue(minValue(root.getRightNode()));

            // Lösche den Knoten
            root.setRightNode(remove(root.getRightNode(), root.getValue()));
        }
        return root;
    }

    /*
     * Methode zum Finden des inorder-nächsten Knoteninhalts
     * @param Node<E> root
     * @return E
     */
    E minValue(Node<E> root) {
        while (root.getLeftNode() != null) {
            root = root.getLeftNode();
        }
        return root.getValue();
    }

    /**
     * Methode, die einen Iterator zum aktuellen Baum erzeugt
     * @return BSTreeIterator<E>
     */
    @Override
    public BSTreeIterator<E> iterator() {
        return new BSTreeIterator<>(this);
    }

    /**
     * Methode, welche die Anzahl der Knoten eines Baumes zurückgibt
     * @return int
     */
    @Override
    public int size() {
        int size = 0;
        BSTreeIterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
            size++;
        }
        return size;
    }

    /**
     * Methode um zu prüfen ob der Baum leer ist
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Methode um zu prüfen ob ein übergebenes Objekt im Baum vorhanden ist
     * @param Object o
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean contains(Object o) {
        BSTreeIterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E value = iterator.next();
            if (value.compareTo((E) o) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Methode um zu prüfen, ob mehrere Objekte im Baum vorhanden sind
     * @param Collection<E> c
     * @return boolean
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    /**
     * Methode um einen Suchbaum in ein Array zu übertragen
     * @return Object[]
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        BSTreeIterator<E> iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            array[i] = iterator.next();
            i++;
        }
        return array;
    }

    /**
     * Methode um eine kompakte Ausgabe eines Baumes zu erzeugen
     * @return String
     */
    @Override
    public String toString() {
        BSTreeIterator<E> iterator = iterator();
        String s = "";

        while (iterator.hasNext()) {
            s += iterator.next() + ", ";
        }
        return s.substring(0, s.length() - 2);
    }

    /**
     * Get-Methode um auf root zuzugreifen
     * @return Node<E>
     */
    public Node<E> getRoot() {
        return root;
    }
}