### encryptor

  Example encryptor  string for security by java . 
  you can applied algorithm for your product form my code.
  
  
 #### GenerateKey
  
* set salt & password key for create SecretKeySpec
* length = 128
* algorithm = AES
  
```  
    public SecretKeySpec generateKey(String key,String pass,int iterationCount,int length) throws Exception {
              SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
              char[] password = pass.toCharArray();
              byte[] salt =key.getBytes("UTF-8");
      
              KeySpec spec = new PBEKeySpec(password, salt, iterationCount, length);
              SecretKey tmp = factory.generateSecret(spec);
              byte[] encoded = tmp.getEncoded();
              return new SecretKeySpec(encoded, "AES");
      }
```  


``` 
    private Cipher getCipher(int mode) throws Exception {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding", new SunJCE());
            //a random Init. Vector. just for testing
            byte[] iv = "e675f725e675f725".getBytes("UTF-8");
    
            c.init(mode, generateKey(), new IvParameterSpec(iv));
            return c;
    }
       
    
    public  String Encrypt(String raw) throws Exception {
            Cipher c = getCipher(Cipher.ENCRYPT_MODE);
            byte[] encryptedVal = c.doFinal(raw.getBytes("UTF-8"));
            return new BASE64Encoder().encode(encryptedVal);
        }
    
    public  String Decrypt(String encrypted) throws Exception {
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encrypted);
        Cipher c = getCipher(Cipher.DECRYPT_MODE);
        byte[] decValue = c.doFinal(decodedValue);
        return new String(decValue);
    }

``` 
    