package reseau.graph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;

import reseau.Arete;
import reseau.Point;
import reseau.ReseauRoutier;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.alg.tour.RandomTourTSP;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import javax.swing.*;

public class ShowGraphApp extends Application {

    private JGraphXAdapter<Point, DefaultWeightedEdge> jgxAdapter;

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param stage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage stage) throws Exception {
        final SwingNode swingNodeDefaut = new SwingNode();
        createSwingContent(swingNodeDefaut, createGraph());
        final SwingNode swingNodeRandomTour = new SwingNode();
        createSwingContent(swingNodeRandomTour, createGraphRandomTour());
        final SwingNode swingNodeHeldKarp = new SwingNode();
        createSwingContent(swingNodeHeldKarp, createGraphHeldKarp());
        HBox hbox = new HBox();
        hbox.getChildren().add(swingNodeDefaut);
        hbox.getChildren().add(swingNodeRandomTour);
        hbox.getChildren().add(swingNodeHeldKarp);

        Scene scene = new Scene(hbox, 800, 600);

        stage.setScene(scene);
        stage.setTitle("Graphe dans javaFX");
        stage.show();

    }

    private void createSwingContent(final SwingNode swingNode, Graph<Point, DefaultWeightedEdge> graph) {
        SwingUtilities.invokeLater(() -> {
            jgxAdapter = new JGraphXAdapter<>(graph);
            mxGraphComponent component = new mxGraphComponent(jgxAdapter);
            component.setConnectable(false);
            component.getGraph().setAllowDanglingEdges(false);
            mxCircleLayout layout = new mxCircleLayout(jgxAdapter);

            // center the circle
            int radius = 100;
            layout.setX0((268 / 2.0) - radius);
            layout.setY0((200 / 2.0) - radius);
            layout.setRadius(radius);
            layout.setMoveCircle(true);

            layout.execute(jgxAdapter.getDefaultParent());
            swingNode.setContent(component);
        });
    }

    private Graph<Point, DefaultWeightedEdge> createGraph() {
        // création d'une instance de la classe ReseauRoutier
        ReseauRoutier reseau = new ReseauRoutier();
        // Lecture du fichier contenant la description du réseau routier
        reseau.lireCarte("reseau.txt");

        // Création d'une représentation du réseau routier sous la forme d'une classe de la librairie JGraphT
        Graph<Point, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Stockage des points et des arêtes du réseau routier dans le graphe de la librairie JGraphT.
        for (Point p : reseau.getPoints())
            g.addVertex(p);
        for (Arete a : reseau.getRoutes()) {
            // Ajout d'une arête : 2 points et une pondération
            Graphs.addEdge(g,reseau.getPointById(a.getIdP1()), reseau.getPointById(a.getIdP2()), a.getPoids()) ;
        }

        return g;
    }
    
    private Graph<Point, DefaultWeightedEdge> createGraphRandomTour(){
    	Graph<Point, DefaultWeightedEdge> graph = createGraph();
    	Graph<Point, DefaultWeightedEdge> otherGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        
        RandomTourTSP<Point, DefaultWeightedEdge> tourPath = new RandomTourTSP<>();
        
        GraphPath<Point,DefaultWeightedEdge> graphPath = tourPath.getTour(graph);
        Graphs.addAllEdges(otherGraph, graph, graphPath.getEdgeList());
        
    	return otherGraph;
    }
    
    private Graph<Point, DefaultWeightedEdge> createGraphHeldKarp(){
    	Graph<Point, DefaultWeightedEdge> graph = createGraph();
    	Graph<Point, DefaultWeightedEdge> otherGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        
    	HeldKarpTSP<Point, DefaultWeightedEdge> tourPath = new HeldKarpTSP<>();
        
        GraphPath<Point,DefaultWeightedEdge> graphPath = tourPath.getTour(graph);
        Graphs.addAllEdges(otherGraph, graph, graphPath.getEdgeList());
        
    	return otherGraph;
    }
}
