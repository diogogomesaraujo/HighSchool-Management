package builder;

import java.util.*;

public class main {

    public static void printTable(ArrayList<ArrayList<Object>> data) {
        // Find the maximum width of each column
        ArrayList<Integer> columnWidths = new ArrayList<>();
        for (ArrayList<Object> row : data) {
            for (int i = 0; i < row.size(); i++) {
                int length = row.get(i).toString().length();
                if (columnWidths.size() <= i) {
                    columnWidths.add(length);
                } else if (length > columnWidths.get(i)) {
                    columnWidths.set(i, length);
                }
            }
        }

        // Print the table
        for (ArrayList<Object> row : data) {
            for (int i = 0; i < row.size(); i++) {
                String cell = row.get(i).toString();
                int width = columnWidths.get(i);
                System.out.print(String.format("%-" + width + "s ", cell));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<ArrayList<Object>> table = new ArrayList<>();
        table.add(new ArrayList<>(List.of("ID", "Name", "Age")));
        table.add(new ArrayList<>(List.of(1, "Alice", 30)));
        table.add(new ArrayList<>(List.of(2, "Bob", 25)));
        table.add(new ArrayList<>(List.of(3, "Charlie", 28)));

        printTable(table);
    }
}
