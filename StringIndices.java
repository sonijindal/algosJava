package practice;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringIndices {

	/* Find the list of indices of a word in a string */
	public static ArrayList<Integer> getIndices(String str, String match) {
		String []substr = str.split(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(substr.length);
		Arrays.sort(substr);
		System.out.println(substr);
		int i = 0;
		for (String s: substr) {
			System.out.println(s);
			if (s.equals(match)) {
				list.add(i);
			}
			i = i + s.length() + 1;
		}
		return list;
	}
	/* find an efficient algorithm to find the least distance(measured in number of words) between any two given words.*/
	public static int findDistance(String filename, String str1, String str2) {
		String line = null;
		boolean first = false;
		int distance = 0;
		boolean second = false;
		boolean found = false;
		try {
			FileReader fileReader = 
					new FileReader(filename);
			BufferedReader bf =
					new BufferedReader(fileReader);
			while((line = bf.readLine()) != null) {
				String substr[] = line.split("\\P{L}+");
                //	System.out.println(line);
                	for (String s: substr) {
            			System.out.println(s);
            			if (s.equals(str1) && !first) {
            				first = true;
            			}
            			if (s.equals(str2) && !second) {
            				second = true;
            			}
            			// Only one is found, so keep increasing distance
            			if (first != second ) {
            				distance++;
            			} else if (first == true){
            				//Found both
            				System.out.println(distance);
            				found = true;
            				break;
            			}
                	}
                	if (found == true)
                		break;
            } 
			bf.close(); 	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static String commonPrefix(String[] strings) {
		int num = strings.length;
		 if (num < 1) {
	            return "";
	        }
		String prefix = strings[0];
		
		for (int i = 1; i < num; ++i) {
			StringBuilder sb = new StringBuilder();
			int len1 = prefix.length();
			int len2 = strings[i].length();
			int len = len1 > len2 ? len2: len1;
			for (int j = 0; j < len; ++j) {
				if (prefix.charAt(j) != strings[i].charAt(j)) {
					break;
				} else {
					sb.append(prefix.charAt(j));
				}
			}
			prefix = sb.toString();
		}
		return prefix;
	}
	public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        System.out.println(haystack.length()+":"+needle.length());
        	for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = 0;
				for (; j < needle.length(); ++j) {
					if (haystack.charAt(i+j) != needle.charAt(j))
						break;
				}
				if (j == needle.length()) {
					System.out.println("Found substring at "+i);
					return i;
				}
			}
		}
		return -1;
	}
	  public static int lengthOfLastWord(String s) {
		  String[] strs = s.split(" ");
		  int num = strs.length;
		  if (num == 0)
			  return 0;
		  return strs[num-1].length();
	    }
	    public String complexNumberMultiply(String num1, String num2) {
	        int num1a = 0, num1b = 0, num2a = 0, num2b = 0;
	        int resa = 0, resb = 0;
	        System.out.println(num1);
	        System.out.println(num2);
	        if (num1.length() >=4) {
	        String[] str = num1.split("\\+");
	        num1a = Integer.parseInt(str[0]);
	        String substr = str[1].substring(0,str[1].length() - 1);
	          
	        num1b = Integer.parseInt(substr);
	        }
	        if (num2.length() >= 4) {
	        String[] str = num2.split("\\+");
	        num2a = Integer.parseInt(str[0]);
	        String substr = str[1].substring(0,str[1].length() - 1);
	        num2b = Integer.parseInt(substr);
	        }
	        /* (x + yi)(a + bi) = xa - yb + (xb + ya)i */
	        resa = num1a * num2a - num1b * num2b;
	        resb = num1a * num2b + num2a * num1b;
	        StringBuilder sb = new StringBuilder();
	        sb.append(Integer.toString(resa));
	        sb.append("+");
	        sb.append(Integer.toString(resb));
	        sb.append("i");
	        return sb.toString();
	    }
	    public String convertToTitle(int n) {
	        StringBuilder sb = new StringBuilder();
	        while (n > 0) {
	            n--;

	            char ch = (char)('A' + n%26);
	            n = n / 26;
	            sb.insert(0,ch);
	        }
	        return sb.toString();
	    }
	    public boolean isPalindrome(String s) {
	        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
	        String rev = new StringBuffer(actual).reverse().toString();
	        return actual.equals(rev);
	    }
	    public boolean isPalindrome_1(String s) {
	    	 
	        int len = s.length();
	        s = s.toLowerCase();
	        System.out.println(s);
	        int i, j;
	        for (i = 0, j = len -1; i < j; ++i, --j) {
	            while (Character.isLetterOrDigit(s.charAt(i)) != true && i < j)
	                i++;
	            while (Character.isLetterOrDigit(s.charAt(j)) != true && i < j)
	                j--;
	            if (i < j && s.charAt(i) != s.charAt(j))
	                break;
	        }
	        if (i >= j)
	            return true;
	        return false;
	    }
	    public int repeatedStringMatch(String A, String B) {

	        int count = 0;
	        StringBuilder sb = new StringBuilder();
	        while (sb.length() < B.length()) {
	            sb.append(A);
	            count++;
	        }
	        if(sb.toString().contains(B)) return count;
	        if(sb.append(A).toString().contains(B)) return ++count;
	        return -1;
	    }
	    public static boolean validPalindrome(String s) {
	    		int i = 0;
	    		int j = s.length() - 1;
	    		int count = 0;
	    		while (i <= j && count == 0) {
	    			if (s.charAt(i) == s.charAt(j)) {
	    				++i;
	    				--j;
	    				continue;
	    			} else if (i == j) {
	    				break;
	    			} else {
	    				 count++;
	    				// i++;
	    			}
	    		}
	    		System.out.println(i+" "+j+" "+ count);
	        return (i == j) || (i == j-1);
	    }
	    public static void findReplace(String s, String search, String replace) {
	    		StringBuilder sb = new StringBuilder();
	    		int start = 0;
	    		for (int i = 0; i < s.length() - search.length(); ++i) {
	    			String sub = s.substring(i, search.length());
	    			if (search.equals(sub)) {
	    				String strLeft = s.substring(start, i);
	    				sb.append(strLeft);
	    				sb.append(replace);
	    				start = i + replace.length();
	    				i = i + search.length();
	    			}
	    		}
	    }
	public static void main (String[] args)
	{
		IntTests.testStruct();
		/*System.out.println(IntTests.reduceInt(458762));
		*/
		/*double b = 2.9;
		int i = (int)b;
		//if (b == (int)b)
			System.out.println(i);
		*/
		/*System.out.println(StringIndices.validPalindrome("abca"));
		*/
		/*String str = "Hello World";
		System.out.println(str.contains("orl"));
		*/
		/*System.out.println(IntTests.reverseBits(0x3));
		*/
		/*int arr[] = {2, 6, 4, 8, 10, 9, 15};
		System.out.println("size of unsorted sub array:"+ IntTests.findUnsortedSubarray(arr));
		*/
		/*StackTest st = new StackTest();
		st.push(10);
		st.push(100);
		st.push(200);
		st.push(150);
		st.push(1);
		int min = st.getMin();
		System.out.println("Minumum so far:"+ min);
		st.pop();
		st.pop();
		min = st.getMin();
		System.out.println("Minumum now:"+ min);
		*/
		/*int arr[] = {10, 20, 1, 3, 7, 6, 4, 34};
		SortTests.HeapSort(arr);
		for (int e: arr)
		System.out.println(e);
		*/
		/*GraphsTest g = new GraphsTest(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
        g.BFS(2);
        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");
        g.DFS(2);
        */
		/*int[] nums = {3, 1, 4, 1, 5};
		int k = 2;
		System.out.println(IntTests.findPairs(nums, k));/
		*
		/*int[] nums = {2, 3, 4, 5, 6, 2, 1, 3};
		ArrayList<Integer> list = IntTests.findDuplicates(nums);
		System.out.println(list);
		*/
		/*System.out.println("Length:"+lengthOfLastWord("Hello world"));
		 */
		/*strStr("Hello World", "World");
		 */
		/*int[] nums = {0, 0, 1, 1, 2, 3, 4, 5, 6, 6, 6, 6};
		int count = IntTests.removeDuplicates(nums);
		System.out.println(count);
		*/
		/*
		if (StackTest.isValid("[(({})}]") == true)
			System.out.println("Yes it is valid");
		else
			System.out.println("No, not a valid input!");
		*/
		/*String[] array = {"geek", "geeks", "gee", "geeksfo"}; 
		String prefix = commonPrefix(array);
		System.out.println(prefix);
		*/
		/*int num = IntTests.romanToInt("MCMIV");
		System.out.println("Integer:"+num);
		num = IntTests.romanToInt("III");
		System.out.println("Integer:"+num);*/
		
		/*IntTests.isPalindrome(12321);
		IntTests.isPalindrome(-2035);
		IntTests.isPalindrome(2035);
		IntTests.isPalindrome(1000237999);
		*/
		/*int num = IntTests.reverseDigits(100023799);
		System.out.println("Reversed:"+num);
		*/
		//matrixRotate();
		//TestMap.simpleMapTest();
		/*Object [] data = new String[20];
		data[0] = "Hello";
		data[1] = new Integer(0);
		
		char [] s_array = ((String)data[0]).toCharArray();
		*/
		/*
		String testStr = "This is my world which is beautiful!";
		ArrayList<Integer> list = StringIndices.getIndices(testStr, "is");
		System.out.println(list);
		*/
		/*
		String fileName = "./temp.txt";
		findDistance(fileName, "World", "days");
		*/
		/*
		String entry1 = "ABC 23.4";
		String substr[] = entry1.split(" ");
		HashMap<String, Double> hmap = new HashMap<String, Double>();
		hmap.put(substr[0], Double.parseDouble(substr[1]));
		String entry2 = "DEF 23.4";
		substr = entry2.split(" ");
		hmap.put(substr[0], Double.parseDouble(substr[1]));
		System.out.println(hmap.get("ABC") + hmap.get("DEF"));
		*/
	}
}
