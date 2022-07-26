package GuhaJavaAPI;

@SuppressWarnings("unused")
public class Tests extends Guha {
  /* GUHA API TEST METHODS */

  // Constructor:
  public Tests() {
    super();
  }

  // Test Full API Method:
  public static boolean testFullAPI(String initialData, int times) throws Exception {
    // Performs the API Test:
    double key = generateKey();
    String data = encrypt(key, initialData, times);

    // Checks the Case:
    if (decrypt(key, data, times).equals(initialData)) {
      // Returns Truth Value:
      return true;
    }

    else {
      // Returns Truth Value:
      return false;
    }
  }

  // Encryption Test Method:
  public static String testEncryption(String data, int times) throws Exception {
    // Tests the Encryption:
    return encrypt(generateKey(), data, times);
  }

  // Decryption Test Method:
  public static boolean testDecryption(String initialData, String data, double key, int times) throws Exception {
    // Tests the Decryption:
    if (initialData.equals(decrypt(key, initialData, times))) {
      // Returns the Truth Value:
      return true;
    }

    else {
      // Returns the Truth Value:
      return false;
    }
  }
}
