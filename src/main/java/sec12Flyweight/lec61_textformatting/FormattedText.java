package sec12Flyweight.lec61_textformatting;

import java.util.ArrayList;
import java.util.List;

class BadlyFormattedText {

    private String plainText;
    private boolean[] capitalize;


    public BadlyFormattedText(String plainText) {
        this.plainText = plainText;
        capitalize = new boolean[plainText.length()];
    }

    public void capitalize (int start, int end) {
        for (int i = start; i <= end; ++i) {
            capitalize[i] = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            sb.append(capitalize[i] ? Character.toUpperCase(c) : c);
        }
        return sb.toString();
    }
}


class BetterFormattedText {

    private String plainText;
    private List<TextRange> formatting = new ArrayList<>();

    public BetterFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange textRange = new TextRange(start, end);
        formatting.add(textRange);
        return textRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); ++i) {
            char c = plainText.charAt(i);
            for (TextRange range : formatting) {
                if(range.covers(i) && range.capitalize) {
                    c = Character.toUpperCase(c);
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public class TextRange {
        public int start, end;
        public boolean capitalize, bold, italic;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers (int position) {
            return position >= start && position <= end;
        }
    }

}



class Demo {
    public static void main(String[] args) {
        BadlyFormattedText ft = new BadlyFormattedText("This is a brave new world");
        ft.capitalize(10,15);
        System.out.println(ft);

        BetterFormattedText bft = new BetterFormattedText("Make America Great Again");
        // flyweight
        bft.getRange(13,18).capitalize = true; // co je toto za syntax? ChatGPT
        System.out.println(bft);

    }
}