package com.my.java.suanfa.Grap;

public class MyGraph {
    private final int MAX_VERTS = 20;
    private Vertex vertList[];
    private int adjMat[][];
    private int nVerts;
    private char sortedArray[];

    public MyGraph() {
        vertList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        sortedArray = new char[MAX_VERTS];
    }

    public void addVertex(char label) {
        vertList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertList[v].label + " ");
    }

    public void topo() {
        int orig_nVerts = nVerts;
        while (nVerts > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("error:graph has cycles");
                return;
            }
            sortedArray[nVerts - 1] = vertList[currentVertex].label;
            deleteVertex(currentVertex);
        }

        System.out.print("topologically sorted order : ");
        for (int i = 0; i < orig_nVerts; i++) {
            System.out.print(sortedArray[i]);
        }
        System.out.println();
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }

    public void deleteVertex(int delVert) {
        if (delVert != (nVerts - 1)) {
            for (int i = delVert; i < nVerts - 1; i++) {
                vertList[i] = vertList[i + 1];
            }

            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            for (int col = delVert; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }
        nVerts--;
    }

    public int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVerts; row++) {
            isEdge = false;
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge)
                return row;
        }
        return -1;
    }
    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');

        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.topo();

    }
}
