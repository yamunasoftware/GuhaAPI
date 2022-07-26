package GuhaJavaAPI;

@SuppressWarnings("unused")
public class Guha {
  /* ENCRYPTION ALGORITHM VARIABLES */

  // Possible Values Array:
  private static String[] possibleValues = {
    "A", "B", "C", "D", "E",
    "F", "G", "H", "I", "J",
    "K", "L", "M", "N", "O",
    "P", "Q", "R", "S", "T",
    "U", "V", "W", "X", "Y",
    "Z",

    "a", "b", "c", "d", "e",
    "f", "g", "h", "i", "j",
    "k", "l", "m", "n", "o",
    "p", "q", "r", "s", "t",
    "u", "v", "w", "x", "y",
    "z",

    "0", "1", "2", "3", "4",
    "5", "6", "7", "8", "9",

    "!", "@", "#", "$", "%",
    "^", "&", "*", "(", ")",
    "<", ">", "?", "/", "'",
    ":", ";", "[", "]", "{",
    "}", "|", " "
  };

  /* ENCRYPTION ALGORITHM METHODS */

  // Key Generation Method:
  public static double generateKey() throws Exception {
    // Returns the Key:
    return ((Math.random() * 0.9) + 0.1);
  }

  // Encryption Method:
  public static String encrypt(double key, String input, int times) throws Exception {
    // Loop Variables:
    String outputString = input;
    String holderString = "";
    int turns = 0;

    // Loops through Times:
    mainLoop: while (turns < times) {
      // Gets the Output:
      holderString = encryptionOperation(key, outputString);
      outputString = holderString;

      turns++;
    }

    // Returns the Output:
    return outputString;
  }

  // Decryption Method:
  public static String decrypt(double key, String input, int times) throws Exception {
    // Loop Variables:
    String outputString = input;
    String holderString = "";
    int turns = 0;

    // Loops through Times:
    mainLoop: while (turns < times) {
      // Gets the Output:
      holderString = decryptionOperation(key, outputString);
      outputString = holderString;

      turns++;
    }

    // Returns the Output:
    return outputString;
  }

  // Encryption Operation Method:
  private static String encryptionOperation(double key, String input) throws Exception {
    // Loop Variables:
    char outputArray[] = input.toCharArray();
    int index = (int)(key * outputArray.length);
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < outputArray.length) {
      // Swaps the Values:
      char value = outputArray[turns];
      outputArray[turns] = outputArray[index];
      outputArray[index] = value;
      
      turns++;
    }

    // Returns the String:
    return hashData(key, String.valueOf(outputArray));
  }

  // Encryption Operation Method:
  private static String decryptionOperation(double key, String input) throws Exception {
    // Loop Variables:
    String newInput = rehashData(key, input);
    char outputArray[] = newInput.toCharArray();
    int index = (int)(key * outputArray.length);
    int turns = outputArray.length - 1;

    // Loops through Array:
    mainLoop: while (turns >= 0) {
      // Swaps the Values:
      char value = outputArray[index];
      outputArray[index] = outputArray[turns];
      outputArray[turns] = value;
      
      turns--;
    }

    // Returns the String:
    return String.valueOf(outputArray);
  }

  // Hash Data Method:
  private static String hashData(double key, String data) throws Exception {
    // Loop Variables:
    String hashedData = "";
    int turns = 0;

    // Loops through String:
    mainLoop: while (turns < data.length()) {
      // Checks the Case:
      if (checkInputValues(Character.toString(data.charAt(turns))) != -1) {
        // Gets the Data Indexes:
        int dataIndex = checkInputValues(Character.toString(data.charAt(turns)));
        int keyTurns = (int)(key * possibleValues.length);
        int newIndex = dataIndex + keyTurns;

        // Checks the Case:
        if (newIndex >= possibleValues.length) {
          // Sets the New Index:
          newIndex -= possibleValues.length;
        }

        // Sets the New Value:
        hashedData += possibleValues[newIndex];
      }

      else {
        // Adds the Data:
        hashedData += data.charAt(turns);
      }

      turns++;
    }

    // Returns the Hashed Data:
    return hashedData;
  }

  // Rehash Data Method:
  private static String rehashData(double key, String data) throws Exception {
    // Loop Variables:
    String rehashedData = "";
    int turns = 0;

    // Loops through String:
    mainLoop: while (turns < data.length()) {
      // Checks the Case:
      if (checkInputValues(Character.toString(data.charAt(turns))) != -1) {
        // Gets the Data Indexes:
        int dataIndex = checkInputValues(Character.toString(data.charAt(turns)));
        int keyTurns = (int)(key * possibleValues.length);
        int newIndex = dataIndex - keyTurns;

        // Checks the Case:
        if (newIndex < 0) {
          // Sets the New Index:
          newIndex += possibleValues.length;
        }

        // Sets the New Value:
        rehashedData += possibleValues[newIndex];
      }

      else {
        // Adds the Data:
        rehashedData += data.charAt(turns);
      }

      turns++;
    }

    // Returns the Rehashed Data:
    return rehashedData;
  }

  // Check Input Values Method:
  private static int checkInputValues(String input) throws Exception {
    // Loop Variables:
    int index = -1;
    int turns = 0;

    // Loops through Array:
    mainLoop: while (turns < possibleValues.length) {
      // Checks the Case:
      if (input.equals(possibleValues[turns])) {
        // Sets the Index:
        index = turns;
        break mainLoop;
      }

      turns++;
    }

    // Returns the Index:
    return index;
  }
}