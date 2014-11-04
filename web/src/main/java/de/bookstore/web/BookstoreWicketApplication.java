package de.bookstore.web;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import de.bookstore.web.page.AuthorsPage;

public class BookstoreWicketApplication extends WebApplication {

  @Autowired
  private ApplicationContext applicationContext;

  /*
   * (non-Javadoc)
   * 
   * @see org.apache.wicket.Application#getHomePage()
   */
  @Override
  public Class<? extends Page> getHomePage() {
    return AuthorsPage.class;

  }

  @Override
  protected void init() {
    super.init();
    getComponentInstantiationListeners().add(
        new SpringComponentInjector(this, applicationContext, true));
  }

}
