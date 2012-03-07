import com.honeydothis.Role
import com.honeydothis.User
import com.honeydothis.UserRole
import org.codehaus.groovy.grails.commons.GrailsApplication
import grails.util.GrailsUtil

class BootStrap
{
  def springSecurityService
  def init = { servletContext ->

    if (GrailsUtil.environment == GrailsApplication.ENV_PRODUCTION)
    {
      def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
      def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

      def adminUser = User.findByUsername('admin') ?: new User(
        username: 'admin',
        password: springSecurityService.encodePassword('admin', 'admin'),
        firstName: 'admin',
        lastName: 'user',
        enabled: true).save(failOnError: true, validate: false)

      if (!UserRole.findByUserAndRole(adminUser, adminRole))
      {
        UserRole.create(adminUser, adminRole);
      }
    }

  }
  def destroy = {
  }
}
