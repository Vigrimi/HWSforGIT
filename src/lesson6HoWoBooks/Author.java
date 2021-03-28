package lesson6HoWoBooks;

import java.util.Objects;
import java.util.Scanner;

public class Author
{
    Scanner scanner = new Scanner(System.in);
    public String authorNameAndSurname;

    //outer:
    public String getAuthorNameAndSurname() {
        System.out.println("\nвведи фио автора книги: ");
        authorNameAndSurname = scanner.nextLine();
        if (authorNameAndSurname == null || authorNameAndSurname == "") throw new IllegalArgumentException("введи имя и фамилию автора");
        Objects.requireNonNull(authorNameAndSurname, "введи имя и фамилию автора");
        //if (authorNameAndSurname.equalsIgnoreCase("выход")) break;
        return authorNameAndSurname;
    }

    public void setAuthorNameAndSurname(String authorNameAndSurname)
    {
        Objects.requireNonNull(authorNameAndSurname, "введи имя и фамилию автора");
        this.authorNameAndSurname = authorNameAndSurname;
    }

    @Override
    public String toString() {
        return "Книга: " +
                "Автор книги, ФИО: '" + authorNameAndSurname + '\'' +
                ". ";
    }
}
