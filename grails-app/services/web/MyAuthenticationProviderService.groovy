package web

import com.honeydothis.User
import com.honeydothis.UserRole
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.GrantedAuthorityImpl

class MyAuthenticationProviderService implements AuthenticationProvider
{
  def springSecurityService

  Authentication authenticate(Authentication authenticationIn)
  {
    String username = authenticationIn.principal
    String password = springSecurityService.encodePassword(authenticationIn.credentials, username)

    User user = User.findByUsernameAndPassword(username, password);
    if (user != null)
    {
      def roles = []
      UserRole.findAllByUser(user).each { UserRole userRole ->
        roles << new GrantedAuthorityImpl(userRole.role.authority)
      }
      return new UsernamePasswordAuthenticationToken(user, password, roles);
    }

    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  boolean supports(Class<? extends Object> classIn)
  {
    UsernamePasswordAuthenticationToken.isAssignableFrom(classIn);
  }
}
