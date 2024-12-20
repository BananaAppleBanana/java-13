package week4;

/**
 * 1. Authentication : verify user identity
 *      username, password / email / ...
 * 2. Authorization : role verification
 *      JWT token  (json web token)
 *      header.payload.signature
 *      header.payload.encrypt(header.payload)
 *
 *      OAuth2.0
 *      implicit flow
 *      1. user -> visit endpoint /students -> redirected to /login
 *      2. user login -> get a token from server
 *      3. user revisit /students with token
 *
 *      explicit flow
 *          browser      ---        3rd party app
 *           |
 *          your app
 *      1. user -> visit endpoint / students -> redirected to 3rd party login page
 *      2. after login, 3rd party app -> give you a redirect link / endpoint (contains access token / temporary token)
 *      3. send access token to your app
 *      4. your app bring access token + client id + client secret  -> get a token back
 *      5. save token / generate a jwt to user
 *
 *
 *
 * 3. HTTPS
 * 4  CSRF
 * 5. CORS
 *      whitelist (domain,endpoint , http method)
 *      www.yy.com   ---preflight request-->  www.xx.com
 *                   <-  list ---
 *                   -------bring list --->
 * 6. DDOS
 *
 *      -->  request -> cache(CDN) ->   app
 *                         |
 *                    edge location
 *     *        *         *    *    *    *    *    *    *    *    *    *    *    *
 *  Filter
 *  -> request -> filter -> filter -> dispatcher servlet -> handler mapping -> controller
 *
 *      pre filter logic
 *      chain.doFilter();
 *      post filter logic
 *     *        *         *    *    *    *    *    *    *    *    *    *    *    *
 *  Spring Security(filter)
 *  1. Authentication Manager : central controller of sprign security
 *  2. Filter : filter chains in spring security
 *      UsernamePasswordAuthenticationFilter
 *      ..
 *  3. Provider : identity verification
 *      DAOAuthenticationProvider
 *  4. UserDetails / UserDetailsService : user info pojo / user info repository layer
 *     *        *         *    *    *    *    *    *    *    *    *    *    *    *
 *  How to create Spring Security
 *  Authentication
 *  1. impl UserDetails
 *  2. impl UserDetailsService
 *  3. configure Authentication Manager
 *  4. configure authenticate path
 *  5. write your customized UsernamePasswordAuthenticationJsonFilter
 *  6. replace UsernamePasswordAuthenticationFilter with your UsernamePasswordAuthenticationJsonFilter
 *  7. implements AuthenticationSuccessHandler to handle success response
 *
 *  Authentication
 *  1. impl UserDetails
 *  2. impl UserDetailsService
 *  3. configure Authentication Manager
 *  4. configure authenticate path
 *  5. write /auth/login in your controller
 *      inject AuthenticationManager
 *      get user info from request body
 *      AuthenticationManager.authenticate(user info)
 *      return ..
 *
 *
 *  Authorization
 *  1. configure token dependency / utility
 *  2. create JWTFilter
 *          read jwt token from header
 *          use utility to verify this jwt
 *          save user info in SecurityContext(ThreadLocal)
 *          chain.doFilter()
 *  3. @PreAuthorize("hasRole['admin']")
 *     public void functions() {
 *
 *     }
 */