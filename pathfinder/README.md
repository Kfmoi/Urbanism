# Assignment A2: Mesh Generator

  - Khalid Farag [faragk1@mcmaster.ca]

## Overview

This module pathfinder, provides an implementation of a Graph data structure, and a pathfinding algorithm that uses the graph to find the shortest path between two nodes. The graph data structure allows users to add nodes and edges to the graph, assign attributes to them.

## Using the Libary

### Creating a Graph

To create a graph, use the `Graph` class. The graph class has the following methods:

  * `addNode` - adds a node to the graph
  * `addEdge` - adds an edge to the graph
  * `getNode` - returns a node from the graph
  * `getEdge` - returns an edge from the graph
  * `getNodes` - returns a list of all nodes in the graph
  * `getEdges` - returns a list of all edges in the graph
  * `getNeighbours` - returns a list of all neighbours of a node
  * `setNeighbours` - sets the neighbour of a node
  * `getEdgeIndex` - returns the index of an edge in the graph


### Creating a PathFinder

To extend on the the pathfinder, you must follow the pathfinder interface. The pathfinder interface has the following methods:

  * `findPath` - finds the shortest path between two nodes
  * `setGraph` - sets the graph to be used by the pathfinder
  * `setEndNode` - sets the end node to be used by the pathfinder
  * `setStartNode` - sets the start node to be used by the pathfinder
  * `getPathCost` - returns the cost of the path
  * `getPath` - returns the path as a list of nodes
  * `getPathNodes` - returns the path as a list of nodes
  * `getPathEdges` - returns the path as a list of edges

  This will allow any other class to use the pathfinder interface, and use the pathfinder class to find the shortest path between two nodes.The one used in this project is the DijkstraPathFinder class.




