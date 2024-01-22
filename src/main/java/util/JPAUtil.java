package util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManager ENTITY_MANAGER = buildEntityManager();

    private static EntityManager buildEntityManager() {
        return Persistence.createEntityManagerFactory("persistenceTest")
                .createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}

