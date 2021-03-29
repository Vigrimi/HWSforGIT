package lesson6HoWoBooks;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.Objects;

public class BooksGroup
{
//    Books nameOfBooks1 = new Books();
//    nameOfBooks1.;

    //Books books;
    public String/*Books*/[] arrBooks = new String /*Books*/[20];; //создали массив
    //int a = 0;
    public void addBook (String /*Books*/ book)
    {
        int a = 0;
        for (int i = 0; i < 20; i++)
        {
            /*if (arrBooks[i] != null) a++;
            else*/
            if (arrBooks[i] == null)
            {
                /*arrBooks[i] = book;
                return;
            } else */
                for (int j = 0; j < (i-1); j++)
                {
                    String frazaProverka = book.substring(28, book.length() - 54);
                    if (arrBooks[j].contains(frazaProverka)) a++; // если такая книга есть чота ошибку выдаёт
                    // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.contains(java.lang.CharSequence)" because "this.arrBooks[j]" is null
                }

                if (a == 0)
                {
                    arrBooks[i] = book;
                    return;
                }

            }
        }
    }

    @Override
    public String toString() {
        return "Наша библиотека " +
                "состоит из следующих книг: \n" + Arrays.toString(arrBooks) +
                ".\n";
    }
}
