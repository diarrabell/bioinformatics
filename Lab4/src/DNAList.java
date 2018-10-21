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
        File input = new File(args[1]);

        try(BufferedReader br = new BufferedReader(new FileReader(input))){
            String line;
            int j = 0;
            while ((line = br.readLine()) != null) {
                    String[] lineArr = line.split(" ");

                    // ignores extraneous spaces
                    for(int i=0; i<lineArr.length; i++) {
                        if (!lineArr[i].isEmpty()) {
                            j = i;
                            i = lineArr.length;
                        }
                    }

                    switch (lineArr[j]) {
                        case ("print"):
                            System.out.println("PRINTED");
                            if (lineArr.length > 1) {
                                test.print(Integer.parseInt(lineArr[1]));
                            } else {
                                test.print();
                            }
                            break;
                        case ("remove"):
                            System.out.println("REMOVED");
                            test.remove(Integer.parseInt(lineArr[1]));
                            break;
                        case ("insert"):
                            System.out.println("INSERTED");
                            test.insert(Integer.parseInt(lineArr[1]), lineArr[2], lineArr[3]);
                            break;
                        case ("copy"):
                            System.out.println("COPIED");
                            test.copy(Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]));
                            break;
                        case ("transcribe"):
                            System.out.println("TRANSCRIBED");
                            test.transcribe(Integer.parseInt(lineArr[1]));
                            break;
                        case ("clip"):
                            System.out.println("CLIPPED");
                            test.clip(Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]));
                            break;
                        default:
                            break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
