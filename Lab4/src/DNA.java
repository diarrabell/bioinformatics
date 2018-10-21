/*
Anya Greenberg
Partner: Diarra Bell
MW 1650-1805
Harkness 114
 */

/*
class has methods to modify and observe the sequence array of sequences
*/

class DNA {
    private TypePointer typePointer;
    private LList<Character> tempSeq;
    private TypePointer[] sequenceArray;
    private TypePointer tempPointer;

    public DNA (int n) {
        sequenceArray = new TypePointer[n];
    }

    /*
    inserts sequence and changes type at position
     */
    public void insert(int position, String type, String sequence) {
        // sets type and sequence of new item
        typePointer = new TypePointer(type, sequence);
        System.out.println("INSERT");

        //checks if sequence is valid
        if (!typePointer.valid(type, sequence)) {
            System.out.println("INVALID: This is a DNA sequence containing the base 'U'." +
                    "\n" + sequence + " was not inserted into the sequence array." + "\n");
        } else {

            //fill empty, skipped indexes with null if trying to insert at index higher than size-1
            if (position >= sequenceArray.length) {
                for (int i=sequenceArray.length; i <= position; i++) {
                    sequenceArray[i] = null;
                }
            }

            //replaces specified index
            sequenceArray[position] = typePointer;
        }
    }

    /*
    removes sequence at position and sets type to empty
     */
    public void remove(int position) {
        String s = "";
        System.out.println("REMOVE");

        sequenceArray[position].setType("EMPTY");
        sequenceArray[position].setSeq(null);
        System.out.println("The sequence at position " + position + " was removed." + "\n");
    }

    /*
    prints the all sequences and indicates position in array and type(RNA or DNA)
     */
    public void print() {
        String s = "";
        System.out.println("PRINT");

        for(int i=0; i<sequenceArray.length; i++) {
            if (sequenceArray[i] != null && sequenceArray[i].getTypeString() != "EMPTY") {
                s = s + sequenceArray[i].getSeq().toString() + " - Type: " + sequenceArray[i].getTypeString() + "; Position: " + i + "\n";
            }
        }
        System.out.print(s + "\n");
    }

    /*
    prints the sequence and type at position
     */
    public void print(int position) {
        String s = "";
        System.out.println("PRINT");

        if (sequenceArray[position] != null && sequenceArray[position].getTypeString() != "EMPTY") {
            s = sequenceArray[position].getSeq() + " - Type: " + sequenceArray[position].getTypeString() + "; Position: " + position;
        } else {
            s = "Sorry. There is no sequence at " + position + ".";
        }
        System.out.print(s + "\n");
    }

    /*
    replaces sequence at position with clipped version which starts at start and ends at end
     */
    public void clip (int position, int start, int end) {
        tempSeq = new LList<>();
        System.out.println("CLIP");

        //checks if sequence at index is null
        if(sequenceArray[position] == null) {
            System.out.println("There is no sequence at " + position + "." +  "\n" + "No change was made." + "\n");

            // checks if the sequence requested is within the bounds specified
        } else if (start < 0 || start > sequenceArray[position].getSeq().size() || end > sequenceArray[position].getSeq().size()) {
            System.out.println("That is an invalid input." + "\n" + "No change was made." + "\n");

            // if the start is greater than end, replace sequence with empty sequence
        } else if (start > end) {
            sequenceArray[position].setSeq(tempSeq);
            // clips sequence if parameters are within bounds
        } else {
            for (int i = start; i <= end; i++) {
                sequenceArray[position].getSeq().moveToPos(i);
                tempSeq.append(sequenceArray[position].getSeq().getValue());
            }

            sequenceArray[position].setSeq(tempSeq);
        }
    }

    /*
    copies sequence at pos1 to pos2
     */
    public void copy (int pos1, int pos2) {
        System.out.println("COPY");

        // if sequence null, don't do anything
        if(sequenceArray[pos1] == null) {
            System.out.println("There is no sequence at " + pos1 + "." +  "\n" + "No change was made." + "\n");
        // copies
        } else {
            tempPointer = new TypePointer(sequenceArray[pos1].getTypeString(), sequenceArray[pos1].getSeq());
            sequenceArray[pos2] = tempPointer;
        }
    }

    /*
    takes DNA sequence at position and makes it an RNA sequence
     */
    public void transcribe (int position) {
        tempSeq = new LList<>();
        System.out.println("TRANSCRIBE");

        //can't transcribe if null, empty, or RNA
        if (sequenceArray[position] == null) {
            System.out.println("There is no sequence at " + position + "." +  "\n" + "No change was made." + "\n");
            //goes through sequence and changes t to u
        } else if(sequenceArray[position].getType() == TypePointer.Types.DNA) {
            sequenceArray[position].getSeq().moveToEnd();
            sequenceArray[position].getSeq().prev();
            for (int i = 0; i<sequenceArray[position].getSeq().size(); i++) {
                if(sequenceArray[position].getSeq().getValue() == 'T' ) {
                    tempSeq.append('A');
                } else if(sequenceArray[position].getSeq().getValue() == 'A') {
                    tempSeq.append('U');
                } else if(sequenceArray[position].getSeq().getValue() == 'G' ) {
                    tempSeq.append('C');
                } else if(sequenceArray[position].getSeq().getValue() == 'C' ) {
                    tempSeq.append('G');
                }
                sequenceArray[position].getSeq().prev();
            }
            sequenceArray[position].setType("RNA");
            sequenceArray[position].setSeq(tempSeq);
        } else {
            System.out.println("Cannot perform transcription on this type." + "\n" + "No change was made." + "\n");
        }
    }
}