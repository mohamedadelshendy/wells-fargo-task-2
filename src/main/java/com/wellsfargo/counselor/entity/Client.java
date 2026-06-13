package com.wellsfargo.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor financialAdvisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Portfolio portfolio;

    public Client() {}

    public Client(String firstName, String lastName, String email, FinancialAdvisor financialAdvisor, Portfolio portfolio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.financialAdvisor = financialAdvisor;
        this.portfolio = portfolio;
    }

    public Long getId() { return id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public FinancialAdvisor getFinancialAdvisor() { return financialAdvisor; }
    public void setFinancialAdvisor(FinancialAdvisor financialAdvisor) { this.financialAdvisor = financialAdvisor; }

    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
