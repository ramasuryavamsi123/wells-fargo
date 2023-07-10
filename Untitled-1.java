import javax.persistence.*;

@Entity
public class FinancialAdvisor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long advisorId;
    private String name;
    private String email;
    private String password;

  
}

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    private String name;
    private String contactInformation;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private FinancialAdvisor advisor;

    
}

@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    
}

@Entity
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long securityId;
    private String name;
    private String category;

    
}

@Entity
@Table(name = "portfolio_security")
public class PortfolioSecurity {
    @EmbeddedId
    private PortfolioSecurityId id;

    @ManyToOne
    @MapsId("portfolioId")
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @MapsId("securityId")
    @JoinColumn(name = "security_id")
    private Security security;

    private String purchaseDate;
    private double purchasePrice;
    private int quantity;

    
}

@Embeddable
public class PortfolioSecurityId implements Serializable {
    private Long portfolioId;
    private Long securityId;

    
}
