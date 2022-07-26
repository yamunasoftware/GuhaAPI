import { Guha } from "./guha";

/* GUHA API TEST FUNCTIONS */

//Test Full API Function:
export function testFullAPI(initialData: string, times: number) {
  //Performs the API Test:
  var key: number = Guha.generateKey();
  var data: string = Guha.encrypt(key, initialData, times);

  //Checks the Case:
  if (Guha.decrypt(key, data, times) == initialData) {
    //Returns the Truth Value:
    return true;
  }

  else {
    //Returns the Truth Value:
    return false;
  }
}

//Encryption Test Function:
export function testEncryption(data: string, times: number) {
  //Tests the Encryption:
  return Guha.encrypt(Guha.generateKey(), data, times);
}

//Decryption Test Function:
export function testDecryption(initialData: string, data: string, key: number, times: number) {
  //Tests the Decryption:
  if (initialData == Guha.decrypt(key, data, times)) {
    //Returns the Truth Value:
    return true;
  }

  else {
    //Returns the Truth Value:
    return false;
  }
}