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
        }
    }
}
