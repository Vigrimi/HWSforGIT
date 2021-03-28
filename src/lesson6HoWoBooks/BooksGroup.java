package lesson6HoWoBooks;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.Objects;

public class BooksGroup
{
    //Books books;
    public String/*Books*/[] arrBooks = new String /*Books*/[20];; //создали массив
    public void addBook (String /*Books*/ book)
    {
        for (int i = 0; i < 20; i++)
        {
            if (arrBooks[i] == null)
            {
                arrBooks[i] = book;
                return;
            } return;

       // arrBooks[] = book;
        }
        //int i = 0;

          //  i++;
        //}
    }

    @Override
    public String toString() {
        return "BooksGroup{" +
                "arrBooks=" + Arrays.toString(arrBooks) +
                '}';
    }
}
