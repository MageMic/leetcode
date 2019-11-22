package string;

public class ReverseSentence_nk {

    public String reverseSentence(String A, int n) {
        // write code here
        String[] arr = A.split(" ");
        int start = 0, end = arr.length - 1;
        while (start < end) {
            String temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
