// Aluno: Natan Evangelista Rubenich
// Semestre: 2021/1
// Professor: CIDES SEMPREBOM BEZERRA
// Disciplina: Estrutura de dados II
class StackX {

    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

}

class Vertex {

    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }

}

class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];

        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
        theStack = new StackX();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }
}

class DFSApp {

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('J');
        theGraph.addVertex('T');
        theGraph.addVertex('Q');
        theGraph.addVertex('N');
        theGraph.addVertex('P');
        theGraph.addVertex('B');
        theGraph.addVertex('M');
        theGraph.addVertex('R');
        theGraph.addVertex('Z');
        theGraph.addVertex('X');
        theGraph.addVertex('C');
        theGraph.addVertex('N');
        theGraph.addVertex('M');
        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);
        theGraph.addEdge(4, 5);
        theGraph.addEdge(5, 6);
        theGraph.addEdge(6, 7);
        theGraph.addEdge(7, 8);
        theGraph.addEdge(8, 9);
        theGraph.addEdge(9, 10);
        theGraph.addEdge(10, 11);
        theGraph.addEdge(11, 12);
        System.out.print("Visits: ");
        theGraph.dfs();
        System.out.println();
    }
}
