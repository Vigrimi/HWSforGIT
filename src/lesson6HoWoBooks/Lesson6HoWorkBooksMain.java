package lesson6HoWoBooks;

import java.util.Scanner;

public class Lesson6HoWorkBooksMain
{

    public static void main(String[] args)
    {

        //Scanner scanner = new Scanner(System.in);
        System.out.println("1. Реализовать объектную модель: КНИГИ. ");
        int max = 20;
        for (int i = 0; i < max; i++)
        {

            Author authorNameAndSurname = new Author();
            authorNameAndSurname.getAuthorNameAndSurname();


            Books books = new Books(); // можно ли как-то вызвать одну команду, чтобы она спрашивала все характеристики?
            books.getNameOfBook(); // если нажать пустой энтер, почему нет НАЛа?
            books.getQtyPages(); /* ??? */
            books.getTypeYear();

            Warehouse warehouse = new Warehouse();
            warehouse.setUuid();

            System.out.print("№" + (i + 1) + ") " + authorNameAndSurname);
            System.out.println(books);
            System.out.println(warehouse);

            //BooksGroup booksGroup = new BooksGroup();
            //System.out.println(booksGroup);
        }



    }
}
