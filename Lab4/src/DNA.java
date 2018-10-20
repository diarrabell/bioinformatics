/*
Anya Greenberg
Partner: Diarra Bell
MW 1650-1805
Harkness 114
 */

/*
class has methods to modify and observe the sequence array of sequences
*/

import java.util.ArrayList;

class DNA {
    private int pos;
    private TypePointer typePointer;
    private LList<Character> tempSeq;
    private ArrayList<TypePointer> sequenceArray = new ArrayList<>();

    /*
    inserts sequence and changes type at position
     */
    public void insert(int position, String type, String sequence) {
        // sets type and sequence of new item
        typePointer = new TypePointer(type, sequence);

        //checks if sequence is valid
        if (!typePointer.valid(type, sequence)) {
            System.out.println("INVALID: This is a DNA sequence containing the base 'U'." +
                    "\n" + sequence + " was not inserted into the sequence array.");
        } else {

            //fill empty, skipped indexes with null if trying to insert at index higher than size-1
            if (position >= sequenceArray.size()) {
                for (int i=sequenceArray.size(); i <= position; i++) {
                    sequenceArray.add(i,null);
                }
            }

            //replaces specified index
            sequenceArray.set(position,typePointer);
        }
    }

    /*
    removes sequence at position and sets type to empty
     */
    public void remove(int position) {

    }
    /*
    prints the all sequences and indicates position in array and type(RNA or DNA)
     */
    public String print() {
        return sequenceArray.toString();
    }

    /*
    prints the sequence and type at position
     */
    public int print(int position) {
        return pos;
    }

    /*
    replaces sequence at position with clipped version which starts at start and ends at end
     */
    public void clip (int position, int start, int end) {
        tempSeq = new LList<>();

        //checks if sequence at index is null
        if(sequenceArray.get(position) == null) {
            System.out.println("There is no sequence at " + position + "." +  "\n" + "No change was made.");

            // checks if the sequence requested is within the bounds specified
        } else if (start < 0 || start > sequenceArray.get(position).getSeq().size() || end > sequenceArray.get(position).getSeq().size()) {
            System.out.println("That is an invalid input." + "\n" + "No change was made.");

            // if
        } else if (start > end) {
//            seqArry.set(position,tempSeq);
            sequenceArray.get(position).setSeq(tempSeq);
        } else {
            for (int i = start; i <= end; i++) {
                sequenceArray.get(position).getSeq().moveToPos(i);
                tempSeq.append(sequenceArray.get(position).getSeq().getValue());
            }

//            seqArry.set(position,tempSeq);
            sequenceArray.get(position).setSeq(tempSeq);
        }
    }

    /*
    copies sequence at pos1 to pos2
     */
    public void copy (int pos1, int pos2) {
        if(sequenceArray.get(pos1) == null) {
            System.out.println("There is no sequence at " + pos1 + "." +  "\n" + "No change was made.");
        } else {
            sequenceArray.set(pos2, sequenceArray.get(pos1));
        }
    }

    /*
    takes DNA sequence at position and makes it an RNA sequence
     */
    public void transcribe (int position) {
        tempSeq = new LList<>();

        //can't transcribe if null, empty, or RNA
        if (sequenceArray.get(position) == null) {
            System.out.println("There is no sequence at " + position + "." +  "\n" + "No change was made.");
        } else if(sequenceArray.get(position).getType() == TypePointer.Types.DNA) {
            //goes through sequence and changes t to u
            for (int i = sequenceArray.get(position).getSeq().size()-1; i>=0; i--) {
                if(sequenceArray.get(position).getSeq().getValue() == 'T' || sequenceArray.get(position).getSeq().getValue() == 't') {
                    tempSeq.append('A');
                } else if(sequenceArray.get(position).getSeq().getValue() == 'A' || sequenceArray.get(position).getSeq().getValue() == 'a') {
                    tempSeq.append('U');
                } else if(sequenceArray.get(position).getSeq().getValue() == 'G' || sequenceArray.get(position).getSeq().getValue() == 'g') {
                    tempSeq.append('C');
                } else if(sequenceArray.get(position).getSeq().getValue() == 'C' || sequenceArray.get(position).getSeq().getValue() == 'C') {
                    tempSeq.append('G');
                }
                sequenceArray.get(position).getSeq().next();
            }

            System.out.println(tempSeq);

            sequenceArray.get(position).setType("RNA");
            sequenceArray.get(position).setSeq(tempSeq);
        } else {
            System.out.println("Cannot perform transcription on this type." + "\n" + "No change was made.");
        }
    }



    public void Test() {

        System.out.print("Types: ");
        for (int i=0; i<sequenceArray.size(); i++){
            if(i==0) {
                System.out.print("{");
            }

            if (sequenceArray.get(i).getTypeString() != null) {
                System.out.print(sequenceArray.get(i).getTypeString());
            }

            if(i!=sequenceArray.size()-1) {
                System.out.print(", ");
            }

            if(i==sequenceArray.size()-1) {
                System.out.print("}");
            }
        }

        System.out.println();

        System.out.print("Sequences: ");
        for (int i=0; i<sequenceArray.size(); i++) {
            if(i==0) {
                System.out.print("{");
            }

            if (sequenceArray.get(i).getSeq().toString() != null) {
                System.out.print(sequenceArray.get(i).getSeq().toString());
            }

            if(i!=sequenceArray.size()-1) {
                System.out.print(", ");
            }

            if(i==sequenceArray.size()-1) {
                System.out.print("}");
            }
        }

        System.out.println();

        System.out.println();
    }
}