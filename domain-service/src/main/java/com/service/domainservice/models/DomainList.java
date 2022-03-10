package com.service.domainservice.models;

import java.util.List;
import java.util.Objects;

public class DomainList {
    public List<Domain> domains;
    
    public DomainList() {
    }

    public DomainList(List<Domain> domains) {
        this.domains = domains;
    }

    public List<Domain> getDomains() {
        return this.domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DomainList)) {
            return false;
        }
        DomainList domainList = (DomainList) o;
        return Objects.equals(domains, domainList.domains);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(domains);
    }

    @Override
    public String toString() {
        return "{" +
            " domains='" + getDomains() + "'" +
            "}";
    }
    

}

  
