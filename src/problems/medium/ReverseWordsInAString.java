package problems.medium;

public class ReverseWordsInAString {

    public String reverseWords(String s) {

        if(s == null) return null;

        StringBuilder builder = new StringBuilder();
        String[] arr = s.split(" ");

        for(int i=arr.length-1 ; i>=0 ; i--) {
            if(!arr[i].isEmpty())
                builder.append(arr[i] + " ");
        }

        return builder.toString().trim();
    }
}
