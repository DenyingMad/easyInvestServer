package com.cgpanda.EasyInvestServer.entity.Portfolio;

import com.cgpanda.EasyInvestServer.entity.Users.ApiKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @OneToMany(mappedBy = "portfolio")
    private Set<SecuritiesPortfolio> securitiesPortfolioSet;


    public Set<SecuritiesPortfolio> getSecuritiesPortfolioSet() {
        return securitiesPortfolioSet;
    }

    public void setSecuritiesPortfolioSet(Set<SecuritiesPortfolio> securitiesPortfolioSet) {
        this.securitiesPortfolioSet = securitiesPortfolioSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
