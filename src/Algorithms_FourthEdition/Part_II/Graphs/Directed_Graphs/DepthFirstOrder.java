package Algorithms_FourthEdition.Part_II.Graphs.Directed_Graphs;

import Algorithms_FourthEdition.Part_I.I_Fundamentals.II_Stack.Stack;

//Topological sort in a DAG
public class DepthFirstOrder {
    private boolean[] markerd;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraphs G){
        reversePost = new Stack<>();
        markerd =  new boolean[G.V()];
        for (int v = 0; v < G.V(); v ++){
            if (!markerd[v]) dfs(G,v);
        }
    }

    private void dfs(Digraphs G, int v) {
        markerd[v] = true;
        for (int w : G.adj(v)){
            if (!markerd[w]) dfs(G,w);
        }
        reversePost.push(v);
    }

    public Stack<Integer> reversePost(){
        return reversePost;// returns all verticles in "reverse DFS postorder"
    }
}
