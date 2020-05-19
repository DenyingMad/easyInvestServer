package com.cgpanda.EasyInvestServer.entity.Portfolio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "securities")
public class Securities {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @OneToMany(mappedBy = "securities")
    private Set<SecuritiesPortfolio> securitiesPortfolioSet;

    @Column(name = "secid")
    private String secid;

    @Column(name = "boardid")
    private String boardid;

    @Column(name = "market")
    private String market;

    @JsonIgnore
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

    public String getSecid() {
        return secid;
    }

    public void setSecid(String secid) {
        this.secid = secid;
    }

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
        this.boardid = boardid;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

}
