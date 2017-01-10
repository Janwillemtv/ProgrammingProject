package ss.week6.dictionaryattack;

import org.apache.commons.codec.binary.Hex;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.security.MessageDigest;



public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public DictionaryAttack() {
		passwordMap = new HashMap<>();
		hashDictionary = new HashMap<>();
	}
	public void readPasswords(String filename) throws IOException {
        System.out.println("Test2");
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                String[] split = line.split(":\\s+");

                if (split.length == 2) {
                    String username = split[0];
                    System.out.println(username);
                    passwordMap.put(username, split[1]);
                }
            }
        }
        catch (IOException ex) {
            throw ex;
        }
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
    		// To implement
			String hash = null;

			try {
				MessageDigest digester = MessageDigest.getInstance("MD5");
				byte[] all = digester.digest(password.getBytes());

				hash = Hex.encodeHexString(all);
				//System.out.println(hash);

			}  catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		return hash;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */

	public boolean checkPassword(String user, String password) {
        // To implement
		if (!passwordMap.containsKey(user)) {
			return false;
		}
		String hash = getPasswordHash(password);
		return (passwordMap.get(user).equals(hash));
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename) throws IOException {
            // To implement
            try {
                BufferedReader in = new BufferedReader(new FileReader(filename));

                String word;
                while ((word = in.readLine()) != null) {
                    String hash = getPasswordHash(word);
                   // System.out.println(word);
                    hashDictionary.put(hash, word);
                }
            } catch (IOException e) {
                throw e;
            }
        }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		// To implement
        int i =0;
       // System.out.println("test");
		for (Map.Entry<String, String>entry : passwordMap.entrySet()) {
			String user = entry.getKey();
			//System.out.println("here now");
			String passwordHash = entry.getValue();
			System.out.println("");
			i++;

			if (hashDictionary.containsKey(passwordHash)) {
				System.out.println("User: " + user + " Password: " + hashDictionary.get(passwordHash));
			}
		}
		System.out.println(i);
	}
	public static void main(String[] args) throws IOException {
		String PATH = "C:/softwaresystems/ProgrammingProject/softwaresystems/src/ss/week6/dictionaryattack/";


		DictionaryAttack da = new DictionaryAttack();
		// To implement
		try {
		da.addToHashDictionary(PATH + "Dictionary.txt");
		da.addToHashDictionary(PATH + "Passwords.txt");
		//System.out.println("Test this");
		} catch (IOException e) {
			System.out.println(e);
		}
		da.readPasswords(PATH + "Passwords.txt");
		da.doDictionaryAttack();
	}

}
