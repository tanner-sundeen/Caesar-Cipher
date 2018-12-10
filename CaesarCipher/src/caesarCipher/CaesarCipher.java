package caesarCipher;

import java.util.Scanner;

public class CaesarCipher {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int shiftk = 11; //preset shift key
		int i;
		String pstr; //plaintext entered by user
		String estr = ""; //text after encryption
		String dstr = ""; //encrypted text decrypted again
		
		//user enters plaintext
		System.out.println("Enter plaintext here:");
		pstr = input.nextLine();
		pstr = pstr.toLowerCase(); //all capital letters become lowercase
		
		char ch1[] = pstr.toCharArray(); //represents each character in pstr
		char ch3,ch4; //represents each character in text after encryption and decryption, respectively
		System.out.println("Plaintext encrypted:");
		
		//encrypter runs until there are no characters remaining
		for(i=0;i<pstr.length();i++) {
			//changes character by shift key if it is a letter
			if(Character.isLetter(ch1[i])) {
				ch3 = (char)(((int)ch1[i]+shiftk-97)%26+97); //En(x) = (x+n) mod 26, alphabet begins at 97
				estr=estr+ch3;
			}
			//leaves a space if the character is already a space
			else if(ch1[i] == ' ') {
				estr=estr+ch1[i];
			}
		}
		System.out.println(estr);
		
		char ch2[] = estr.toCharArray(); //represents each character in estr
		
		System.out.println("Encrypted text decrypted:");
		//decryption is similar to encryption, but subtracts by the shift key
		for(i=0;i<estr.length();i++) {
			//two different equations to prevent character from leaving alphabet
			if(Character.isLetter(ch2[i])) {
				if(((int)ch2[i]-shiftk)<97) {
					ch4 = (char)(((int)ch2[i]-shiftk-97+26)%26+97);
				}
				else {
					ch4 = (char)(((int)ch2[i]-shiftk-97)%26+97);
				}
				dstr=dstr+ch4;
			}
			else if(ch2[i] == ' ') {
				dstr=dstr+ch2[i];
			}
		}
		System.out.println(dstr);
	}
	
}
