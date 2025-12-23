import java.util.Scanner;

public class DNAPattern {

    // Validate DNA string (only A, C, G, T allowed)
    private static boolean isValidDNA(String s) {
        for (char c : s.toCharArray()) {
            if (c != 'A' && c != 'C' && c != 'G' && c != 'T') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter DNA sequence: ");
        String dna = sc.nextLine().toUpperCase();

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine().toUpperCase();

        // DNA validation
        if (!isValidDNA(dna) || !isValidDNA(pattern)) {
            System.out.println("Invalid DNA input. Only A, C, G, T are allowed.");
            return;
        }

        int n = dna.length();
        int m = pattern.length();
        int matchCount = 0;

        for (int i = 0; i <= n - m; i++) {
            boolean match = true;

            for (int j = 0; j < m; j++) {
                if (dna.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                matchCount++;
                System.out.println("Match found at index " + i);
            } else {
                System.out.println("Mismatch at index " + i);
            }
        }

        System.out.println("Total matches found: " + matchCount);
        sc.close();
    }
}
