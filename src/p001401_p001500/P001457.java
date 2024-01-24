package p001401_p001500;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class P001457 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		System.out.println(pseudoPalindromicPaths(root));

		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.left.left = new TreeNode(1);
		root2.left.right = new TreeNode(3);
		root2.left.right.right = new TreeNode(1);
		root2.right = new TreeNode(1);
		System.out.println(pseudoPalindromicPaths(root2));

		TreeNode root3 = new TreeNode(9);
		System.out.println(pseudoPalindromicPaths(root3));
	}

	public static int pseudoPalindromicPaths (TreeNode root) {
		Map<Integer, Integer> count = new HashMap<>();
		visit(count, root.val);
		return pseudoPalindromicPaths(root, count);
	}

	private static int pseudoPalindromicPaths(TreeNode root, Map<Integer, Integer> count) {
		int result = 0;

		// 왼쪽 노드가 있으면 방문
		if (root.left != null) {
			visit(count, root.left.val);
			result += pseudoPalindromicPaths(root.left, count);
			unVisit(count, root.left.val);
		}

		// 오른쪽 노드 있으면 방문
		if (root.right != null) {
			visit(count, root.right.val);
			result += pseudoPalindromicPaths(root.right, count);
			unVisit(count, root.right.val);
		}

		// 존재하지 않는 다면 지금까지 방문된 노드들이 palindrome 가능한지 확인
		if (root.left == null && root.right == null) {
			if (checkPalindrome(count)) {
				return 1;
			}
		}

		return result;
	}

	private static void visit(Map<Integer, Integer> count, int val) {
		if (count.containsKey(val)) {
			count.computeIfPresent(val, (k, v) -> v + 1);
		} else {
			count.put(val, 1);
		}
	}

	private static void unVisit(Map<Integer, Integer> count, int val) {
		if (count.get(val) == 1) {
			count.remove(val);
		} else {
			count.computeIfPresent(val, (k, v) -> v - 1);
		}
	}

	private static boolean checkPalindrome(Map<Integer, Integer> count) {
		Integer totalNodeCount = count.values().stream().reduce(0, Integer::sum);
		Predicate<Integer> isEvenCount = v -> v % 2 == 0;
		if (totalNodeCount % 2 == 0) {
			return count.values().stream().allMatch(isEvenCount);
		} else {
			return count.values().stream().filter(Predicate.not(isEvenCount)).count() == 1;
		}
	}
}
