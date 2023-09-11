@DataJpaTest
@Slf4j
public class JpaPjtApplicationTests {
    
    @Autowired
        UserRepository userRepository;

    @BeforeEach
    void insertTestData() {
        Users user = new Users();
        user.setUsername("kim ori");
        userRepository.save(user);
        
        user = new Users();
        user.setUsername("lee ori");
        userRepository.save(user);
        
        user = new Users();
        user.setUsername("kim ental");
        userRepository.save(user);
        
        user = new Users();
        user.setUsername("lee ental");
        userRepository.save(user);
        
        user = new Users();
        user.setUsername("kim samuel");
        userRepository.save(user);
    }

        @Test
        void findAllTest() {
            List<Users> userList = userRepository.findAll();
            for(Users u : userList) log.info("[FindAll] : " + u.getID() + " | " + u.getUserName());
        }

        @Test
        void find2ByNameTest() {
            List<Users> userList = userRepository.findFirst2ByUsernameLikeOrderByIDDesc("kim%");
            for(Users u : userList) log.info("[FindSome] : " + u.getID() + " | " + u.getUsername());
        }

}
