package databases;

import classes.Book;

public interface Where<E> {
    boolean test(E e);
}
