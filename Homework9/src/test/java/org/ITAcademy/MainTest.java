package org.ITAcademy;

import org.ITAcademy.utilites.HibernateUtil;
import org.junit.jupiter.api.AfterAll;

public class MainTest {
    @AfterAll
    public static void close() {
        HibernateUtil.closeFactory();
    }
}
