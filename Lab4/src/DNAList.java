/*
Anya Greenberg
Partner: Diarra Bell
MW 1650-1805
Harkness 114
 */

public class DNAList {
    public static void main(String[] args) {
        DNA test = new DNA();

        test.insert(3,"DNA","TTACTGAATTTT");
        test.insert(1,"EMPTY", " ");
        test.insert(2, "RNA", "ACUGAAUUUU");
        test.insert(0,"DNA","ACT");

        System.out.println("INSERT");
        test.Test();

        System.out.println("CLIP");
        test.clip(0, 2,2);
        test.Test();

        System.out.println("COPY");
        test.copy(2,1);
        test.Test();

        System.out.println("TRANSCRIBE");
        test.transcribe(3);
        test.Test();


//       testList.append('A');
//       testList.append('T');
//       testList.append('C');
//       testList.append('G');
//       System.out.println("STARAT: " + testList.toString());
//
//       testList.moveToPos(3);
//       System.out.println("Moved to position 3: " + testList.toString());
//
//       testList.remove();
//       System.out.println("Removed current: " + testList.toString());
//
//       testList.insert('A');
//       System.out.println("inserted 'A': " + testList.toString());
//
//
//       testList.moveToStart();
//       System.out.println("Moved to start: " + testList.toString());
//
//       testList.next();
//       System.out.println("Moved to next: " + testList.toString());
//
//       testList.moveToEnd();
//       System.out.println("Moved to end: " + testList.toString());
//
//       testList.prev();
//       System.out.println("Moved to previous: " + testList.toString());
//
//       System.out.println("Length:" + testList.length());
//       System.out.println("Value of current: " + testList.getValue());
//       System.out.println("Current Position: " + testList.currPos());
//       System.out.println(testList.toString());
//
//       testList.clear();
//
//       testList.append('A');
//       testList.append('U');
//       testList.append('C');
//       testList.append('G');
//       System.out.println(testList.toString());

    }
}
