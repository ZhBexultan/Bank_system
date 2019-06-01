package com.myspring.controllers;

import com.myspring.beans.DBBean;
import com.myspring.entities.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    DBBean dbBean;

    @RequestMapping(value = {"/auth", "/"}, method = RequestMethod.GET)
    public ModelAndView enter() {
        ModelAndView mw = new ModelAndView("login");
        return mw;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDeniedPage() {
        ModelAndView mw = new ModelAndView("403");
        return mw;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        Users user = getUserData();
        Set<Roles> roles = user.getRoles();
        ArrayList<Bank_total_balance> bankTotalBalance = (ArrayList<Bank_total_balance>)dbBean.getBankTotalBalance();
        ArrayList<Currency_exchange> currency_exchange= (ArrayList<Currency_exchange>)dbBean.getLastChangedValue();

        ModelAndView mw = new ModelAndView("manager_main_page");
        boolean isAdmin = false;
        for (Roles r : roles) {
            if (r.getId() == 1) {
                isAdmin = true;
                break;
            }
        }
        if (isAdmin) {
            mw = new ModelAndView("admin_main_page");
            mw.addObject("user", user);
        }
        mw.addObject("user", user);
        mw.addObject("bank_total_balance", bankTotalBalance);
        mw.addObject("currency_exchange", currency_exchange);
        return mw;
    }

    @RequestMapping(value = "/admin_managers", method = RequestMethod.GET)
    public ModelAndView adminManagers() {
        ArrayList<Users> managers = (ArrayList<Users>) dbBean.getManagers();
        ModelAndView mw = new ModelAndView("admin_managers");
        mw.addObject("managers", managers);
        return mw;
    }

    @RequestMapping(value = "/admin_change_currency", method = RequestMethod.GET)
    public ModelAndView adminChangeCurrency(@RequestParam(name = "id") Long id) {
        Currency_exchange currency_exchange = dbBean.getCurrencyExchangeById(id);
        ModelAndView mw = new ModelAndView("admin_change_currency");
        mw.addObject("currency_exchange", currency_exchange);
        return mw;
    }

    @RequestMapping(value = "/manager_change_account", method = RequestMethod.GET)
    public ModelAndView managerChangeAccount(@RequestParam(name = "id") Long id) {
        Accounts account = dbBean.getAccountById(id);
        ModelAndView mw = new ModelAndView("manager_change_account");
        mw.addObject("account", account);
        return mw;
    }

    @RequestMapping(value = "/admin_transactions", method = RequestMethod.GET)
    public ModelAndView adminTransactions() {
        ArrayList<Transaction_histories> transactions = (ArrayList<Transaction_histories>)dbBean.getTransactions();
        ModelAndView mw = new ModelAndView("admin_transactions");
        mw.addObject("transactions", transactions);
        return mw;
    }

    @RequestMapping(value = "/admin_currencies", method = RequestMethod.GET)
    public ModelAndView adminCurrencies() {
        ArrayList<Currency_exchange> currency_exchange= (ArrayList<Currency_exchange>)dbBean.getLastChangedValue();
        ModelAndView mw = new ModelAndView("admin_currencies");
        mw.addObject("currency_exchange", currency_exchange);
        return mw;
    }

    @RequestMapping(value = "/manager_accounts", method = RequestMethod.GET)
    public ModelAndView managerAccounts() {
        ArrayList<Accounts> accounts = (ArrayList<Accounts>) dbBean.getAccounts();
        ArrayList<Currencies> currencies = (ArrayList<Currencies>) dbBean.getCurrencies();
        ModelAndView mw = new ModelAndView("manager_accounts");
        mw.addObject("accounts", accounts);
        mw.addObject("currencies", currencies);
        return mw;
    }

    @RequestMapping(value = "/manager_transactions", method = RequestMethod.GET)
    public ModelAndView managerTransactions() {
        Users manager = getUserData();
        ArrayList<Currencies> currencies = (ArrayList<Currencies>)dbBean.getCurrencies();
        ArrayList<Accounts> accounts = (ArrayList<Accounts>)dbBean.getAccounts();
        ArrayList<Operations> operations = (ArrayList<Operations>) dbBean.getOperations();
        ArrayList<Transaction_histories> manager_transactions = (ArrayList<Transaction_histories>)dbBean.getManagerTransactions(manager.getId());
        ModelAndView mw = new ModelAndView("manager_transactions");
        mw.addObject("accounts", accounts);
        mw.addObject("currencies", currencies);
        mw.addObject("operations", operations);
        mw.addObject("manager_transactions", manager_transactions);
        return mw;
    }

    @RequestMapping(value = "/manager_transactions_transfer", method = RequestMethod.GET)
    public ModelAndView managerTransactionsTransfer() {
        Users manager = getUserData();
        ArrayList<Currencies> currencies = (ArrayList<Currencies>)dbBean.getCurrencies();
        ArrayList<Accounts> accounts = (ArrayList<Accounts>)dbBean.getAccounts();
        ArrayList<Operations> operations = (ArrayList<Operations>) dbBean.getOperations();
        ArrayList<Transaction_histories> manager_transactions = (ArrayList<Transaction_histories>)dbBean.getManagerTransactions(manager.getId());
        ModelAndView mw = new ModelAndView("transaction_transfer");
        mw.addObject("accounts", accounts);
        mw.addObject("currencies", currencies);
        mw.addObject("operations", operations);
        mw.addObject("manager_transactions", manager_transactions);
        return mw;
    }

    @RequestMapping(value = "/manager_transactions_exchange", method = RequestMethod.GET)
    public ModelAndView managerTransactionsExchange() {
        Users manager = getUserData();
        ArrayList<Currencies> currencies = (ArrayList<Currencies>)dbBean.getCurrencies();
        ArrayList<Accounts> accounts = (ArrayList<Accounts>)dbBean.getAccounts();
        ArrayList<Operations> operations = (ArrayList<Operations>) dbBean.getOperations();
        ArrayList<Transaction_histories> manager_transactions = (ArrayList<Transaction_histories>)dbBean.getManagerTransactions(manager.getId());
        ModelAndView mw = new ModelAndView("transaction_exchange");
        mw.addObject("accounts", accounts);
        mw.addObject("currencies", currencies);
        mw.addObject("operations", operations);
        mw.addObject("manager_transactions", manager_transactions);
        return mw;
    }

    @RequestMapping(value = "/manager_transactions_debet", method = RequestMethod.GET)
    public ModelAndView managerTransactionsDebet() {
        Users manager = getUserData();
        ArrayList<Currencies> currencies = (ArrayList<Currencies>)dbBean.getCurrencies();
        ArrayList<Accounts> accounts = (ArrayList<Accounts>)dbBean.getAccounts();
        ArrayList<Operations> operations = (ArrayList<Operations>) dbBean.getOperations();
        ArrayList<Transaction_histories> manager_transactions = (ArrayList<Transaction_histories>)dbBean.getManagerTransactions(manager.getId());
        ModelAndView mw = new ModelAndView("transaction_debet");
        mw.addObject("accounts", accounts);
        mw.addObject("currencies", currencies);
        mw.addObject("operations", operations);
        mw.addObject("manager_transactions", manager_transactions);
        return mw;
    }

    @RequestMapping(value = "/manager_transactions_credit", method = RequestMethod.GET)
    public ModelAndView managerTransactionsCredit() {
        Users manager = getUserData();
        ArrayList<Currencies> currencies = (ArrayList<Currencies>)dbBean.getCurrencies();
        ArrayList<Accounts> accounts = (ArrayList<Accounts>)dbBean.getAccounts();
        ArrayList<Operations> operations = (ArrayList<Operations>) dbBean.getOperations();
        ArrayList<Transaction_histories> manager_transactions = (ArrayList<Transaction_histories>)dbBean.getManagerTransactions(manager.getId());
        ModelAndView mw = new ModelAndView("transaction_credit");
        mw.addObject("accounts", accounts);
        mw.addObject("currencies", currencies);
        mw.addObject("operations", operations);
        mw.addObject("manager_transactions", manager_transactions);
        return mw;
    }

    @RequestMapping(value = "/add_manager", method = RequestMethod.POST)
    public String addManager(@RequestParam(name = "user_fullname") String user_fullname,
                             @RequestParam(name = "user_login") String user_login,
                             @RequestParam(name = "user_password") String user_password){
        Set<Roles> role = new HashSet<>();
        role.add(new Roles(2L, "ROLE_MANAGER"));
        dbBean.addObject(new Users(user_login, DigestUtils.shaHex(user_password), user_fullname, role));
        return "redirect:admin_managers";
    }

    @RequestMapping(value = "/add_account", method = RequestMethod.POST)
    public String addAccount(@RequestParam(name = "account_first_name") String account_first_name,
                             @RequestParam(name = "account_last_name") String account_last_name,
                             @RequestParam(name = "account_iin_number") String account_iin_number,
                             @RequestParam(name = "account_birth_date") java.sql.Date account_birth_date,
                             @RequestParam(name = "account_currency") Long account_currency_id){
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String name = "KZ01682";
        long number = (long) Math.floor(Math.random() * 9000000000000L) + 1000000000000L;
        name+=number;
        Currencies currency = dbBean.getCurrencyById(account_currency_id);
        dbBean.addObject(new Accounts(name, account_first_name, account_last_name, account_birth_date,account_iin_number, currency, 0, sqlDate,false));
        return "redirect:manager_accounts";
    }

    @RequestMapping(value = "/update_account", method = RequestMethod.POST)
    public String updateAccount(@RequestParam(name = "account_first_name") String account_first_name,
                             @RequestParam(name = "account_last_name") String account_last_name,
                             @RequestParam(name = "account_iin_number") String account_iin_number,
                             @RequestParam(name = "account_is_blocked") boolean is_blocked,
                             @RequestParam(name = "account_id") Long account_id){
        Accounts account = dbBean.getAccountById(account_id);
        dbBean.updateObject(new Accounts(account.getId(),account.getName(), account_first_name, account_last_name, account.getBirth_date(),account_iin_number, account.getCurrencies(), account.getAmount(), account.getCreated_date(),is_blocked));
        return "redirect:manager_accounts";
    }

    @RequestMapping(value = "/add_currency_exchange", method = RequestMethod.POST)
    public String addCurrencyExchange(@RequestParam(name = "currency_sale_value") double sale_value,
                                      @RequestParam(name = "currency_purchase_value") double purchase_value,
                                      @RequestParam(name = "currency_id") Long currency_id){
        Date date = new Date();
        Timestamp sqlDate= new Timestamp(date.getTime());
        Currencies currency = dbBean.getCurrencyById(currency_id);
        dbBean.addObject(new Currency_exchange(currency, purchase_value, sale_value, sqlDate));
        return "redirect:admin_currencies";
    }

    @RequestMapping(value = "/add_transaction_transfer", method = RequestMethod.POST)
    public String addTransactionTransfer(@RequestParam(name = "sender") Long sender_id,
                                      @RequestParam(name = "receiver") Long receiver_id,
                                      @RequestParam(name = "amount") double amount){
        Users manager = getUserData();
        Operations operation = dbBean.getOperationById(1L);
        Accounts sender = dbBean.getAccountById(sender_id);
        Accounts receiver = dbBean.getAccountById(receiver_id);
        if(sender.getCurrencies().getId().equals(receiver.getCurrencies().getId())){
            Bank_total_balance bank_total_balance = dbBean.getBankTotalBalanceByCurrencyId(sender.getCurrencies().getId());
            bank_total_balance.setValue(bank_total_balance.getValue()+(amount*0.05));
            sender.setAmount(sender.getAmount()-amount);
            receiver.setAmount(receiver.getAmount()+amount*(1-0.05));
            dbBean.updateObject(sender);
            dbBean.updateObject(receiver);
            dbBean.updateObject(bank_total_balance);
        }else{
            return "redirect:manager_transactions_transfer?error=1";
        }
        Date date = new Date();
        Timestamp sqlDate= new Timestamp(date.getTime());
        dbBean.addObject(new Transaction_histories(manager, sender, receiver, operation, null, amount, sqlDate));
        return "redirect:manager_transactions";
    }

    @RequestMapping(value = "/add_transaction_exchange", method = RequestMethod.POST)
    public String addTransactionExchange(@RequestParam(name = "currency") Long currency_id,
                                         @RequestParam(name = "amount") double amount,
                                         @RequestParam(name = "exchange") String exchange){
        Users manager = getUserData();
        ArrayList<Currency_exchange> currency_exchanges = (ArrayList<Currency_exchange>) dbBean.getLastChangedValue();
        Currency_exchange currency = new Currency_exchange();
        for (Currency_exchange c: currency_exchanges) {
            if(c.getCurrencies().getId()==currency_id)
                currency=c;
        }
        Bank_total_balance bank_total_balance_tenge = dbBean.getBankTotalBalanceByCurrencyId(1L);
        Bank_total_balance bank_total_balance_other = dbBean.getBankTotalBalanceByCurrencyId(currency_id);
        if(exchange.equals("tenge alu")){
            bank_total_balance_other.setValue(bank_total_balance_other.getValue()+amount);
            bank_total_balance_tenge.setValue(bank_total_balance_tenge.getValue()-amount*currency.getPurchase_value());
            dbBean.updateObject(bank_total_balance_other);
            dbBean.updateObject(bank_total_balance_tenge);
        }else if(exchange.equals("tenge beru")){
            bank_total_balance_other.setValue(bank_total_balance_other.getValue()-(amount/currency.getPurchase_value()));
            bank_total_balance_tenge.setValue(bank_total_balance_tenge.getValue()+amount);
            dbBean.updateObject(bank_total_balance_other);
            dbBean.updateObject(bank_total_balance_tenge);
        }
        Operations operation = dbBean.getOperationById(2L);
        Date date = new Date();
        Timestamp sqlDate= new Timestamp(date.getTime());
        dbBean.addObject(new Transaction_histories(manager, null, null, operation, currency.getCurrencies(), amount, sqlDate));
        return "redirect:manager_transactions";
    }

    @RequestMapping(value = "/add_transaction_debet", method = RequestMethod.POST)
    public String addTransactionDebet(@RequestParam(name = "receiver") Long receiver_id,
                                 @RequestParam(name = "amount") double amount){
        Users manager = getUserData();
        Operations operation = dbBean.getOperationById(3L);
        Accounts receiver = dbBean.getAccountById(receiver_id);
        Currencies currencies = dbBean.getCurrencyById(receiver.getCurrencies().getId());
        Bank_total_balance bank_total_balance = dbBean.getBankTotalBalanceByCurrencyId(receiver.getCurrencies().getId());
        bank_total_balance.setValue(bank_total_balance.getValue()+(amount*0.01));
        receiver.setAmount(receiver.getAmount()+(amount*0.99));
        dbBean.updateObject(bank_total_balance);
        dbBean.updateObject(receiver);
        Date date = new Date();
        Timestamp sqlDate= new Timestamp(date.getTime());
        dbBean.addObject(new Transaction_histories(manager, null, receiver, operation, currencies, amount, sqlDate));
        return "redirect:manager_transactions";
    }

    @RequestMapping(value = "/add_transaction_credit", method = RequestMethod.POST)
    public String addTransactionCredit(@RequestParam(name = "sender") Long sender_id,
                                 @RequestParam(name = "amount") double amount){
        Accounts sender = dbBean.getAccountById(sender_id);
        if(sender.getAmount()>=amount) {

            Users manager = getUserData();
            Operations operation = dbBean.getOperationById(4L);
            Currencies currencies = dbBean.getCurrencyById(sender.getCurrencies().getId());
            Bank_total_balance bank_total_balance = dbBean.getBankTotalBalanceByCurrencyId(sender.getCurrencies().getId());
            bank_total_balance.setValue(bank_total_balance.getValue()+amount*0.01);
            sender.setAmount(sender.getAmount()-amount);
            Date date = new Date();
            Timestamp sqlDate = new Timestamp(date.getTime());
            dbBean.updateObject(bank_total_balance);
            dbBean.updateObject(sender);
            dbBean.addObject(new Transaction_histories(manager, sender, null, operation, currencies, amount, sqlDate));
        }
        return "redirect:manager_transactions";
    }


    public Users getUserData() {
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails ud = (UserDetails) authentication.getPrincipal();
            user = dbBean.getUser(ud.getUsername());
        }
        return user;
    }
}
