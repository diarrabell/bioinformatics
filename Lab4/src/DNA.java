/*
Anya Greenberg
Partner: Diarra Bell
MW 1650-1805
Harkness 114
 */

/*
based on Linked List Implementation from class
*/

import java.util.ArrayList;

class DNA {
    private int pos;
    private enum Types {DNA, RNA, EMPTY}
    private Types types;
    private LList<Character> seq;//sequence
    private LList<Character> nullHolder = new LList<>();
    private ArrayList<Types> stringType = new ArrayList<Types>(); //types
    private ArrayList<LList<Character>> seqArry = new ArrayList<>(); //stores sequences


    /*
    inserts sequence and changes type at position
     */
    public void insert(int position, String type, String sequence) {
        setType(type);

        if (!valid(type, sequence)) {
            System.out.println("INVALID: This is a DNA sequence containing the base 'U'." +
                    "\n" + sequence + " was not inserted into the sequence array.");
        } else {
            //makes linked list out of sequence
            seq = new LList<>();

            if (getType() == Types.EMPTY) {
                seq = nullHolder;
            } else {
                for (int i = 0; i < sequence.length(); i++) {
                    seq.append(sequence.charAt(i));
                }
            }

            //following two if statements allow a sequence to be placed in an index larger than the array
            if (position >= stringType.size()) {
                for (int i=stringType.size(); i <= position; i++) {
                    stringType.add(i,null);
                }
            }

            if (position >= seqArry.size()) {
                for (int i=seqArry.size(); i <= position; i++) {
                    seqArry.add(i, nullHolder);
                }
            }

            //removes and replaces specified index
            stringType.set(position,getType());
            seqArry.set(position,seq);

//           System.out.println("Types: " + stringType.toString());
//           System.out.println("Sequences: " + seqArry);
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
        return seq.toString();
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
        LList<Character> temp = new LList<>();

        if(seqArry.get(position) == nullHolder) {
            System.out.println("There is no sequence at " + position + "." +  "\n" + "No change was made.");
        } else if (start < 0 || start > seqArry.get(position).size() || end >= seqArry.get(position).size()) {
            System.out.println("That is an invalid input." + "\n" + "No change was made.");
        } else if (start > end) {
            seqArry.set(position, nullHolder);
            stringType.set(position, Types.EMPTY);
        } else {
            for (int i = start; i <= end; i++) {
                seqArry.get(position).moveToPos(i);
                temp.append(seqArry.get(position).getValue());
            }
            seqArry.set(position, temp);
        }
    }

    /*
    copies sequence at pos1 to pos2
     */
    public void copy (int pos1, int pos2) {
        if(seqArry.get(pos1) == nullHolder) {
            System.out.println("There is no sequence at " + pos1 + "." +  "\n" + "No change was made.");
        } else {
            seqArry.set(pos2, seqArry.get(pos1));
            stringType.set(pos2, stringType.get(pos1));

        }
    }

    /*
    takes DNA sequence at position and makes it an RNA sequence
     */
    public void transcribe (int position) {
        LList<Character> temp = new LList<>();

        if (seqArry.get(position) == nullHolder) {
            System.out.println("There is no sequence at " + position + "." +  "\n" + "No change was made.");
        } else if(stringType.get(position) == Types.DNA) {
            stringType.set(position, Types.RNA);
            for (int i = seqArry.get(position).size()-1; i>=0; i--) {
                if(seqArry.get(position).getValue() == 'T' || seqArry.get(position).getValue() == 't') {
                    temp.append('A');
                } else if(seqArry.get(position).getValue() == 'A' || seqArry.get(position).getValue() == 'a') {
                    temp.append('U');
                } else if(seqArry.get(position).getValue() == 'G' || seqArry.get(position).getValue() == 'g') {
                    temp.append('C');
                } else if(seqArry.get(position).getValue() == 'C' || seqArry.get(position).getValue() == 'C') {
                    temp.append('G');
                }
                seqArry.get(position).next();
            }
            seqArry.set(position, temp);

        } else {
            System.out.println("Cannot perform transcription on this type." + "\n" + "No change was made.");
        }
    }

    /*
    checks whether the sequence contians the correct letters corresponding with its type
     */
    public boolean valid(String type, String sequence) {
        switch(type) {
            case "DNA":
                if (sequence.contains("U") || sequence.contains("u")) {
                    return false;
                }
                break;

            case "RNA":
                if (sequence.contains("T") || sequence.contains("t")) {
                    return false;
                }
                break;
        }
        return true;
    }

    public Types getType() {
        return this.types;
    }

    public void setType(String a) {
        switch(a) {
            case("DNA"):
                this.types =  Types.DNA;
                break;
            case("RNA"):
                this.types =  Types.RNA;
                break;
            case("EMPTY"):
                this.types = Types.EMPTY;
                break;
            default: System.out.println("That is not a valid type.");
        }
    }

    public void Test() {
        System.out.println("Types: " + stringType.toString());
        System.out.println("Sequences: " + seqArry);
    }
}