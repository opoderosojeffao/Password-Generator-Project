import java.math.*;

public class Password {

	// Setting up all variables for the constructor
	
	String letters, uppercase, numbers, specialChar;

	boolean options, wNumbers, wSpecial;
	
	int passLength;
	
	// Constructor initializing the variables
	public Password(boolean wNumbers, boolean wSpecial, int passLength) {
	
		this.letters = "abcdefghijklmnopqrstuvwxyz";
		this.uppercase = this.letters.toUpperCase();
		this.numbers = "0123456789";
		this.specialChar = "!@#$%^&?";
		
		this.wNumbers = wNumbers;
		this.wSpecial = wSpecial;
		
		this.passLength = passLength;
	}
	
	// Transform a string into an array
	char[] makeArray(String str) {
		
		char[] array = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			array[i] = str.charAt(i);
		}
		
		return array;
	}
	
	// Transform a array into an string
	String makeString(char[] arr) {
		
		String string = String.valueOf(arr);
		
		return string;
	}
	
	
	// Method generating the password, however, it can change based on the user
	// if they want a password with numbers, special characters, or both
	// and returning the password result
	public String GenPassword() {
		
		char[] password = new char[this.passLength];
		

			if (this.wNumbers && !this.wSpecial) {
				for (int i = 0; i < this.passLength; i++) {
					int rand = (int)(Math.random()*(this.letters.length()+this.uppercase.length()+this.numbers.length()));
					password[i] = makeArray(this.letters+this.uppercase+this.numbers)[rand];
				}
			}else if(this.wSpecial && !this.wNumbers) {
				for (int i = 0; i < this.passLength; i++) {
					int rand = (int)(Math.random()*(this.letters.length()+this.uppercase.length()+this.specialChar.length()));
					password[i] = makeArray(this.letters+this.uppercase+this.specialChar)[rand];
					
				}
			}else if(this.wNumbers && this.wSpecial) {
				for (int i = 0; i < this.passLength; i++) {
					int rand = (int)(Math.random()*(this.letters.length()+this.uppercase.length()+this.numbers.length()+this.specialChar.length()));
					password[i] = makeArray(this.letters+this.uppercase+this.specialChar+this.numbers)[rand];		
				}
			} else {
				for (int i = 0; i < this.passLength; i++) {
					int rand = (int)(Math.random()*(this.letters.length()+this.uppercase.length()));
					password[i] = makeArray(this.letters+this.uppercase)[rand];
			}	
		}
		
		return makeString(password);
	}
}
