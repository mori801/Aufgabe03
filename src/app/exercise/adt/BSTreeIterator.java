package app.exercise.adt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Klasse um Interatoren zu erzeugen
 * @param <E> typ
 */
public class BSTreeIterator<E extends Comparable<E>> implements Iterator<E> {

    private Node<E> node;
    private int index = 0;
    private List<Node<E>> nodeList;

    /**
     * Konstruktor für einen Iterator-Objekt
     * @param BSTree tree
     */
    public BSTreeIterator(app.exercise.adt.BSTree<E> tree) {
        this.nodeList = getInorderedList(tree.getRoot());
    }

    /**
     * Methode um zu prüfen ob ein nächster Knoten existiert
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        return index < nodeList.size();
    }

    /**
     * Springe zum nächsten Element
     * @return E
     */
    @Override
    public E next() {
        node = nodeList.get(index);
        index++;
        return node.getValue();
    }

    /**
     * Methode um den Suchbaum durchzugehen
     * @param Node node
     * @return Liste von Knotenelementen
     */
    private List<Node<E>> getInorderedList(Node<E> node){
        List<Node<E>> list = new ArrayList<>();
        if (node.getLeftNode() != null) {
            list.addAll(getInorderedList(node.getLeftNode()));
        }
        list.add(node);
        if (node.getRightNode() != null) {
            list.addAll(getInorderedList(node.getRightNode()));
        }
        return list;
    }
}