package test;

import java.util.ArrayList;
import java.util.List;

class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
		allPathsSourceTarget(graph).toString();
	}

	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.add(0);
		list.add(new ArrayList<>(newList));
		for (int i = 0; i < graph.length - 1; i++) {
			int j = 0;
			while (j < list.size()) {
				if (list.get(j).get(list.get(j).size() - 1) == i) {
					for (int k = 0; k < graph[i].length; k++) {
						newList = (ArrayList<Integer>) list.get(j);
						newList.add(graph[i][k]);
						if (graph[i][k] < newList.get(newList.size() - 2)) {
							newList.add(graph[graph[i][k]][0]);
						}
						list.add(new ArrayList<>(newList));
						newList.remove(newList.size() - 1);

					}
				}
				j++;
			}
		}
		int i = 0;
		while (i < list.size()) {
			if (list.get(i).get(list.get(i).size() - 1) != graph.length - 1) {
				list.remove(i);
			} else {
				i++;
			}
		}
		return list;
	}

}