1.Once you add, by default, all pages needed to be authenticated.
The default username is "user", the default password is displayed in console when start the application.
You can customized in application.properties file
spring.security.user.name=admin
spring.security.user.password=admin

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

2. java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
Prior to Spring Security 5.0 the default PasswordEncoder was NoOpPasswordEncoder which required plain text passwords.
In Spring Security 5, the default is DelegatingPasswordEncoder, which required Password Storage Format.

3.Thymeleaf will automatically add the CSRF token to our logout form.
If we were not using Thymleaf or Spring MVCs taglib we could also manually add the CSRF token using
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>.

4. loginPage("/login") instructs Spring Security

   when authentication is required, redirect the browser to /login

   we are in charge of rendering the login page when /login is requested

   when authentication attempt fails, redirect the browser to /login?error (since we have not specified otherwise)

   we are in charge of rendering a failure page when /login?error is requested

   when we successfully logout, redirect the browser to /login?logout (since we have not specified otherwise)

   we are in charge of rendering a logout confirmation page when /login?logout is requested


5.
This has several methods that we can use to configure the behavior of the form login:

loginPage() – the custom login page
loginProcessingUrl() – the url to submit the username and password to
defaultSuccessUrl() – the landing page after a successful login
failureUrl() – the landing page after an unsuccessful login

6. After add passwordEncoder bean, the NoopPasswordEncoder is disabled.

7.Disable CRSF (Cross-Site Request Forgery). By default, Spring Security will protect against CRSF attacks.
  Since the H2 database console runs inside a frame, you need to enable this in in Spring Security.

8. Access denied page
https://www.baeldung.com/spring-security-custom-access-denied-page

9. Remember Me
The Remember Me cookie contains the following data:

username – to identify the logged in principal
expirationTime – to expire the cookie; default is 2 weeks
MD5 hash – of the previous 2 values – username and expirationTime, plus the password and the predefined key