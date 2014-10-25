package de.bookstore.model.entity;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table
@Access(AccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = Author.FIND_ALL, query = "from Author a"),
    @NamedQuery(name = Author.SEARCH,
        query = "from Author a where (:firstname is null or a.firstname = :firstname)"
            + " and (:lastname is null or a.lastname = :lastname)"
            + " and (:mail is null or a.mail = :mail)") })
public class Author {

  public static final String FIND_ALL = "Author.FIND_ALL";
  public static final String SEARCH = "Author.SEARCH";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Version
  private int version;
  @Column
  private String firstname;
  @Column
  private String lastname;
  @Column
  private String mail;
  @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<Book> books;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

}
