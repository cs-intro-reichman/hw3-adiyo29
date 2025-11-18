/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
		System.out.println(isAnagram("adi", "Adt"));

		// Tests the preProcess function.
		System.out.println("testing preprocess:   " + preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "adi";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

		str1 = preProcess(str1);
		str2 = preProcess(str2);
		if (str1.length() != str2.length()) return false;
		int n = str1.length();
		for (int i = 0; i < n; i++){
			char letter = str2.charAt(i);
			if(str1.indexOf(letter) == -1) return false;
			else {
				int b = str1.indexOf(letter);
				String part1 = str1.substring(0, b); // the part of str1 until the common letter
				String part2 = str1.substring(b + 1); 
				str1 = part1 + part2;

			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		int n = str.length();
		String newStr = "";
		String abc = "abcdefghijklmnopqrstubwxys";
		for (int i =0; i < n; i++){
			char letter = str.charAt(i);
			if (abc.indexOf(letter) == -1) {}
			else newStr = newStr + letter;
		
	}
		return newStr;
	
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newStr = "";
		int n = str.length();
		for (int i = 0; i < n; i++){
			int randomNumber = (int) (Math.random() * (n - i));
			char letter = str.charAt(randomNumber);
			newStr = newStr + letter;
			String part1 = str.substring(0, randomNumber); // the part of str1 until the common letter	
			String part2 = str.substring(randomNumber + 1); 
				str = part1 + part2;

			}

		return newStr;
	}
}
