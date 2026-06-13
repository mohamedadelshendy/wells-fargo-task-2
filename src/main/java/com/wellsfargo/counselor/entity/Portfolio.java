package com.wellsfargo.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(Client client, List<Security> securities) {
        this.client = client;
        this.securities = securities;
    }

    public Long getId() { return id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
