import java.util.*;

public class DepthFirstSearch
{
    public static class Node
    {
        String name;
        ArrayList<Node> children = new ArrayList<>();

        public Node(String s)
        {
            name = s;
        }
    }

    public ArrayList<String> dfs(ArrayList<String> result)
    {
        result.add(this.name);

        for(int i = 0; i < children.size(); i++)
        {
            children.get(i).dfs(result);
        }

        return result;
    }

    public Node addChild(String name)
    {
        Node child = new Node(name);
        children.add(child);

        return this;
    }

    public static void main(String[] args) {
        DepthFirstSearch test1 = new DepthFirstSearch.Node("A");
        test1.addChild("B").addChild("C").addChild("D");
        test1.children.get(0).addChild("E").addChild("F");
        test1.children.get(2).addChild("G").addChild("H");
        test1.children.get(0).children.get(1).addChild("I").addChild("J");
        test1.children.get(2).children.get(0).addChild("K");

        ArrayList<String> result = new ArrayList<>();

        System.out.println(test1.dfs(result));
        
    }
}

public class DFS
{
    public static void main(String[] args) {
        DepthFirstSearch.Node test1 = new DepthFirstSearch.Node("A");
        test1.addChild("B").addChild("C").addChild("D");
        test1.children.get(0).addChild("E").addChild("F");
        test1.children.get(2).addChild("G").addChild("H");
        test1.children.get(0).children.get(1).addChild("I").addChild("J");
        test1.children.get(2).children.get(0).addChild("K");

        ArrayList<String> result = new ArrayList<>();

        System.out.println(test1.dfs(result));
    }
}