package algorithms;

public class ExcelSheet {

    String getExcelColumnName(int num) {
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            int digit = (num%26);
            char c = getChar(digit);
            System.out.println(digit);
            sb.append(c);
            num /= 26;
        }

        return sb.reverse().toString();
    }

    private char getChar(int digit) {
        return (char) (digit + 64);
    }

    public static void main(String[] args) {
        int val = 702;

        ExcelSheet es = new ExcelSheet();
        String excel = es.getExcelColumnName(val);
        System.out.println(excel);
    }
}
