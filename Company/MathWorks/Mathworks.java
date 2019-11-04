import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Mathworks {
    int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);

    }
    boolean DFS(int v,boolean visited[],int dest,HashMap<Integer,LinkedList<Integer>> map)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        // System.out.print(v+" ");
        if(v==dest){
            return true;
    }
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = map.get(v).listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            boolean check=false;
            if (!visited[n])
                check= DFS(n, visited,dest,map);
            if(check==true){
                return true;
            }
        }
        return false;
    }
    void connectedCities(int n,int g, List<Integer> originCities,List<Integer> destinationCities){
        List<Integer> allcities=new LinkedList<>();
        allcities.addAll(destinationCities);
        allcities.addAll(originCities);

        HashMap<Integer,LinkedList<Integer>> map=new HashMap<Integer, LinkedList<Integer>>();
        for(int city:allcities){
            map.put(city,new LinkedList<>());
        }
        for( int scity:originCities){
            if(!map.containsKey(scity)){
               map.put(scity,new LinkedList<>());
            }
            for(int city:destinationCities) {
                if (!map.containsKey(city)) {
                    map.put(city, new LinkedList<>());
                }
                int div = gcd(scity, city);
                if (div > g) {
                    map.get(scity).add(city);
                    map.get(city).add(scity);
                }
            }

            }
            for(int i=0;i<originCities.size();i++){
                boolean visited[]=new boolean[n+1];
                boolean check=DFS(originCities.get(i),visited,destinationCities.get(i),map);
                System.out.println(originCities.get(i)+"  "+destinationCities.get(i)+"   "+check);
            }

        }

    public static void main(String arg[]){
        Mathworks mw=new Mathworks();
        List<Integer> originCities=new LinkedList<>();
        originCities.add(1);
        originCities.add(2);
        originCities.add(3);
        List<Integer> destCities=new LinkedList<>();
        destCities.add(4);
        destCities.add(5);
        destCities.add(6);
        mw.connectedCities(6,2,originCities,destCities);
    }
}