// Umgebung für Build

// Artifactory
binaryRepository {
  url = "http://localhost:8081/artifactory"
  username = "admin"
  password = "password"
  name = "libs-release-local"
}

environments {
  test {
    server {
      hostname = 'localhost'
      port = 11080
      context = 'bookstore'
      username = 'admin'
      password = 's3cret'
    }
  }

  uat {
    server {
      hostname = 'localhost'
      port = 12080
      context = 'bookstoreuat'
      username = 'admin'
      password = 's3cret'
    }
  }

  prod {
    server {
      hostname = 'localhost'
      port = 13080
      context = 'bookstoreprod'
      username = 'admin'
      password = 's3cret'
    }
  }

  load {
    server {
      hostname = 'localhost'
      port = 14080
      context = 'bookstoreprod'
      username = 'admin'
      password = 's3cret'
    }
  }
}