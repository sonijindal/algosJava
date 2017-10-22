package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntTests {
	public static int reverseDigits(int num) {
			int rev = 0;
			int digit = 0;
			int prev = 0;
			boolean negative = false;
			if (num < 0) {
				num = -num;
				negative = true;
			}
			while (num > 0) {
				digit = num % 10;
				rev = rev * 10 + digit;
				if (prev != (rev - digit)/10) {
					System.out.println("Overflow!!");
					return -1;
				}
				num = num/10;
				prev = rev;
			}
			if (negative) {
				rev = -rev;
			}
			return rev;
	}
	public static boolean isPalindrome(int num) {
		if (reverseDigits(num) == num) {
			System.out.println("Yes "+num+" is a palindrome");
			return true;
		}
		System.out.println("No, "+num+" is not a palindrome");
		return false;
	}
	
	 public static int value(char ch) {
	        switch (ch) {
	            case 'I':
	                return 1;
	            case 'V':
	                return 5;
	            case 'X':
	                return 10;
	            case 'L':
	                return 50;
	            case 'C':
	                return 100;
	            case 'D':
	                return 500;
	            case 'M':
	                return 1000;
	            default:
	                return 0;
	        }
	    }
	    public static int romanToInt(String s) {
	        int i = 0;
	        int ret = 0;
	        while (i < s.length()) {
	            int val = value(s.charAt(i));
	            if (i+1 < s.length()) {
	                int next_val = value(s.charAt(i+1));
	                if (next_val > val) {
	                    ret = ret + next_val - val;
	                    i++;
	                } else {
	                    ret = ret + val;
	                }
	            } else {
	                ret = ret + val;
	                i++;
	            }
	            i++;
	        }
	        return ret;
	    }
	    public static int removeDuplicates(int[] nums) {
	        int track = 0;
	        for (int i = 1; i < nums.length; ++i) {
	        		if (nums[i] != nums[track]) {
	        			track++;
	        			nums[track] = nums[i];
	        		}
	        }
	        return track + 1;
	    }
	    public static int removeElement(int[] nums, int val) {
	        int track = -1;
	        for (int i = 0; i < nums.length; ++i) {
	        		if (nums[i] != val) {
	        			track++;
	        			nums[track] = nums[i];
                        
	        		}
	        }
	        return track + 1; 
	    }
	    /* Given a sorted array and a target value, return the index if the target is found. 
	     * If not, return the index where it would be if it were inserted in order.*/
	    public static int searchInsert(int[] nums, int target) {
	        int i;
	        for (i = 0; i < nums.length; ++i) {
		    			if (target == nums[i])
		    				return i;
		    			else if (target < nums[i])
		    				return i;
		    		}
	        if (i == nums.length)
	            return i;
		    return 0;
	    }
	    
	    /* Count and say */
	    public String countAndSay(int n) {
	    		StringBuilder sb = new StringBuilder();
	    		for (int i = 1; i <= n; ++i) {
	    			sb.append(i);
	    		}
	    		return "";
	    }
	    /* Find the contiguous subarray within an array (containing at least one number) 
	     * which has the largest sum.
	     */
	    public static int maxSubArray(int[] nums) {
	    		if (nums.length == 0)
	    			return 0;
	    		int sum = nums[0];
	    		int cur_sum = nums[0];

	    		for (int i = 1; i < nums.length; ++i) {
	    			cur_sum = Math.max(nums[i], cur_sum+nums[i]);
	    			sum = Math.max(cur_sum, sum);
	    		}
	    		return sum;
	    }
	    /*Given an 2D board, count how many battleships are in it.
	     * The battleships are represented with 'X's, empty slots are represented with '.'s. 
	     */
	    public int countBattleships(char[][] board) {
	        int rows = board.length;
	        int columns = board[0].length;
	        int count = 0;
	        for (int i = 0; i < rows; ++i) {
	            for (int j = 0; j < columns; ++j) {
	               if (board[i][j] == '.')
	                   continue;
	                if (i > 0 && board[i-1][j] == 'X')
	                    continue;
	                if (j > 0 && board[i][j-1] == 'X')
	                    continue;
	                count++;
	            }
	        }
	        return count;
	    }
	    public static ArrayList<Integer> findDuplicates(int[] nums) {
	        ArrayList<Integer> elems = new ArrayList<Integer>();
	        ArrayList<Integer> elemsUniq = new ArrayList<Integer>();
	        for (int i = 0; i < nums.length; ++i) {
	            if (elemsUniq.contains(nums[i]) == true) {
	            		elems.add(nums[i]);
	            } else {
	            		elemsUniq.add(nums[i]);
	            }
	        }
	        return elems;
	    }
	    public void rotate(int[] nums, int k) {
	        int[] temp = new int[k];
	        for (int i = nums.length - k, j = 0; i < nums.length; ++i, ++j) {
	        		temp[j] = nums[i];
	        }
	        for (int i = nums.length -1; i >= nums.length - k; --i) {
	        		nums[i] = nums[i - k];
	        }
	        for (int i = 0; i < k; ++i) {
	        		nums[i] = temp[i];
	        }
	    }
	    public int countPrimes(int n) {
	        n = n -1;
	        if (n <= 1)
	            return 0;
	        if (n == 2)
	            return 1;
	        if (n == 3)
	            return 2;
	        int count = 2;
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        al.add(2);
	        al.add(3);
	        
	        for (int i = 4; i <= n; ++i) {
	            boolean prime = true;
	            for (int p: al) {
	                if (i%p == 0) {
	                    prime = false;
	                    break;
	                }
	            }
	            if (prime == true) {
	                al.add(i);
	            }
	        }
	 
	        return al.size();
	    }
	    public int thirdMax(int[] nums) {
	        int max, mid, small, count;
	        max = mid = small = Integer.MIN_VALUE;
	        count = 0;  //Count how many top elements have been found.

	        for( int x: nums) {
	            //Skip loop if max or mid elements are duplicate. The purpose is for avoiding right shift.
	            if( x == max || x == mid ) {
	                continue;
	            }

	            if (x > max) {
	                //right shift
	                small = mid;
	                mid = max;

	                max = x;
	                count++;
	            } else if( x > mid) {
	                //right shift
	                small = mid;

	                mid = x;
	                count++;
	            } else if ( x >= small) { //if small duplicated, that's find, there's no shift and need to increase count.
	                small = x;
	                count++;
	            }
	        }

	        //"count" is used for checking whether found top 3 maximum elements.
	        if( count >= 3) { 
	            return small;
	        } else {
	            return max;
	        }
	    }
	    public int mySqrt(int x) {
	        int i;
	        if (x == 1)
	            return 1;
	        for (i = 1; i <= x/i; ++i);
	        return i-1;
	    }
	    public static int findPairs(int[] nums, int k) {
	     	HashMap<Integer, Boolean> testMap = new HashMap<Integer, Boolean>();
	     	int count = 0;
	        for (int i = 0; i < nums.length; ++i) {
	            testMap.put(nums[i], true);
	        }
	        for (int i = 0; i < nums.length; ++i) {
	        		Boolean kv = testMap.get(nums[i]+k);
	        		if (kv == true)
	        			//== true)
	        			//|| testMap.get(nums[i] - k) == true)
	        			count++;
	        		testMap.put(nums[i], false);
	        }
	        return count;
	    }
	    public static int findUnsortedSubarray(int[] nums) {
	    		int i, j;
	    		for (i = 0, j = nums.length - 1; i < j;) {
	    			boolean change = false;
	    			if (nums[i] < nums[i+1]) {
	    				i++;
	    				change = true;
	    			}
	    			if (nums[j] > nums[j-1]) {
	    				j--;
	    				change = true;
	    			}
	    			if (change == false)
	    				break;
	    		}
	    		System.out.println(i+" "+j);
	    		return j - i+1;
	    }
	    public static int reverseBits(int n) {
	    	 int result= 0;
	        /* for(int i=0; i<32; i++)
	             result = (result<<1) + (n>>i &1);
	         
	         return result;	
	    	*/
	    		int rev = 0;
	    		for (int i = 0; i < 32; ++i) {
	    			rev = (rev << 1) | (n & 0x1);
	    			n = n >> 1;
	    		}
	        return rev;
	    }
	    public int findNthDigit(int n) {
			int len = 1;
			long count = 9;
			int start = 1;

			while (n > len * count) {
				n -= len * count;
				len += 1;
				count *= 10;
				start *= 10;
			}

			start += (n - 1) / len;
			String s = Integer.toString(start);
			return Character.getNumericValue(s.charAt((n - 1) % len));
		}
	    public boolean canPlaceFlowers(int[] flowerbed, int n) {
	        int count = 0;
	        for(int i = 0; i < flowerbed.length && count < n; i++) {
	            if(flowerbed[i] == 0) {
		     //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0. 
	               int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
	               int prev = (i == 0) ? 0 : flowerbed[i - 1];
	               if(next == 0 && prev == 0) {
	                   flowerbed[i] = 1;
	                   count++;
	               }
	            }
	        }
	        
	        return count == n;
	    }
	    public boolean judgeSquareSum(int c) {
	        for (long a = 0; a * a <= c; a++) {
	            double b = Math.sqrt(c - a * a);
	            if (b == (int) b)
	                return true;
	        }
	        return false;
	    }
	    /* Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.*/
	    /* O(n) init and O(1) time retrieval */
	    int[] nums;

	    public void NumArray(int[] nums) {
	        for(int i = 1; i < nums.length; i++)
	            nums[i] += nums[i - 1];
	        
	        this.nums = nums;
	    }

	    public int sumRange(int i, int j) {
	        if(i == 0)
	            return nums[j];
	        
	        return nums[j] - nums[i - 1];
	    }
	    public static int reduceInt(int num) {
	    		int res;
	    		
	    		String str = Integer.toString(num);
	    		int len = str.length();
	    		int arr[] = new int[len];
	    		for (int i = 0 ; i < len; ++i) {
	    			arr[i] = str.charAt(i) - '0';
	    		}
	    		for (int i = len - 1; i >= 0; --i) {
	    			// Two consecutive
	    			if (arr[i] == arr[i-1] - 1 || arr[i] - 1 == arr[i-1]) {
	    				// Remove the smaller number and copy the elements from i till len - 1 shift left
	    				int keepIndex = arr[i] > arr[i-1] ? i: i - 1;
	    				arr[i-1] = arr[keepIndex];
	    				int j;
	    				for (j = i; j < len - 1; ++j) {
	    					arr[j] = arr[j+1];
	    				}
	    				arr[j] = '\0';
	    				break;
	    			}
	    		}
	    		StringBuilder sb = new StringBuilder();
	    		for (int i = 0; i < len - 1; ++i)
	    			sb.append(arr[i]);
	    		res = Integer.parseInt(sb.toString());
	    		return res;
	    }
	    public static class basicStruct {
	    		int a;
	    		int b;
	    		public basicStruct(int arg1, int arg2) {
	    			a = arg1;
	    			b = arg2;
	    		}
	    }
	    
	    public static void testStruct() {
	    		basicStruct obj = new basicStruct(10, 12);
	    		System.out.println(obj.a +":"+obj.b);
	    }
}
