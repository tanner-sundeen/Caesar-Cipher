package caesarCipher;

import java.util.Scanner;

public class CaesarCipher {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int shiftk = 11; //shift key
		int i;
		String pstr; //plaintext entered by user
		String estr = "";
		String dstr = "";
		
		System.out.println("Enter plaintext here:");
		pstr = input.nextLine();
		pstr = pstr.toLowerCase();
		
		char ch1[] = pstr.toCharArray();
		char ch3,ch4;
		System.out.println("Plaintext encrypted:");
		
		for(i=0;i<pstr.length();i++) {
			if(Character.isLetter(ch1[i])) {
				ch3 = (char)(((int)ch1[i]+shiftk-97)%26+97);
				estr=estr+ch3;
			}
			else if(ch1[i] == ' ') {
				estr=estr+ch1[i];
			}
		}
		System.out.println(estr);
		
		char ch2[] = estr.toCharArray();
		
		System.out.println("Encrypted text decrypted:");
		for(i=0;i<estr.length();i++) {
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
