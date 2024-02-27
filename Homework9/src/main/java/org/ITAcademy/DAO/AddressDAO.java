package org.ITAcademy.DAO;

import org.ITAcademy.entities.Address;

public interface AddressDAO extends DAO<Address> {
    Address increaseHomeNum(int id, int increment);
}
