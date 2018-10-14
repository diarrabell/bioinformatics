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
    private enum Type {DNA, RNA, EMPTY};
    private LList<Character> seq;
    private ArrayList<String> t;
    private ArrayList<ArrayList<String>> seqs;


    /*
    inserts sequence and changes type at position
     */
    public void insert(Integer position, String type, String sequence) {
        if (!valid(type, sequence)) {
            System.out.println("INVALID: This is a DNA sequence containing the base 'U'." +
                    "\n" + sequence + " was not inserted into the sequence array.");
        } else {
            

           for(int i=0; i<sequence.length();i++) {
               seq.append(sequence.charAt(i));
           }
           

           seqs.add
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

    }

    /*
    copies sequence at pos1 to pos2
     */
    public void copy (int pos1, int pos2) {

    }

    /*
    takes DNA sequence at position and makes it an RNA sequence
     */
    public void transcribe (int position) {
    }

    /*
    checks whether the sequence contians the correct letters corresponding with its type
     */
    public boolean valid(String type, String sequence) {
        switch(type) {
            case ("DNA"):
                if (sequence.contains("U") || sequence.contains("u")) {
                    return false;
                }
                break;

            case ("RNA"):
                if (sequence.contains("T") || sequence.contains("t")) {
                    return false;
                }
                break;
        }

        return true;
    }
}