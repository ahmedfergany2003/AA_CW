package task8;

import java.util.*;

public class RT {
    
    static final int NUM_VERTICES = 5;
    
    // Finds the vertex with the minimum distance value, from the set of vertices
    // not yet included in shortest path tree
    int getMinimumDistanceVertexIndex(int[] distances, boolean[] shortestPathSet) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertexIndex = -1;
        
        for (int vertexIndex = 0; vertexIndex < NUM_VERTICES; vertexIndex++) {
            if (shortestPathSet[vertexIndex] == false && distances[vertexIndex] <= minDistance) {
                minDistance = distances[vertexIndex];
                minDistanceVertexIndex = vertexIndex;
            }
        }
        return minDistanceVertexIndex;
    }
    
    // Prints the solution
    void printSolution(int[] distances, int[] parents) {
        System.out.println("The shortest path from source vertex 0 to all other vertices are: ");
        char[] vertexNames = {'A', 'B', 'C', 'D', 'E'};
        
        for (char vertexName : vertexNames) {
            int vertexIndex = vertexName - 'A'; // convert character to index
            System.out.print("To " + vertexName + " the path is ");
            Stack<Integer> path = new Stack<>();
            int current = vertexIndex;
            path.push(current);
            while (parents[current] != -1) {
                path.push(parents[current]);
                current = parents[current];
            }
            while (!path.empty()) {
                System.out.print(vertexNames[path.pop()] + " "); // convert index to character
            }
            System.out.println();
        }
    }
    
    // Implements Dijkstra's single source shortest path algorithm for a graph represented
    // using adjacency matrix representation
    void dijkstra(int[][] graph, int sourceVertex) {
        int[] distances = new int[NUM_VERTICES];
        int[] parents = new int[NUM_VERTICES];
        boolean[] shortestPathSet = new boolean[NUM_VERTICES];
        
        // Initialize all distances as INFINITE and shortestPathSet[] as false
        for (int vertexIndex = 0; vertexIndex < NUM_VERTICES; vertexIndex++) {
            distances[vertexIndex] = Integer.MAX_VALUE;
            shortestPathSet[vertexIndex] = false;
            parents[vertexIndex] = -1;
        }
        
        distances[sourceVertex] = 0;
        
        // Find shortest path for all vertices
        for (int iteration = 0; iteration < NUM_VERTICES - 1; iteration++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed.
            int currentVertexIndex = getMinimumDistanceVertexIndex(distances, shortestPathSet);
            
            shortestPathSet[currentVertexIndex] = true;
            
            // Update distance value of the adjacent vertices of the picked vertex.
            for (int adjacentVertexIndex = 0; adjacentVertexIndex < NUM_VERTICES; adjacentVertexIndex++) {
                // Check if vertex is not in shortest path set, there is an edge between the current vertex and the adjacent vertex
                // and the distance of the current vertex is not infinite
                if (!shortestPathSet[adjacentVertexIndex] && graph[currentVertexIndex][adjacentVertexIndex] != -1 && 
                    distances[currentVertexIndex] != Integer.MAX_VALUE
                    && distances[currentVertexIndex] + graph[currentVertexIndex][adjacentVertexIndex] < distances[adjacentVertexIndex]) {
                    distances[adjacentVertexIndex] = distances[currentVertexIndex] + graph[currentVertexIndex][adjacentVertexIndex];
                    parents[adjacentVertexIndex] = currentVertexIndex;
                }
            }
        }
        
        // Print the solution
        printSolution(distances, parents);
    }
    
    // Main method
    public static void main(String[] args) {
        // Define the graph using an adjacency matrix
        int[][] graph = new int[][] {
                {-1, 1, -1, 1, 1},
                {-1, -1, 1, -1, -1},
                {-1, -1, -1, -1, 1},
                {-1, -1, 1, -1, 1},
                {-1, -1, -1, -1, -1}
        };
        
        // Create an instance of the DijkstraAlgorithm class and run the algorithm
        RT rt = new RT();
        rt.dijkstra(graph, 0);
    }
}