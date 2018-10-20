/*
Anya Greenberg
Partner: Diarra Bell
MW 1650-1805
Harkness 114
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class DNAList {
    public static void main(String[] args) {
        DNA test = new DNA();
        


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
