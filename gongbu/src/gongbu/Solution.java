package gongbu;

import java.util.ArrayList;

public class Solution {

	static int V=5;
	static int[] visited = new int[V];
	
	static int[] onstack = new int[V];
	static int[] parent = new int[V];
	static int visitedCnt =0;
	static boolean found = false;
	static ArrayList<Integer>[] adjList = new ArrayList[V];
	
	public static void main(String args[]){
		adjList[1]=new ArrayList<Integer>();
		adjList[1].add(0);
		
		adjList[2]=new ArrayList<Integer>();
		adjList[2].add(0);
		adjList[2].add(1);
		adjList[2].add(4);
		
		adjList[3]=new ArrayList<Integer>();
		adjList[3].add(2);
		
		adjList[4]=new ArrayList<Integer>();
		adjList[4].add(3);
		
		for(int i=0;i< V;i++){
			visited[i]=-1;
			onstack[i]=0;
		}
		visitedCnt=0;
		
		for(int i=0;i<V;i++){
			if(visited[i]==-1){
				dfs(i);
				if(found){
					break;
				}

			}
		}
		
		
		
	}
	
	public static void dfs(int node){
		onstack[node]=1;
		visited[node]= visitedCnt++;
		
		if(adjList[node] != null){
			for(int adjacent : adjList[node]){
				if(visited[adjacent]==-1){
					parent[adjacent] = node;
					
					dfs(adjacent);
					if(found){
						return;
					}
				}else if(onstack[adjacent]==1 && visited[adjacent]<visited[node]){
					found = true;
					printPath(adjacent,node);
					return;
				}
			}
		}
	}
	public static void printPath(int start,int end){
		if(start !=end && end !=0){
			printPath(start,parent[end]);
		}
		
		System.out.println(end +1);
	}
}
