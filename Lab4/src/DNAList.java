/*
Anya Greenberg
Partner: Diarra Bell
MW 1650-1805
Harkness 114
 */

import java.io.*;

public class DNAList {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        DNA test = new DNA(n);
<<<<<<< HEAD
        File file = new File(args[1]);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 0) {
                    String[] lineArr = line.split("");
                    switch (lineArr[0]) {
                        case "print":
                            if (lineArr.length > 1) {
                                String print = test.print(Integer.parseInt(lineArr[1]));
                                System.out.println(print);
                            } else {
                                String print = test.print();
                                System.out.println(print);
                            }
                            break;
                        case "remove":
                            test.remove(Integer.parseInt(lineArr[1]));
                            break;
                        case "insert":
                            test.insert(Integer.parseInt(lineArr[1]), lineArr[2], lineArr[3]);
                            break;
                        case "copy":
                            test.copy(Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]));
                            break;
                        case "transcribe":
                            test.transcribe(Integer.parseInt(lineArr[1]));
                            break;
                        case "clip":
                            test.clip(Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]));
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
=======
        File input = new File(args[1]);

        //reads file
        try(BufferedReader br = new BufferedReader(new FileReader(input))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(" ");
                String[] temp = new String[lineArr.length];
                int j = 0;

                // ignores extraneous spaces
                for (int i = 0; i < lineArr.length; i++) {
                    if (!lineArr[i].isEmpty()) {
                        temp[j] = lineArr[i];
                        j++;
                    }
                }
                // checks if the line is empty/ null and if not, does operations
                    if(temp.length  != 0 && temp[0] != null) {
                        switch (temp[0]) {
                            case ("print"):
                                if (temp.length >1) {
                                    test.print(Integer.parseInt(temp[1]));

                                } else {
                                    test.print();
                                }
                                break;
                            case ("remove"):
                                test.remove(Integer.parseInt(temp[1]));
                                break;
                            case ("insert"):
                                int k = Integer.parseInt(temp[1]);
                                if ( k< n) {
                                    test.insert(Integer.parseInt(temp[1]), temp[2], temp[3]);
                                }
                                break;
                            case ("copy"):
                                test.copy(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
                                break;
                            case ("transcribe"):
                                test.transcribe(Integer.parseInt(temp[1]));
                                break;
                            case ("clip"):
                                test.clip(Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
                                break;
                            default:
                                break;
                        }
                    }
            }
        } catch (IOException e) {
                e.printStackTrace();
>>>>>>> a024e99b310c760e7fd4afddb7c1efe86890ad78
        }
    }
}
