# Assignment A4: URBANISM

  - Khalid Farag [faragk1@mcmaster.ca]

## Overview

This module pathfinder, provides an implementation of a Graph data structure, and a pathfinding algorithm that uses the graph to find the shortest path between two nodes. The graph data structure allows users to add nodes and edges to the graph, assign attributes to them.

## Using the Libary


### Creating a Graph

The graph data structure is uses the `Node`, `Edge` and `Graph` interfaces. The `Node` class represents a node in the graph. The `Edge` class represents an edge in the graph. The `Graph` class represents the graph data structure.


To create a graph, use the `Graph` class. The graph class has the following methods:

  * `addNode` - adds a node to the graph
  * `addEdge` - adds an edge to the graph
  * `getNodes` - returns a list of all nodes in the graph
  * `getEdges` - returns a list of all edges in the graph
  * `getNeighbours` - returns a list of all neighbours of a node
  * `setNeighbours` - sets the neighbour of a node
  * `getEdgeIndex` - returns the index of an edge in the graph
  * `getNumberOfNodes` - returns the number of nodes in the graph
  * `getNumberOfEdges` - returns the number of edges in the graph


### Creating a PathFinder

To extend on the the pathfinder, you must follow the pathfinder interface. The pathfinder interface has the following methods:

  * `findPath` - finds the shortest path between two nodes
  * `setGraph` - sets the graph to be used by the pathfinder
  * `setEndNode` - sets the end node to be used by the pathfinder
  * `setStartNode` - sets the start node to be used by the pathfinder
  * `getPathCost` - returns the cost of the path
  * `getPath` - returns the path as a list of nodes
  * `getPathEdges` - returns the path as a list of edges
  * `getEndNode` - returns the end node
  * `getStartNode` - returns the start node

  ### Extending the PathFinder

  To extend the pathfinder, you must implement the pathfinder interface. The pathfinder interface using the methods above while incorprating the graph data structure. The pathfinder that is used in this module is the Dijkstra. The Dijkstra pathfinder uses the graph data structure to find the shortest path between two nodes. Therefore to create a new path finder, you must implement the pathfinder interface and use the graph data structure to find the shortest path between two nodes.




