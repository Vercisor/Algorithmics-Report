import java.io.*;
import java.util.*;

public class MySortAL
{
    public static void main(String [] args )
    {
	int N = Integer.parseInt(args[0]);
	List<Double> data = new ArrayList<Double>(N);
	for (int i=0; i<N; i++)
	    data.add(Math.random());
	Collections.sort(data);
	for (double d: data)
	    System.out.println(d);
    }
}
