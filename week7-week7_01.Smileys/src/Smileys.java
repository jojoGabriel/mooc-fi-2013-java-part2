
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("\\:D/");
        printWithSmileys("Mikael");
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString) {
        int len = characterString.length();
        int tot = 0;
        boolean odd;
        int smiley = 2;
        int space = 1;
                       
        
        if (len % 2 == 0) {
            tot = smiley + space + len + space + smiley;
            odd = false;
        } else {
            len++;
            tot = smiley + space + len + space + smiley;
            odd = true;
        }
        printSmileys(tot, true);
        
        printSmileys((tot-len-space-smiley)/2, false);
        
        System.out.print(" ");
        System.out.print(characterString);
        if (odd) {
            System.out.print(" ");
        }        
        System.out.print(" ");
        
        printSmileys((tot-len-space-smiley)/2, true);
        
        printSmileys(tot, true);
        
    
    }
    
    private static void printSmileys(int times, boolean newLine) {
        for (int i = 0; i < times; i=i+2) {
            System.out.print(":)");
        }
        if (newLine) {
            System.out.println("");
        }
    }

}
