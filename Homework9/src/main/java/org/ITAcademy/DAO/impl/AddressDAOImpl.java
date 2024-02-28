package org.ITAcademy.DAO.impl;

import org.ITAcademy.DAO.AddressDAO;
import org.ITAcademy.entities.Address;

public class AddressDAOImpl extends DAOImpl<Address> implements AddressDAO {
    @Override
    protected Class<Address> getClazz() {
        return Address.class;
    }

    @Override
    public Address increaseHomeNum(int id, int increment) {
        Address address = transactionHelper.find(getClazz(), id);
        address.setHouseNum(address.getHouseNum() + increment);
        transactionHelper.begin();
        try {
            transactionHelper.merge(address);
            transactionHelper.commit();
        } catch (Exception e) {
            transactionHelper.rollback();
            e.printStackTrace();
            return null;
        }
        return address;
    }
}
