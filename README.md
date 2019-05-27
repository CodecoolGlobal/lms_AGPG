# About

Codecool Learning Management System for a Maven managed dynamic web-application using Servlets and
JDBC.

## `DataSource`

Before deploying to a webserver create a `Resource` like in your webserver's config (e.g. for Apache Tomcat in `conf/context.xml`).

```
<Resource name="jdbc/lms_agpg"
          type="javax.sql.DataSource"
          username="postgres"
          password="admin"
          driverClassName="org.postgresql.Driver"
          url="jdbc:postgresql://localhost:5432/lms_agpg"
          closeMethod="close"/>
```

*Note*: the `closeMethod="close"` attribute is important. [As per Tomcat's documentation][1] this ensures that connections retrieved from the datasource are closed properly when a webapp context is reloaded/restarted/redeployed/etc.

[1]: https://tomcat.apache.org/tomcat-9.0-doc/config/context.html#Resource_Definitions

If you plan to use this repo as a "base" for one of your project change
`<artifactId>intellij-maven-quickstart-web</artifactId>` to reflect what you're
working on. E.g. `<artifactId>card-game-simulator-web-project</artifactId>` or
similar.
