package stack;

/*Consider this string representation for binary trees. Each node is of the form (lr), 
where l represents the left child and r represents the right child. If l is the character 0, then there 
is no left child. Similarly, if r is the character 0, then there is no right child. Otherwise, the child 
can be a node of the form (lr), and the representation continues recursively. 
For example: (00) is a tree that consists of one node. ((00)0) is a two-node tree in which the root has a 
left child, and the left child is a leaf. And ((00)(00)) is a three-node tree, with a root, a left and a 
right child. 

Write a function that takes as input such a string, and returns -1 if the string is malformed, and the 
depth of the tree if the string is well-formed. 

For instance: 
find_depth('(00)') -> 0 
find_depth('((00)0)') -> 1 
find_depth('((00)(00))') -> 1 
find_depth('((00)(0(00)))') -> 2 
find_depth('((00)(0(0(00))))') -> 3 
find_depth('x') -> -1 
find_depth('0') -> -1 
find_depth('()') -> -1 
find_depth('(0)') -> -1 
find_depth('(00)x') -> -1 
find_depth('(0p)') -> -1

debug depthTree.java() for getLength2()
http://wxx5433.github.io/find-depth.html
*/

import java.util.*;

public class depthTree {
	public static void main(String[] args) {
		String s = "((00))";
		System.out.println(getLength3(s));
	}
	//Time: O(n * depth)
	//Space: O(n)
	public static int getLength(String str) {
	    int depth = -1;
	    while (!str.equals("0")) {
	        String newStr = str.replace("(00)", "0");
	        System.out.println("newStr: " + newStr);
	        if (newStr.equals(str)) {
	            return -1;
	        }
	        str = newStr;
	        ++depth;
	    }
	    return depth;
	}
	
	public static int getLength3(String str) {
		if (str == null)
			return -1;
		if(str.length() < 4)
			return -1;
		if((str.charAt(0) != '(') || (str.charAt(str.length()-1) != ')'))
			return -1;
		int depth = -1;
		int zeroCnt = 0;
		Stack<Character>s1 = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				s1.push(c);
				if(s1.size() > depth)
					depth = s1.size();
				zeroCnt = 0;
			}
			else if(c == ')') {
				zeroCnt = 0;
				s1.pop();
			} else {
				if(c != '0')
					return -1;
				else {
					zeroCnt++;
					if(zeroCnt > 2)
						return -1;
				}
			}
		}
		if(s1.size() != 0)
			return -1;
		
		return depth;
	}
	
}
 