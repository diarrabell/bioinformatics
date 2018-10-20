/*
Anya Greenberg
Partner: Diarra Bell
MW 1650-1805
Harkness 114
 */

import java.io.*;

public class DNAList {
    public static void main(String[] args) {
        DNA test = new DNA();
        File file = new File (args[1]);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) !=null){
                String [] lineArr = line.split("");
              switch(lineArr[0]){
                  case "print":
                      if (lineArr.length > 1){
                          test.print(Integer.parseInt(lineArr[1]));
                      }
                      else{
                          test.print();
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        test.insert(3,"DNA","TTACTGAATTTT");
        test.insert(1,"EMPTY", " ");
        test.insert(2, "RNA", "ACUGAAUUUU");
        test.insert(4,"RNA","AUAUAUGGCC");
        test.insert(3,"DNA","ACTGTACC");
        test.insert(5,"DNA","TTTATCTG");

        System.out.println("INSERT:");
        System.out.println(test.print());

        System.out.println("PRINT INDEX:");
        System.out.println(test.print(0));
        System.out.println(test.print(1));
        System.out.println(test.print(2) + "\n");

        System.out.println("REMOVE");
        test.remove(2);
        System.out.println(test.print(2));

//        System.out.println("CLIP:");
//        test.clip(0, 2,2);
//        test.clip(3, -2,2);
//        test.clip(3, 3,100);
//        test.clip(3, 6,1);
//        test.clip(2, 2,7);
//        System.out.println(test.print());
//
//        System.out.println(test.print(3));
//        System.out.println("COPY:");
//        test.copy(5,3);
//        System.out.println(test.print(5));
//        System.out.println(test.print(3));
//        test.copy(0,4);
//        System.out.println(test.print());
//
//        System.out.println("TRANSCRIBE:");
//        test.transcribe(0);
//        test.transcribe(4);
//        System.out.println(test.print(5));
//        test.transcribe(5);
//        System.out.println(test.print(5));
    }
}
