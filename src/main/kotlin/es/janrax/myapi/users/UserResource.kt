package es.janrax.myapi.users

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("api/users")
class UserResource(private val userDaoService: UserDaoService) {

//    @GetMapping("")
    @RequestMapping(path = ["", "/"], method = [RequestMethod.GET])
    fun findAll(): List<User> {
        return userDaoService.findAll()
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Int): User {
        val user = userDaoService.findOne(id)
        return user ?: throw UserNotFoundException("user with id $id does not exist")
    }

    @PostMapping(path = ["","/"])
//    @RequestMapping(path = ["", "/"], method = [RequestMethod.POST])
    fun create(@Valid @RequestBody user: User): ResponseEntity<User> {
        val createdUser = userDaoService.save(user)
        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdUser.id)
            .toUri()

        return ResponseEntity.created(location).body(createdUser)
    }

//    @DeleteMapping("/{id")
    @RequestMapping("/{id}", method = [RequestMethod.DELETE])
    fun deleteById(@PathVariable id: Int): ResponseEntity<Void> {
        val userRemoved = userDaoService.deleteById(id)
        if (userRemoved != null) {
            return ResponseEntity.noContent().build()
        }
        throw UserNotFoundException("user with id $id does not exist")
    }


}
