import java.io.*;
import java.util.*;

public class MySort
{
    public static void main(String [] args )
    {
	int N = Integer.parseInt(args[0]);
	double[] data = new double[N];
	for (int i=0; i<N; i++)
	    data[i] = Math.random();
	Arrays.sort(data);
	for (double d: data)
	    System.out.println(d);
    }
}
