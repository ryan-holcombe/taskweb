package com.honeydothis

import org.junit.Test
import org.junit.Ignore

class UserControllerTests extends grails.test.ControllerUnitTestCase
{
  def springSecurityService

  @Test
  @Ignore
  void testIndex()
  {
    controller.index()
    assert "/user/list" == response.redirectedUrl
  }

  @Test
  @Ignore
  void testList()
  {

    def model = controller.list()

    assert model.userInstanceList.size() == 0
    assert model.userInstanceTotal == 0

  }

  @Test
  @Ignore
  void testCreate()
  {
    def model = controller.create()

    assert model.userInstance != null

  }

  @Test
  void testSave()
  {
    mockDomain(User)
    controller.springSecurityService = [encodePassword: { String p, String u -> "encrypted" }]
    controller.save()

    assert model.userInstance != null
    assert view == '/user/create'

    def userRoleMock = mockFor(com.honeydothis.UserRole)
    userRoleMock.demand.static.create(1..1) { def u, def r -> new UserRole() }

//    mockDomain(com.honeydothis.UserRole)

    controller.params.firstName = 'firstName'
    controller.params.lastName = 'lastName'
    controller.params.username = 'noreply@example.com'
    controller.params.password = 'Password'
    controller.params.passwordConfirm = 'Password'
    controller.params.enabled = true
    controller.save()

    assert response.redirectedUrl == '/login/auth'
    assert controller.flash.message != null
    assert User.count() == 1
  }


  @Test
  @Ignore
  void testShow()
  {
    controller.show()

    assert flash.message != null
    assert response.redirectedUrl == '/user/list'


    def user = new User()

    // TODO: populate domain properties

    assert user.save() != null

    params.id = user.id

    def model = controller.show()

    assert model.userInstance == user
  }

  @Test
  @Ignore
  void testEdit()
  {
    controller.edit()

    assert flash.message != null
    assert response.redirectedUrl == '/user/list'


    def user = new User()

    // TODO: populate valid domain properties

    assert user.save() != null

    params.id = user.id

    def model = controller.edit()

    assert model.userInstance == user
  }

  @Test
  @Ignore
  void testUpdate()
  {

    controller.update()

    assert flash.message != null
    assert response.redirectedUrl == '/user/list'

    response.reset()


    def user = new User()

    // TODO: populate valid domain properties

    assert user.save() != null

    // test invalid parameters in update
    params.id = user.id

    controller.update()

    assert view == "/user/edit"
    assert model.userInstance != null

    user.clearErrors()

    // TODO: populate valid domain form parameter
    controller.update()

    assert response.redirectedUrl == "/user/show/$user.id"
    assert flash.message != null
  }

  @Test
  @Ignore
  void testDelete()
  {
    controller.delete()

    assert flash.message != null
    assert response.redirectedUrl == '/user/list'

    response.reset()

    def user = new User()

    // TODO: populate valid domain properties
    assert user.save() != null
    assert User.count() == 1

    params.id = user.id

    controller.delete()

    assert User.count() == 0
    assert User.get(user.id) == null
    assert response.redirectedUrl == '/user/list'

  }

}