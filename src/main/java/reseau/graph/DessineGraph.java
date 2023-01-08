package reseau.graph;

import reseau.Arete;
import reseau.Point;
import reseau.ReseauRoutier;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.DepthFirstIterator;


import java.util.Iterator;


/**
 * Cette classe donne un exemple d'utilisation des classes {@code Point}, {@code Arete}, {@code RéseauRoutier}.
 * <p>
 * </p>
 * Les classes {@code Point}, {@code Arete}, {@code RéseauRoutier} sont utilisées pour alimenter la librairie <a href="https://jgrapht.org/">{@link JGraphT}</a>.
 */
public class DessineGraph {
    public static void main(String[] args) {
        // création d'une instance de la classe ReseauRoutier
        ReseauRoutier reseau = new ReseauRoutier();
        // Lecture du fichier contenant la description du réseau routier
        reseau.lireCarte("reseau.txt");

        // Création d'une représentation du réseau routier sous la forme d'une classe de la librairie JGraphT
        Graph<Point, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // Stockage des points et des arêtes du réseau routier dans le graphe de la librairie JGraphT.
        for (Point p : reseau.getPoints())
            g.addVertex(p);
        for (Arete a : reseau.getRoutes()) {
            // Ajout d'une arête : 2 points et une pondération
            Graphs.addEdge(g,reseau.getPointById(a.getIdP1()), reseau.getPointById(a.getIdP2()), a.getPoids()) ;
        }

        // Parcours du graphe et affichage pour chaque point des points reliés par une arête
        Iterator<Point> iter = new DepthFirstIterator<>(g);
        while (iter.hasNext()) {
            Point vertex = iter.next();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Vertex %d is connected to %d neighbour(ors) : %n",vertex.getId(), g.outgoingEdgesOf(vertex).size()));
            for (DefaultWeightedEdge e : g.outgoingEdgesOf(vertex)) {
                sb.append(String.format("%d : %5.2f%n", g.getEdgeTarget(e).getId(), g.getEdgeWeight(e)));
            }
            System.out.println(sb.toString());
        }
    }
}

