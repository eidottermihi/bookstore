package de.bookstore.service;

import java.util.List;

import de.bookstore.model.entity.Author;

/**
 * Service-Interface für Author.
 * 
 * @author Michael
 *
 */
public interface IAuthors {
  /**
   * Neuen {@link Author} anlegen.
   * 
   * @param firstname
   * @param lastname
   * @param mail
   * @return erfasster {@link Author}
   */
  Author create(String firstname, String lastname, String mail);

  /**
   * @return alle erfassten Autoren
   */
  List<Author> findAll();

  /**
   * Suche nach Autor.
   * 
   * @param firstname
   * @param lastname
   * @param mail
   * @return Treffer
   */
  List<Author> search(String firstname, String lastname, String mail);
}
