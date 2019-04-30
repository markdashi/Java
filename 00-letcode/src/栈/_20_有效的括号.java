package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 * 有效字符串需满足：

	左括号必须用相同类型的右括号闭合。
	左括号必须以正确的顺序闭合。
	注意空字符串可被认为是有效字符串。
 * 示例 1: 
	输入: "()"
	输出: true
	
	示例 2:
	输入: "()[]{}"
	输出: true
	
	示例 3:

	输入: "(]"
	输出: false
	
	示例 4:

	输入: "([)]"
	输出: false
	
	示例 5:

	输入: "{[]}"
	输出: true
	
	1.遇见左字符入栈
	2.遇见右字符
		如果栈为空，说明括号无效
		如果栈不为空，将栈顶出栈，与右字符匹配
	  如果左右字符不匹配，说明括号无效
	  如果左右字符匹配，继续扫描下一个字符
	 3.所有字符扫描完毕
	 	栈为空，说明括号有效
	 	栈不为空，说明括号无效
 * 
 * @author mark
 *
 */
public class _20_有效的括号 {
	/**
	 * [({})]
	 * @author mark
	 *
	 */
	private HashMap<Character, Character> map = new HashMap<>();
	
	public _20_有效的括号() {
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
	}
	
	public boolean isValid3(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0,length = s.length(); i < length; i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				stack.push(c);
			}else { // 右括号
				if (stack.isEmpty()) return false;
				if (c != map.get(stack.pop())) return false;
			}
		}
		return stack.isEmpty();
	}
	
	public boolean isValid(String s) {
        while (s.contains("{}")
        		|| s.contains("()")
        		|| s.contains("[]")
        		) {
			s = s.replace("{}", "");
			s = s.replace("()", "");
			s = s.replace("[]", "");
		}
        return s.isEmpty();
    }
	
	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0,length = s.length(); i < length; i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}else { // 右括号
				if (stack.isEmpty()) return false;
				char left = stack.pop();
				if (left == '(' && c != ')') return false;
				if (left == '{' && c != '}') return false;
				if (left == '[' && c != ']') return false;	
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		
	}
}
