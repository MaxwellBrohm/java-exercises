public class main {
    public static void main(String[] args) {
        int[][] map = {
            {5, 1, 3, 1, 2, 4, 2, 1},
            {2, 4, 0, 3, 1, 4, 3, 2},
            {6, 1, 5, 2, 1, 5, 4, 1},
            {2, 3, 4, 1, 2, 2, 1, 0},
            {4, 1, 4, 2, 6, 4, 2, 3},
            {1, 3, 3, 3, 4, 1, 5, 2}
        };

        int rows = map.length;
        int cols = map[0].length;

        // Print original map
        System.out.println("Original Desert Map:");
        System.out.println("====================");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%3d", map[i][j]);
            }
            System.out.println();
        }

        // Build and print Deadly Desert Map
        System.out.println("\nDeadly Desert Map:");
        System.out.println("==================");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Skip edges
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    System.out.print("   ");
                } else {
                    // Sum cell + 4 surrounding cells (up, down, left, right)
                    int sum = map[i][j] + map[i-1][j] + map[i+1][j] + map[i][j-1] + map[i][j+1];
                    if (sum > 15) {
                        System.out.print("  D");
                    } else {
                        System.out.print("   ");
                    }
                }
            }
            System.out.println();
        }
    }
}