@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    
    @GetMapping(value = "/users")
    public List<Users> getUsers( @RequestParam(required = false, defaultValue = "") String name ){
        return userService.getUsersService( name );
    }

    @PostMapping(value = "/user")
    public String createUser(@RequestBody Users user){
        return userService.createUserService(user);
    }
}
