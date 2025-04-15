public class CreditCardValidator {
    public static void main(String[] args) {
        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";

        String[] cards = {"4123456789012345", "5123456789012345", "6123456789012345"};

        for (String card : cards) {
            boolean isVisa = card.matches(visaRegex);
            boolean isMaster = card.matches(masterRegex);
            System.out.println(card + " → Visa: " + isVisa + ", MasterCard: " + isMaster);
        }
    }
}