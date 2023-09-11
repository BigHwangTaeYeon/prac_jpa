@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    List<Users> findFirst2ByUsernameLikeOrderByIDDesc(String name);

}
