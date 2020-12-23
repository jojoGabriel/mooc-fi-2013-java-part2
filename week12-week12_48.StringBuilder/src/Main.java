
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder string = new StringBuilder(100);
        string.append("{\n");
        int x = 0;
        for (int i = 0; i < t.length; i++) {
            if (x == 0) {
                string.append(" ");
            }
            string.append(t[i]);
            x++;
            if (i < t.length - 1) {
                string.append(", ");
            }
            if (x == 4 && t.length > 4) {
                string.append("\n");
                x = 0;
            }

        }
        string.append("\n");
        string.append("}");
        return "" + string;
    }

}
