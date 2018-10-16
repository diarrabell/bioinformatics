import java.util.ArrayList;

public class TypePointer {
    public enum Types {DNA, RNA, EMPTY}
    private Types types;
    private LList<Character> seq;//sequence
    private LList<Character> temp;
    private LList<Character> nullHolder = new LList<>();
//    private ArrayList<LList<Character>> seqArry = new ArrayList<>(); //stores sequences

   public TypePointer(String type, String sequence) {
       setType(type);
       temp = new LList<>();

       if (getType() == Types.EMPTY) {
           temp = nullHolder;
       } else {
           for (int i = 0; i < sequence.length(); i++) {
               temp.append(sequence.charAt(i));
           }
       }

       this.seq = temp;
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

    public String getTypeString() {
        switch(this.types) {
            case DNA:
                return "DNA";
            case RNA:
                return "RNA";
            case EMPTY:
                return "EMPTY";
            default: return "That is not a valid type.";
        }
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

    public LList<Character> getSeq() {
        return this.seq;
    }

    public void setSeq(LList<Character> seq) {
        this.seq = seq;
    }
}
