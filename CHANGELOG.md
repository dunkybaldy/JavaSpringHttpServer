#### 16-09-20
* Test infrastructure
    * Endpoint builder for easy creation of api endpoints
    * Test class marked with @Transactional so that the db won't have to keep being refreshed
* Fix post and put requests
    * problem was Spring expects model classes to have a specific naming convention
    * Json not lining up

#### 15-09-20
* Commit to using .yml for application properties
    * This was also causing database connection issue on startup
* Validation on swagger api
* Api try-catches
    * try to return useful errors (not 500)
* Begin correctly using beans and annotations to achieve spring standards.
* Implement CrudReposistory to access MySql db
    * Along with annotations on UserProfile class with auto update database enabled on hibernate

#### 04-09-20
* More app settings
* Starting with connection to rds using annotations on objects using ORM
* improve API and figure out how to add validation (@valid)
* Rename Hello objects to UserProfile

#### 01-09-20
* Application properties using .yml file
* More work done on connecting to database
    * Use JDBC to create connection
        * Still want to create neat generic connection functions such as read and write
* Package rename

#### 31-08-20
* Get started with Travis CI
    * Add .travis.yml file
* Add information panel and useful links into README

#### 28-08-20
* Set up swagger ui