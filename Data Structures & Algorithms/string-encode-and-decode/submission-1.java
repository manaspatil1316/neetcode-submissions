
public class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            encodedString.append(s.length()).append('#').append(s);
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        int i = 0;
        int n = str.length();
        
        while (i < n) {
            // Find the position of the delimiter '#'
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            
            // Parse the length of the string
            int length = Integer.parseInt(str.substring(i, j));
            
            // Extract the actual string using the parsed length
            int startIndex = j + 1;
            int endIndex = startIndex + length;
            decodedList.add(str.substring(startIndex, endIndex));
            
            // Move pointer i to the start of the next length prefix
            i = endIndex;
        }
        
        return decodedList;
    }
}