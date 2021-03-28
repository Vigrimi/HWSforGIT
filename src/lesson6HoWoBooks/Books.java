package lesson6HoWoBooks;

import java.util.Objects;
import java.util.Arrays;
import java.util.Scanner;

public class Books
{
    public String nameOfBook;
    private int qtyPages;
    private int typeYear;
    //Author authorsName = new Author();
    Scanner scanner = new Scanner(System.in);

    public String getNameOfBook() {
        System.out.println("введи название книги: ");
        //String nameNull = scanner.nextLine();
        nameOfBook = scanner.nextLine();
        if (nameOfBook == null || nameOfBook == "") throw new IllegalArgumentException("введи название книги");
        Objects.requireNonNull(nameOfBook, "введи название книги");
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        Objects.requireNonNull(nameOfBook, "введи название книги");
        this.nameOfBook = nameOfBook;
    }

    public int getQtyPages() {
        System.out.println("введи количество страниц: ");
        qtyPages = scanner.nextInt();
        if (qtyPages < 1) throw new IllegalArgumentException("количество страниц < 1");
        return qtyPages;
    }

    public void setQtyPages() {
        //int qtyPages;
        if (qtyPages < 1) throw new IllegalArgumentException("количество страниц < 1");
        this.qtyPages = qtyPages;
    }

    public int getTypeYear() {
        System.out.println("введи год издания: ");
        typeYear = scanner.nextInt();
        if (typeYear < 1 || typeYear > 2021) throw new IllegalArgumentException("год издания < 1 или >2021");
        return typeYear;
    }

    public void setTypeYear(int typeYear) {
        if (typeYear < 1 || typeYear > 2021) throw new IllegalArgumentException("год издания < 1 или >2021");
        this.typeYear = typeYear;
    }
    private Books[] arrBooks; //создали массив
    public void addBook ()
    {
        arrBooks = new Books[20];
        for (int i = 0; i < 20; i++)
        {
            arrBooks[i] = nameOfBook;
        }
    }


    @Override
    public String toString() {
        return "Название " +
                "книги '" + nameOfBook + '\'' +
                ", количество страниц " + qtyPages +
                ", год издания " + typeYear +
                ". " + "\nkkkk " + Arrays.toString(arrBooks);
    }




}



