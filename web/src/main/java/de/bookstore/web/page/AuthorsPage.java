package de.bookstore.web.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;

import de.bookstore.service.IAuthors;

public class AuthorsPage extends BasePage {

  @SpringBean
  private IAuthors authors;

  private static final long serialVersionUID = 1L;

  public AuthorsPage() {
    add(new Label("nrOfAuthors", authors.findAll().size()));
    add(new Link("newAuthorLink") {

      private static final long serialVersionUID = 1L;

      @Override
      public void onClick() {
        setResponsePage(NewAuthorPage.class);
      }

    });
  }

}
