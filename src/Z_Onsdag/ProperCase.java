package Z_Onsdag;

public class ProperCase {
    static String tagImod(String string){
        String[] strings = string.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : strings){
            if (word.equals(word.toUpperCase())){
                result.append(word);
            } else if (word.length()>3) {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase());

                
            }else {
                result.append(word.toLowerCase());
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(tagImod("BO efter JEFF"));
    }
}
