package lesson6HoWoBooks;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.Objects;

public class BooksGroup
{
    Books books;
    private Books[] arrBooks; //создали массив
    public void addBook (Book book)
    {
        arrBooks = new Books[20];
        for (int i = 0; i < 20; i++)
        {
            arrBooks[i] = books.nameOfBook;
        }
    }

}
