package test;
import java.util.ArrayList;
import java.util.List;

class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbbbb"));
		System.out.println(lengthOfLongestSubstring("ohomm"));
		System.out.println(lengthOfLongestSubstring("aabaab!bb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int maximum = 0;
		List<Character> chars = new ArrayList<>();
		
		for (int i=0; i<s.length(); i++) {
			char findMe = s.charAt(i);
			if (chars.contains(findMe)) {
				
				maximum = chars.size() > maximum ? chars.size() : maximum;
				chars.add(s.charAt(i));
				
				int found = chars.indexOf(findMe);
				
				if (found < chars.size() - 1)
					chars = chars.subList(chars.indexOf(findMe) + 1, chars.size());
				else 
					chars = new ArrayList<>();

			} else {
				chars.add(s.charAt(i));				
			}
			System.out.println(chars.toString());
			
		}
		maximum = chars.size() > maximum ? chars.size() : maximum;
		return maximum;
	}

}