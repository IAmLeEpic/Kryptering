package Sprint4;

public class Crypt {
    public static void main(String[] args){
        String message = "Jonathan";
        String key = "Alexander";

        System.out.println(crypt(message, key));
    }

    public static String crypt(String m, String k){
        String result = "";

        while(k.length() < m.length()){
            k+=k;
        }

        for(int i = 0; i < m.length(); i++){
            result += (char)(m.charAt(i)^k.charAt(i));
        }
        return result;
    }
}
