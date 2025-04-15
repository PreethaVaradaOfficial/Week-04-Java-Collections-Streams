public class SpaceReplacer {
    public static void main(String[] args) {
        String input = "This    is   an  example     with    multiple spaces.";
        String result = input.replaceAll("\\s{2,}", " ");
        System.out.println(result);
    }
}