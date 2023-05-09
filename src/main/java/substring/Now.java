package substring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//4, [[1, 0], [2, 0], [3, 1], [3, 2]]

public class Now {

	public static void main(String[] args) {
		int len = 4;
		List<Node> nodeList = new ArrayList<Node>();
		int[][] arr = new int[len][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 2;
		arr[1][1] = 0;
		arr[2][0] = 3;
		arr[2][1] = 1;
		arr[3][0] = 3;
		arr[3][1] = 2;
		Node node = null;
		for (int i = 0; i < len; i++) {
			// If node already exists, update the new parent only
			node = checkIdExists(arr[i][0], nodeList);
			if (null == node) {
				node = new Node();
			}
			node.setId(arr[i][0]);
			Node parent = new Node();
			parent.setId(arr[i][1]);
			node.addParent(parent);
			nodeList.add(node);

		}
		System.out.println(arrangeIds(nodeList));

	}

	private static String arrangeIds(List<Node> nodeList) {
		// build a path from parent to child
		Map<Integer, String> pathMap = new HashMap<Integer, String>();
		for (Node n : nodeList) {
			for (Integer id : n.getParentIDs()) {
				String path = "";
				if (pathMap.containsKey(id)) {
					path = pathMap.get(id) + "->" + n.getId();

				}
				path = id + "->" + n.getId();
				pathMap.put(id, path);

			}

		}
		System.out.println(pathMap);
		// for each parent in the list, find the child

		return null;
	}

	private static Node checkIdExists(int i, List<Node> nodeList) {
		for (Node n : nodeList) {
			if (n.getId() == i) {
				return n;
			}
		}
		return null;
	}
}
class Tree {
	List<Node> parents;
	List<Node> child;
}
class Node implements Comparable<Node> {

	Integer id;
	List<Node> parentList;

	public Node() {
		this.parentList = new ArrayList<Node>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Node> getParentList() {
		return parentList;
	}

	public List<Integer> getParentIDs() {
		List<Integer> idList = new ArrayList<Integer>();
		for (Node parent : parentList) {
			idList.add(parent.getId());
		}
		return idList;
	}

	public void addParent(Node parent) {
		this.parentList.add(parent);
	}

	@Override
	public int compareTo(Node other) {
		return this.getId().compareTo(other.getId());
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(0);
		for (Node parent : parentList) {
			result.append("[" + parent.getId() + "->" + id + "]");
		}
		return result.toString();
	}

}