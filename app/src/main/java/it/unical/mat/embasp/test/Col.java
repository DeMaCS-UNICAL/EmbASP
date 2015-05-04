package it.unical.mat.embasp.test;

import it.unical.mat.embasp.mapper.Predicate;
import it.unical.mat.embasp.mapper.Term;

/**
 */

@Predicate("col")
public class Col {

    public Col() {
    }

    public Col(String edge, String color) {
        this.edge = edge;
        this.color = color;
    }

    @Term(0)
    String edge;

    @Term(1)
    String color;

    public void setEdge(String edge) {
        this.edge = edge;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEdge() {
        return edge;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Col{" +
                "edge='" + edge + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
