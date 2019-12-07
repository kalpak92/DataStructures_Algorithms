/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix.
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 * 
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * 
 * Example 2:
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * 
 * Example 3:
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * 
 * Example 4:
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * 
 * Example 5:
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * 
 * Example 6:
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 */

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        
        Set<String> skipList = new HashSet<>(Arrays.asList("..",".",""));
        
        System.out.println(Arrays.asList(path.split("/")));
        
        for (String i : path.split("/")) 
        {
            if (i.equals("..") && !stack.isEmpty()) 
                stack.pop();                            // go back a folder path
            else if (!skipList.contains(i))             // push into stack a valid folder name
                stack.push(i);
        }
        
        StringBuilder result = new StringBuilder();
        
        if(stack.size() == 0) 
            return "/";
        
        while(stack.size() != 0) 
            result.append("/").append(stack.pollLast());
            
        return result.toString();
    }
}