export class Guha {
  /* ENCRYPTION ALGORITHM VARIABLES */

  //Possible Values Array:
  private static possibleValues: string[] = [
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
  ];

  /* ENCRYPTION ALGORITHM METHODS */

  //Key Generation Method:
  public static generateKey() {
    //Returns the Key:
    return ((Math.random() * 0.9) + 0.1);
  }

  //Encryption Method:
  public static encrypt(key: number, input: string, times: number) {
    //Loop Variables:
    var outputString: string = input;
    var holderString: string = "";
    var turns: number = 0;

    //Loops through Times:
    mainLoop: while (turns < times) {
      //Gets the Output:
      holderString = this.encryptionOperation(key, outputString);
      outputString = holderString;

      turns++;
    }

    //Returns the Output:
    return outputString;
  }

  //Decryption Method:
  public static decrypt(key: number, input: string, times: number) {
    //Loop Variables:
    var outputString: string = input;
    var holderString: string = "";
    var turns: number = 0;

    //Loops through Times:
    mainLoop: while (turns < times) {
      //Gets the Output:
      holderString = this.decryptionOperation(key, outputString);
      outputString = holderString;

      turns++;
    }

    //Returns the Output:
    return outputString;
  }

  //Encryption Operation Method:
  private static encryptionOperation(key: number, input: string) {
    //Loop Variables:
    var outputArray: string[] = [...input];
    var index: number = Math.floor(key * outputArray.length);
    var turns: number = 0;

    //Loops through Array:
    mainLoop: while (turns < outputArray.length) {
      //Swaps the Values:
      var value: string = outputArray[turns];
      outputArray[turns] = outputArray[index];
      outputArray[index] = value;

      turns++;
    }

    //Returns the String:
    return this.hashData(key, outputArray.join());
  }

  //Encryption Operation Method:
  private static decryptionOperation(key: number, input: string) {
    //Loop Variables:
    var newInput: string = this.rehashData(key, input);
    var outputArray: string[] = [...newInput];
    var index: number = Math.floor(key * outputArray.length);
    var turns: number = outputArray.length - 1;

    //Loops through Array:
    mainLoop: while (turns >= 0) {
      //Swaps the Values:
      var value: string = outputArray[index];
      outputArray[index] = outputArray[turns];
      outputArray[turns] = value;

      turns--;
    }

    //Returns the String:
    return outputArray.join();
  }

  //Hash Data Method:
  private static hashData(key: number, data: string) {
    //Loop Variables:
    var hashedData: string = "";
    var turns: number = 0;

    //Loops through String:
    mainLoop: while (turns < data.length) {
      //Checks the Case:
      if (this.checkInputValues(data[turns]) != -1) {
        //Gets the Data Indexes:
        var dataIndex: number = this.checkInputValues(data[turns]);
        var keyTurns: number = Math.floor(key * this.possibleValues.length);
        var newIndex: number = dataIndex + keyTurns;

        //Checks the Case:
        if (newIndex >= this.possibleValues.length) {
          //Sets the New Index:
          newIndex -= this.possibleValues.length;
        }

        //Sets the New Value:
        hashedData += this.possibleValues[newIndex];
      }

      else {
        //Adds the Data:
        hashedData += data.charAt(turns);
      }

      turns++;
    }

    //Returns the Hashed Data:
    return hashedData;
  }

  //Rehash Data Method:
  private static rehashData(key: number, data: string) {
    //Loop Variables:
    var rehashedData: string = "";
    var turns: number = 0;

    //Loops through String:
    mainLoop: while (turns < data.length) {
      //Checks the Case:
      if (this.checkInputValues(data[turns]) != -1) {
        // Gets the Data Indexes:
        var dataIndex: number = this.checkInputValues(data[turns]);
        var keyTurns: number = Math.floor(key * this.possibleValues.length);
        var newIndex: number = dataIndex - keyTurns;

        //Checks the Case:
        if (newIndex < 0) {
          //Sets the New Index:
          newIndex += this.possibleValues.length;
        }

        //Sets the New Value:
        rehashedData += this.possibleValues[newIndex];
      }

      else {
        //Adds the Data:
        rehashedData += data.charAt(turns);
      }

      turns++;
    }

    //Returns the Rehashed Data:
    return rehashedData;
  }

  //Check Input Values Method:
  private static checkInputValues(input: string) {
    //Loop Variables:
    var index: number = -1;
    var turns: number = 0;

    //Loops through Array:
    mainLoop: while (turns < this.possibleValues.length) {
      //Checks the Case:
      if (input == this.possibleValues[turns]) {
        //Sets the Index:
        index = turns;
        break mainLoop;
      }

      turns++;
    }

    //Returns the Index:
    return index;
  }
}