@Entity
@Getter
@Setter
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String username;
}
