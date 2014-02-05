WELCOME TO THIS SAMPLE SECURE SITE

Requirements:
  - CAS server configured and running (http://www.jasig.org/cas)
  - gradle installed (http://www.gradle.org/)

This web application was developed using Java, Gradle and Spring Security and shows how to integrate an application with CAS (Central Autentication Service). 
To run the application we can use the embedded Jetty gradle plug-in.

Before proceed you have to inform your CAS configuration in security.properties file:

security.cas.service.url=https://<YOUR_SERVER>/cas
security.cas.service.login.url=https://<YOUR_SERVER>/cas/login
security.cas.service.logout.url=https://<YOUR_SERVER>/cas/logout

Type in the console:

$ gradle clean jettyRun
The webserver will be started and application deployed, everything should be up and running on port 9090. The port can be configured in build.gradle file.

 :clean 
 :compileJava 
 :jettyRun 
 > Building 80% > :jettyRun > Running at http://localhost:9090/secure-site

Enjoy,

J.P.E Kimura
eiti.kimura@movile.com
