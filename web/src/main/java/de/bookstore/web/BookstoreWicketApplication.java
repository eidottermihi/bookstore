package de.bookstore.web;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import de.agilecoders.wicket.core.Bootstrap;
import de.bookstore.web.page.BooksPage;

public class BookstoreWicketApplication extends WebApplication {

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.wicket.Application#getHomePage()
   */
  @Override
  public Class<? extends Page> getHomePage() {
    return BooksPage.class;
    
  }

  @Override
  protected void init() {
    Bootstrap.install(this);
    super.init();
  }

}
