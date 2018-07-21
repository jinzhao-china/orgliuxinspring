package org.liuxin.services;

import org.liuxin.dao.*;

/**
 * Created by zjin010 on 6/11/18.
 */
public class PetStoreService {
    private AccountDao accountDao;
    private ItemDao  itemDao;
    private String owner;
    private int version;

    public PetStoreService(AccountDao accountDao, ItemDao itemDao){
        this.accountDao = accountDao;
        this.itemDao = itemDao;
        this.version = -1;
    }
    public PetStoreService(AccountDao accountDao, ItemDao itemDao,int version){
        this.accountDao = accountDao;
        this.itemDao = itemDao;
        this.version = version;
    }
    public int getVersion() {
        return version;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
