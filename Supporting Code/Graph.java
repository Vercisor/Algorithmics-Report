import java.util.*;
import java.io.*;
import java.awt.Color;


/**
 * Describe class Graph here.
 *
 *
 * Created: Mon Jan 26 16:05:17 2009
 *
 * @author <a href="mailto:apb@apb-desktop">Adam Prugel-Bennett</a>
 * @version 1.0
 */


public class Graph {

  /**
   * Creates a new <code>Graph</code> instance.
   * These are random instances with n nodes and
   * an edge probability of 0.5
   */
  public Graph(int n, double p) {
    neighbours = new ArrayList<List<Integer> >(n);
    for (int i = 0; i < n; i++) {
      neighbours.add(new ArrayList<Integer>());
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
	if (Math.random()<p) {
	  neighbours.get(i).add(j);
	}
      }
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph(15, 0.5);
    Colouring colouring = graph.bestColouring(3);
    graph.show(colouring);
  }
    
  public int degree(int i) {
    return neighbours.get(i).size();
  }

  public int neighbour(int i, int j) {
    return neighbours.get(i).get(j);
  }


  public int size() { return neighbours.size();}


  public Colouring bestColouring(int k) {
    int[] colouring = new int[size()];
    for (int i = 0; i < size(); i++) {
      colouring[i] = -1;
    }

    Colouring best_colouring  = new Colouring(size(), k);
    int[] partial_cost = new int[size()];
    int current = 0;
    partial_cost[0]=0;
    while (true) {
      if (colouring[current]<k-1) {
	colouring[current] = colouring[current]+1;
	if (current!=0) {
	  partial_cost[current] = partial_cost[current-1];
	  for (int neigh: neighbours.get(current)) {
	    if (colouring[current]==colouring[neigh]) {
	      partial_cost[current]++;
	    }
	  }
	}
	if (current==size()-1) {
	  if (partial_cost[current]<best_colouring.cost()) {
	    best_colouring = new Colouring(colouring,
					   partial_cost[current], k);
	  }
	} else {
	  current++;
	}
      } else {
	if (current==0) {
	  return best_colouring;
	}
	colouring[current] = -1;
	current--;
      }
    }
  }

  public void show(Colouring colouring) {
    Color[] colour = {Color.red, Color.yellow, Color.blue, Color.green, 
		      Color.black, Color.orange, Color.magenta, Color.cyan,
		      Color.gray, Color.pink};
    System.out.println("Number of colour conflicts = " 
		       + colouring.cost());

    if (colouring.no_colours()>colour.length) {
      return;
    }

    int cnt = 0;
    GraphDisplay gd = new GraphDisplay();
    gd.showInWindow(400,400,"Best Colouring");
    for (int k = 0;  k < colouring.no_colours() ; k++) {
      for (int i = 0; i < size(); i++) {
	if (colouring.get(i)==k) {
	  double angle = 2*cnt*Math.PI/size();
	  gd.addNode(i, Math.sin(angle), Math.cos(angle), colour[k]);
	  cnt++;
	}
      }
    }
    for (int i = 1; i < size(); i++) {
      for (int j: neighbours.get(i)) {
	gd.addEdge(i,j);
      }
    }
  }
  
  private List<List<Integer> > neighbours;
}
