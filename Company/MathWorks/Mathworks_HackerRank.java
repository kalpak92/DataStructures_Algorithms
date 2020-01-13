public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {

    int[] root = new int[n + 1];  // starting from 1 hence n+1.
    int[] ids = new int[n + 1];   // number of nodes under that cluster. Number of connections

    for (int i = 0; i <= n; i++) {
        root[i] = i;
        ids[i] = 1;
    }

    for (int i = g + 1; i <= n; i++)
        for (int j = 2 * i; j <= n; j += i) // check in multiples
            unionFind(j, i, root, ids);

    List<Integer> res = new ArrayList<>(originCities.size());

    Iterator<Integer> itSrc = originCities.iterator();
    Iterator<Integer> itDest = destinationCities.iterator();

    while (itSrc.hasNext() && itDest.hasNext())
        res.add(getRoot(itSrc.next(), root) == getRoot(itDest.next(), root) ? 1 : 0);

    return res;
}

private static void unionFind(int a, int b, int[] root, int[] ids) {
    int aRoot = getRoot(a, root);
    int bRoot = getRoot(b, root);

    if (aRoot == bRoot)
        return;


    // of the two nodes, 
    //the node with the most number of connected components 
    //becomes the root of the cluster.
    
    if (ids[aRoot] < ids[bRoot]) {
        root[aRoot] = root[bRoot];
        ids[bRoot] += ids[aRoot];
    } else {
        root[bRoot] = root[aRoot];
        ids[aRoot] += ids[bRoot];
    }
}

private static int getRoot(int a, int[] root) {
    while (a != root[a])
        a = root[a];
    return a;
}