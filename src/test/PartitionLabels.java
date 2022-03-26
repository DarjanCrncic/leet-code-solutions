package test;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partitionLabels("ababcbacadefegdehijhklij").toString());
	}

	public static List<Integer> partitionLabels(String s) {
        List<Integer> output = new ArrayList<>();
        char[] ch = s.toCharArray();
        int front = 0, backStop, back = 0, frontStop = 0;
        backStop = s.lastIndexOf(s.charAt(front));
        
        while(back > -1) {
        	back = lastIndexOf(ch, ch[front]);
        	if (back > backStop) {
        		backStop = back;
        	}
        	
            if (backStop == front) {
            	output.add(backStop-frontStop+1);
            	
            	if (backStop == s.length()-1) break;
            	
            	frontStop = backStop+1;
            	back = lastIndexOf(ch, ch[frontStop]);
            }
            
            front++;
        }
        
        return output;
    }
	
	public static int lastIndexOf(char[] ch, char x) {
		int retval = -1;
		int flag = ch.length-1;
		while(flag >= 0) {
			if (ch[flag] == x) {
				retval = flag;
				break;
			}
			flag--;
		}
		return retval;
	}
}
