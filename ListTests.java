package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ListTests {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
		ListNode temp = new ListNode(0);
        ListNode tempHead = temp;
        
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
                System.out.println(l1.val);
				temp.next = l1;
				l1 = l1.next;
			} else {
                System.out.println(l2.val);
				temp.next = l2;
				l2 = l2.next;	
			}
            temp = temp.next;
		}
		if (l1 != null) {
			temp.next = l1;
		} else if (l2 != null) {
			temp.next = l2;
		}
		return tempHead.next;
	}
	   public int[][] reconstructQueue(int[][] people) {
	        Arrays.sort(people,new Comparator<int[]>(){
	           @Override
	           public int compare(int[] o1, int[] o2){
	               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
	           }
	        });
	        /*
	        Arrays.sort(people, new Comparator<int[]>() {
	            @Override
	            public int compare(int left[], int right[]) {
	                return (left[0] - right[0]);
	            }
	        });*/
	        ArrayList<int[]> res = new ArrayList<int[]>();
	        for (int[] p: people) {
	            if (p[1] >= res.size())
	                res.add(p);
	            else
	                res.add(p[1], p);
	        }
	        return res.toArray(new int[people.length][]);
	    }
	   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		    //boundary check
		    if(headA == null || headB == null) return null;
		    
		    ListNode a = headA;
		    ListNode b = headB;
		    
		    
		    //if a & b have different len, then we will stop the loop after second iteration
		    while( a != b){
		    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
		    	//
		        // If one of them reaches the end earlier then reuse it 
		        // by moving it to the beginning of other list.
		        // Once both of them go through reassigning, 
		        // they will be equidistant from the collision point.
		        //
		        a = a == null? headB : a.next;
		        b = b == null? headA : b.next;    
		    }
		    
		    return a;
		}
}
