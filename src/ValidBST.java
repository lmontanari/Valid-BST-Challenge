import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidBST {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberOfTestes = sc.nextInt();

		for (int i = 0; i < numberOfTestes; i++) {
			int howManyNumbers = sc.nextInt();

			List<Integer> values = new ArrayList<>();
			String theirTree = "";
			for (int t = 0; t < howManyNumbers; t++) {
				int a = sc.nextInt();
				values.add(a);

				theirTree = (theirTree.equals("") ? theirTree : theirTree + " ") + a;
			}

			solution(values, theirTree);
		}
	}

	static void solution(List<Integer> values, String theirTree) {
		Node balancedTree = null;
		for (Integer integer : values) {
			balancedTree = updateNode(balancedTree, integer);
		}

		String balancedTreeStringRepresentation = balancedTree.toString();
		System.out.println("theirTree=" + theirTree);
		System.out.println("balancedTreeStringRepresentation=" + balancedTreeStringRepresentation);
		if (theirTree.equals(balancedTreeStringRepresentation)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static Node updateNode(Node node, Integer value) {
		if (node == null) {
			node = new Node(value);
			return node;
		}

		int compareTo = node.getNodeValue().compareTo(value);

		if (compareTo == 1) {
			node.setLeftTree(updateNode(node.getLeftTree(), value));
		} else {
			node.setRightTree(updateNode(node.getRightTree(), value));
		}

		return node;
	}
}

class Node {
	private Integer nodeValue;
	private Node leftTree;
	private Node rightTree;

	@Override
	public String toString() {
		if (nodeValue == null) {
			return "";
		}
		String result = nodeValue + myToString(leftTree) + myToString(rightTree) + " ";
		return result.substring(0, result.length() - 1);
	}

	private String myToString(Node node) {
		if (node == null) {
			return "";
		}

		return " " + node.toString();
	}

	public Node(Integer nodeValue) {
		this.nodeValue = nodeValue;
	}

	public Integer getNodeValue() {
		return nodeValue;
	}

	public Node getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(Node leftTree) {
		this.leftTree = leftTree;
	}

	public void setNodeValue(Integer nodeValue) {
		this.nodeValue = nodeValue;
	}

	public void setRightTree(Node rightTree) {
		this.rightTree = rightTree;
	}

	public Node getRightTree() {
		return rightTree;
	}
}