import java.util.*;
import java.io.*;

/**
 * Describe class Colouring here.
 *
 *
 * Created: Tue Jan 27 16:06:57 2009
 *
 * @author <a href="mailto:apb@apb-desktop">Adam Prugel-Bennett</a>
 * @version 1.0
 */
public class Colouring {
  public Colouring(int n, int maxcol) {
    colours = new int[n];
    for (int i = 0; i < n; i++) {
      colours[i] = -1;
    }
    c = 100000;
    k = maxcol;
  }
  public Colouring(Colouring colouring) {
    colours = new int[colouring.size()];
    System.arraycopy(colouring.colours, 0, colours, 0, colouring.size());
    c = colouring.cost();
    k = colouring.no_colours();
  }

  public Colouring(int[] cols, int the_cost, int maxcol) {
    colours = new int[cols.length];
    System.arraycopy(cols, 0, colours, 0, cols.length);
    c = the_cost;
    k = maxcol;
    
  }
  public int get(int node) {return colours[node];}
  public void set(int node, int col) {colours[node]=col;}
  public int cost() {return c;}
  public void set_cost(int cc) {c=cc;}
  public int no_colours() {return k;}
  public int size() {return colours.length;}

  private int[] colours;
  private int c;
  int k;
}

