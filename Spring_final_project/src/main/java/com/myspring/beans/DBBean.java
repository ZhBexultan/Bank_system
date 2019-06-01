package com.myspring.beans;

import com.myspring.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DBBean {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addObject(Object object){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    public void deleteObject(Object object){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

    public void updateObject(Object object ){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    public List<Bank_total_balance> getBankTotalBalance(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Bank_total_balance> query = criteriaBuilder.createQuery(Bank_total_balance.class);
        Root<Bank_total_balance> root = query.from(Bank_total_balance.class);
        List<Bank_total_balance> bankTotalBalance = session.createQuery(query).getResultList();
        session.close();
        return bankTotalBalance;
    }

    public List<Users> getManagers(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        List<Users> managers = session.createQuery(query).getResultList();
        session.close();
        return managers;
    }

    public List<Transaction_histories> getTransactions(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Transaction_histories> query = criteriaBuilder.createQuery(Transaction_histories.class);
        Root<Transaction_histories> root = query.from(Transaction_histories.class);
        List<Transaction_histories> transactions = session.createQuery(query).getResultList();
        session.close();
        return transactions;
    }

    public List<Accounts> getAccounts(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Accounts> query = criteriaBuilder.createQuery(Accounts.class);
        Root<Accounts> root = query.from(Accounts.class);
        List<Accounts> accounts = session.createQuery(query).getResultList();
        session.close();
        return accounts;
    }

    public List<Operations> getOperations(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Operations> query = criteriaBuilder.createQuery(Operations.class);
        Root<Operations> root = query.from(Operations.class);
        List<Operations> operations = session.createQuery(query).getResultList();
        session.close();
        return operations;
    }

    public List<Currencies> getCurrencies(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Currencies> query = criteriaBuilder.createQuery(Currencies.class);
        Root<Currencies> root = query.from(Currencies.class);
        List<Currencies> currencies = session.createQuery(query).getResultList();
        session.close();
        return currencies;
    }

/*    public List<Currency_exchange> getCurrencyExchange(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Currency_exchange> query = criteriaBuilder.createQuery(Currency_exchange.class);
        Root<Currency_exchange> root = query.from(Currency_exchange.class);
        List<Currency_exchange> currency_exchange = session.createQuery(query).getResultList();
        session.close();
        return currency_exchange;
    }*/

    public Operations getOperationById(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Operations> query = criteriaBuilder.createQuery(Operations.class);
        Root<Operations> root = query.from(Operations.class);
        Operations operation = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return operation;
    }

    public Bank_total_balance getBankTotalBalanceByCurrencyId(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Bank_total_balance> query = criteriaBuilder.createQuery(Bank_total_balance.class);
        Root<Bank_total_balance> root = query.from(Bank_total_balance.class);
        Bank_total_balance bank_balance = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return bank_balance;
    }

    public Currencies getCurrencyById(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Currencies> query = criteriaBuilder.createQuery(Currencies.class);
        Root<Currencies> root = query.from(Currencies.class);
        Currencies currency = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return currency;
    }

    public Currency_exchange getCurrencyExchangeById(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Currency_exchange> query = criteriaBuilder.createQuery(Currency_exchange.class);
        Root<Currency_exchange> root = query.from(Currency_exchange.class);
        Currency_exchange currency_exchange = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return currency_exchange;
    }

    public Accounts getAccountById(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Accounts> query = criteriaBuilder.createQuery(Accounts.class);
        Root<Accounts> root = query.from(Accounts.class);
        Accounts account = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return account;
    }

    public List<Users> getAllUsers() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        List<Users> allUsers = session.createQuery(query).getResultList();
        session.close();
        return allUsers;
    }

/*
    public Users getUser(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        Users users = session.createQuery(query.where(criteriaBuilder.equal(root.get("id"), id))).getSingleResult();
        session.close();
        return users;
    }
*/

    public List<Transaction_histories> getManagerTransactions(Long id){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Transaction_histories> query = criteriaBuilder.createQuery(Transaction_histories.class);
        Root<Transaction_histories> root = query.from(Transaction_histories.class);
        List<Transaction_histories> manager_transactions = session.createQuery((query.where(criteriaBuilder.equal(root.get("manager_id"), id)))).getResultList();
        session.close();
        return manager_transactions;
    }

    public List<Currency_exchange> getLastChangedValue(){
        List<Currency_exchange> curs=new ArrayList<>();
        Session session=sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
        CriteriaQuery<Currency_exchange> criteriaQuery=criteriaBuilder.createQuery(Currency_exchange.class);
        Root root=criteriaQuery.from(Currency_exchange.class);

        for (int i=2; i<7;i++){
            Long i1=Long.valueOf(i);
            Currencies currencies=getCurrencyById(i1);
            Predicate predicate=criteriaBuilder.equal(root.get("currencies"),currencies);
            List<Currency_exchange> cur=session.createQuery(criteriaQuery.where(predicate).orderBy(criteriaBuilder.desc(root.get("assigned_time")))).list();
            curs.add(cur.get(0));
            cur=null;
        }

        return curs;
    }

    public Users getUser(String login) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Users> query = criteriaBuilder.createQuery(Users.class);
        Root<Users> root = query.from(Users.class);
        Users users = session.createQuery(query.where(criteriaBuilder.equal(root.get("login"), login))).getSingleResult();
        session.close();
        return users;
    }

}
