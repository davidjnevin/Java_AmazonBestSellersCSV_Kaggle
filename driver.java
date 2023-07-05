import java.util.ArrayList;

public class driver {
    public static void printData(String dataset[][]) {
        for (int i = 1; i < dataset.length; i++) {
            System.out.println("Name:" + dataset[i][0]);
            System.out.println("Author:" + dataset[i][1]);
            System.out.println("Rating:" + dataset[i][2]);
            System.out.println("Reviews:" + dataset[i][3]);
            System.out.println("Price:" + dataset[i][4]);
            System.out.println("Year:" + dataset[i][5]);
            System.out.println("Genre:" + dataset[i][6]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reader r = new reader();

        String[][] dataset = r.readDataset("data.csv");
        // printData(dataset);

        // Number of Books by Author
        System.out.println(authorBooks("Bill O'Reilly", dataset));

        // All Authors
        for (String author : allAuthors(dataset))
            System.out.println(author);

        // Books by Author
        for (String book : booksByAuthors("J.K. Rowling", dataset))
            System.out.println(book);

        // Book ratings
        for (String book : booksRating(dataset, "4.9"))
            System.out.println(book);

        // Books and Prices
        String[][] result = booksAndPrice(dataset, "George R. R. Martin");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++)
                System.out.print(result[i][j] + " ");

        }
        System.out.println();
    }

    public static int authorBooks(String author, String[][] dataset) {
        // Create an Array to hold the books
        ArrayList<String> book = new ArrayList<>();

        for (int i = 1; i < dataset.length; i++) {
            if (dataset[i][1].equals(author) && !book.contains(dataset[i][0])) {
                book.add(dataset[i][0]);
            }
        }
        return book.size();
    }

    public static ArrayList<String> allAuthors(String[][] dataset) {
        // A list of authors
        ArrayList<String> author = new ArrayList<>();
        for (int i = 1; i < dataset.length; i++) {
            if (author.contains(dataset[i][1]) == false) {
                author.add(dataset[i][1]);
            }
        }
        return author;
    }

    public static ArrayList<String> booksByAuthors(String author, String[][] dataset) {
        // All books by an author
        ArrayList<String> books = new ArrayList<>();

        for (int i = 1; i < dataset.length; i++) {
            if (author.equals(dataset[i][1]) && !books.contains(dataset[i][0])) {
                books.add(dataset[i][0]);
            }
        }
        return books;
    }

    public static ArrayList<String> booksRating(String[][] dataset, String rating) {
        // All books by an author
        ArrayList<String> book = new ArrayList<>();

        for (int i = 1; i < dataset.length; i++) {
            if (dataset[i][2].equals(rating) && !book.contains(dataset[i][0] + " by " + dataset[i][1])) {
                book.add(dataset[i][0] + " by " + dataset[i][1]);
            }
        }
        return book;

    }

    public static String[][] booksAndPrice(String[][] dataset, String author) {
        // All books and price
        ArrayList<String> book = new ArrayList<>();
        ArrayList<String> price = new ArrayList<>();

        for (int i = 1; i < dataset.length; i++) {
            if (dataset[i][1].equals(author) && !book.contains(dataset[i][0])) {
                book.add(dataset[i][0]);
                price.add(dataset[i][4]);
            }
        }

        // create a 2d array
        String[][] result = new String[book.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = book.get(i);
            result[i][1] = price.get(i);
        }
        return result;
    }
}