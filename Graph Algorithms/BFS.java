class BFS {
    static class Node {
      String name;
      ArrayList<Node> children = new ArrayList<Node>();
  
      public Node(String name) {
        this.name = name;
      }
  
    public ArrayList<String> breadthFirstSearch(ArrayList<String> result) 
    {
        Queue<Node> q = new LinkedList<>();
    
        q.offer(this);
        
        while(!q.isEmpty())
        {
            Node current = q.poll();
            result.add(current.name);
            
            for(int i = 0; i < current.children.size(); i++)
            {
                q.offer(current.children.get(i));
            }
        }
        
        return result;			
    }
  
    public Node addChild(String name) 
    {
        Node child = new Node(name);
        children.add(child);
        return this;
    }
    }
  }
  