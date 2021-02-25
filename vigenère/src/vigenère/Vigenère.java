/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenère;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 *
 * @author MOUISSI
 */
public class Vigenère {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
           String text, res = "";
           
          

        String directory = System.getProperty("user.home");
        String fileName = "a.txt";
        String fileName1 = "b.txt";
        String absolutePath = directory + File.separator + fileName;
        String absolutePath1 = directory + File.separator + fileName1;
        //--------------------
        System.out.print("1. Encryption\n2. Decryption\nChoose(1,2): ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        switch (choice) {
            case 1:

                System.out.println("Encryption");
                in.nextLine();
                BufferedReader ligne = new BufferedReader(new FileReader(absolutePath));

                System.out.print("Enter key : ");  
                String key = in.nextLine();
                       
                System.out.println("This is the message to be encrypted");
                text = ligne.readLine();
                System.out.println(text);
                 text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
           char c = text.charAt(i);
           if (c < 'A' || c > 'Z')
               continue;
           res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
    
     
         
       

                System.out.println("Encryption  :" + res);

                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath1))) {
                    String fileContent = res;
                    bufferedWriter.write( res);
                } catch (IOException e) {
                    // Exception handling
                }
                break;
            case 2:

                System.out.println("Decryption");
                in.nextLine();
                BufferedReader br = new BufferedReader(new FileReader(absolutePath1));
                System.out.print("Enter key : ");  
                String key2 = in.nextLine() ;
                System.out.println("This is the message to be decrypted");
                text = br.readLine();
                System.out.println(text);
               text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
           char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key2.charAt(j) + 26) % 26 + 'A');
            j = ++j % key2.length();
       }
              
		
		
                
                
                
                
                System.out.println("Decryption  :" + res);
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
                    String fileContent = res;
                    bufferedWriter.write(res);
                } catch (IOException e) {
                    // Exception handling
                }
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }
    
}
