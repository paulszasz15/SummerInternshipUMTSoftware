public class StringValidator {
    public static int isInputValid (String input) {
        int noOfChangesRequired = 0;
        int stringLength = input.length();

        /**
         * Verifies if the input length is between 6 and 20 characters
         * @noOfChangesRequired is incremented with the necessary number of changes
         */
        if (stringLength < 6)
            noOfChangesRequired += 6 - stringLength;
        else if (stringLength > 20)
            noOfChangesRequired += stringLength - 20;


        /**
         * Verifies if the input contains at least one lowercase character
         * @missingPatterns is decremented by one if case matches
         */
        int missingPatterns = 3;
        if (input.matches("^.*[a-z].*$"))
            missingPatterns--;
        /**
         * Verifies if the input contains at least one uppercase character
         * @missingPatterns is decremented by one if case matches
         */
        if (input.matches("^.*[A-Z].*$"))
            missingPatterns--;
        /**
         * Verifies if the input contains at least one digit
         * @missingPatterns is decremented by one if case matches
         */
        if (input.matches(".*[\\d].*$"))
            missingPatterns--;

        noOfChangesRequired += missingPatterns;

        int noOfRepeatedCharacters = 0;
        int index = 2;

        /**
         * Verifies if the input contains three of the same characters in a row
         * @noOfRepeatedCharacters is incremented by 1 if there are three same consecutive letters
         */
        while (index < stringLength) {
            if (input.charAt(index) == input.charAt(index - 1) && input.charAt(index - 1) == input.charAt(index - 2)) {
                int length = 2;
                while (index < stringLength && input.charAt(index) == input.charAt(index - 1)) {
                    length++;
                    index++;
                }
                noOfRepeatedCharacters += length / 3;
            } else {
                index++;
            }
        }

        noOfChangesRequired += Math.max(noOfRepeatedCharacters, 0);

        return noOfChangesRequired;
    }

    public static void main(String[] args) {
        String input1 = "Parola1";
        String input2 =  "asdaaasD";
        String input3 = "Carteee23@bbb";
        String input4 = "asd";
        String input5 = "?Carteee23dsfjsdoiufhuids??";
        String input6 = "FaraNumarFaraCNP#$8978";

        System.out.println("Number of minimum changes required for input1: " + isInputValid(input1));
        System.out.println("Number of minimum changes required for input2: " + isInputValid(input2));
        System.out.println("Number of minimum changes required for input3: " + isInputValid(input3));
        System.out.println("Number of minimum changes required for input4: " + isInputValid(input4));
        System.out.println("Number of minimum changes required for input5: " + isInputValid(input5));
        System.out.println("Number of minimum changes required for input6: " + isInputValid(input6));

    }
}
