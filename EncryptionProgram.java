import java.util.*;

public class EncryptionProgram {

    // Initialize necessary variables
    private Scanner scanner; // Scanner for input
    private Random random; // Random number generator
    private ArrayList<Character> list; // List of characters
    private ArrayList<Character> shuffledList; // Shuffled list of characters
    private char character; // Current character
    private String line; // String variable
    private char[] letters; // Array to store characters
    private char[] secretLetters; // Array to store secret characters

    EncryptionProgram(){
        // Initialize scanner and random number generator
        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList(); // Initialize list
        shuffledList = new ArrayList(); // Initialize shuffled list
        character = ' '; // Initialize character

        newkey(); // Generate a new key
        askQuestion(); // Start asking questions to the user

    }

    // Ask user for input
    private void askQuestion(){
        while (true) {
            // Print options for the user
            System.out.println("-----------------------------------------------");
            System.out.println("What do you want to do?");
            System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            // Switch case based on user response
            switch (response) {
                case 'N':
                    newkey(); // Generate a new key
                    break;
                case 'G':
                    getKey(); // Get the current key
                    break;
                case 'E':
                    encrypt(); // Encrypt a message
                    break;
                case 'D':
                    decrypt(); // Decrypt a message
                    break;
                case 'Q':
                    quit(); // Quit the program
                    break;
                default:
                    System.out.println("Not a valid answer!");
            }
        }
    }

    // Generate a new key
    private void newkey(){
        character = ' '; // Reset character
        list.clear(); // Clear the list
        shuffledList.clear(); // Clear the shuffled list

        // Generate list of characters from ASCII 32 to 126
        for (int i = 32; i < 127; i++){
            list.add(Character.valueOf(character)); // Add character to the list
            character++; // Increment character
        }

        shuffledList = new ArrayList(list);  // Create a copy of the list
        Collections.shuffle(shuffledList); // Shuffle the list
        System.out.println("*A new key has been generated*"); // Print message
    }

    // Display the current key
    private void getKey(){
        System.out.println("Key: ");
        // Print original list
        for (Character x : list) {
            System.out.print(x);
        }
        System.out.println();
        // Print shuffled list
        for (Character x : shuffledList) {
            System.out.print(x);
        }
        System.out.println();
    }

    // Encrypt a message
    private void encrypt(){

        System.out.print("Enter a message to be encrypted: "); // Prompt user for input
        String message = scanner.nextLine(); // Read user input
        letters = message.toCharArray(); // Convert input string to character array

        // Iterate through each character in the message
        for (int i = 0; i < letters.length; i++){
            // Iterate through each character in the original list
            for (int j = 0; j < list.size(); j++){
                // If the character matches a character in the original list, replace it with the corresponding character in the shuffled list
                if (letters[i] == list.get(j)){
                    letters[i] = shuffledList.get(j);
                    break;
                }
            
            }
        }
        // Print the encrypted message
        System.out.print("Encrypted: ");
        for (char x : letters){
            System.out.print(x);
        }
        System.out.println();
    }

    // Decrypt a message
    private void decrypt(){
        System.out.print("Enter a message to be decrypted: "); // Prompt user for input
        String message = scanner.nextLine(); // Read user input
        letters = message.toCharArray(); // Convert input string to character array

        // Iterate through each character in the message
        for (int i = 0; i < letters.length; i++){
            // Iterate through each character in the shuffled list
            for (int j = 0; j < shuffledList.size(); j++){
                // If the character matches a character in the shuffled list, replace it with the corresponding character in the original list
                if (letters[i] == shuffledList.get(j)){
                    letters[i] = list.get(j);
                    break;
                }
            
            }
        }
        // Print the decrypted message
        System.out.print("Decrypted: ");
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i]);
        }
        System.out.println();
        

    }

    // Quit the program
    private void quit(){
        System.out.println("Thank you for doing the Encrypt-Decrypt process!"); // Print farewell message
        System.exit(0); // Exit the program

    }
    
}
