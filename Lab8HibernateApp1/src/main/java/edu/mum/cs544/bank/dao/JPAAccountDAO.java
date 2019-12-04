package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.AccountEntry;
import edu.mum.cs544.bank.domain.Customer;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;
import java.util.Collection;

public class JPAAccountDAO implements IAccountDAO {

    @Override
    public void saveAccount(Account account) {
        System.out.println("JPAAccountDAO: saving account with accountnr ="+account.getAccountnumber());
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("JPAAccountDAO: update account with accountnr ="+account.getAccountnumber());
        EntityManager em = EntityManagerHelper.getCurrent();
        Account accountexist = loadAccount(account.getAccountnumber());
        if (accountexist != null) {
            em.persist(account);
        }
    }

    @Override
    public Account loadAccount(long accountnumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        return em.find(Account.class, accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
//        TypedQuery<Account> query = em.createQuery("from Account", Account.class);
//        return query.getResultList();
//        return em.createQuery("select distinct a from Account a join fetch a.entryList", Account.class).getResultList();
        EntityGraph<Account> graph = em.createEntityGraph(Account.class);
        graph.addAttributeNodes("accountnumber");
        Subgraph<AccountEntry> graph1 = graph.addSubgraph("entryList");
                graph1.addAttributeNodes("date");
                graph1.addAttributeNodes("amount");
                graph1.addAttributeNodes("description");
                graph1.addAttributeNodes("fromAccountNumber");
                graph1.addAttributeNodes("fromPersonName");

        TypedQuery<Account> query2 = em.createQuery("from Account", Account.class);
        query2.setHint("javax.persistence.fetchgraph", graph);
        return query2.getResultList();
    }
}
