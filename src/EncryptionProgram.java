import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class EncryptionProgram {
    private Scanner scanner;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private String text;
    private String encryptedText = "";
    private String decryptedText = "";
    private char character;


    EncryptionProgram(){
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        character = ' ';

        for (int i = 32; i<127 ; i++){
            list.add(character);
            character++;
        }
        setKey();
        start();
    }
    private void start(){
        while(true) {
            System.out.println("***********************************************************");
            System.out.println("What do yu want me to do?");
            System.out.println("(S)etKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (response){
                case 'S':
                    setKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
            }
        }
    }
    private void setKey(){
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("*** New key generated ***");
    }
    private void getKey(){
        System.out.println("Initial List: "+"\t" + list +"\n"+ "Shuffled List: " + shuffledList);

    }
    private void encrypt(){
        System.out.println("Write the text that you want tobe encrypted:");
        String text = scanner.nextLine();
        for(int i = 0; i< text.length(); i++){
            for (int j = 0; j<list.size(); j++){
                if(text.charAt(i) == list.get(j)){
                    encryptedText += shuffledList.get(j);
                }
            }
        }
        System.out.println("Encrypted Text: "+encryptedText);
    }
    private void decrypt(){
        for(int i = 0; i< encryptedText.length(); i++){
            for (int j = 0; j<shuffledList.size(); j++){
                if(encryptedText.charAt(i) == shuffledList.get(j)){
                    decryptedText += list.get(j);
                }
            }
        }
        System.out.println("Decrypted Text: "+decryptedText);
    }
    private void quit(){
        System.out.println("Thank you for using this program. Have a nice day.");
        System.exit(0);
    }
}
