import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Assignment1 {

    public static void validatePassword(String password) throws Exception {
        if(password.length() < 4){
            throw new Exception("Password validation failed - Password length cannot be less than 4");
        }
        boolean has_numeric, has_uppercase;
        has_numeric = false;
        has_uppercase = false;
        for(char c:password.toCharArray()){
            if(c >= 'A' && c<= 'Z') {
                has_uppercase = true;
            }else if(c >= '0' && c<='9'){
                has_numeric = true;
            }
        }

        if(!has_numeric){
            throw new Exception("Password validation failed - Password should have at least 1 numeric character");
        }

        if(!has_uppercase){
            throw new Exception("Password validation failed - Password should have at least 1 upper-case character");
        }
    }

    public static int[] generateSales(){
        int []array = new int[10];
        Random rand = new Random();
        for(int i = 0; i<10; i++){
            array[i] = (rand.nextInt(100));
        }

        System.out.println("Sales: " + Arrays.toString(array));
        return array;
    }

    public static String writeToFile(int[]array) throws IOException {
        String filename = "numbers.txt";
        FileWriter myWriter = new FileWriter(filename);
        for (int value : array) {
            myWriter.append(value + "\n");
        }
        myWriter.close();
        return filename;
    }


    public static ArrayList<Integer> readNumbers(String filename) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<>();
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            numbers.add(Integer.parseInt(data));
        }
        myReader.close();
        return numbers;
    }


    public static void main(String[] args) {
        System.out.print("Enter password:");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        try {
            validatePassword(password);
            int[] array = generateSales();
            String filename = writeToFile(array);
            ArrayList<Integer> list  = readNumbers(filename);
            System.out.print(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
