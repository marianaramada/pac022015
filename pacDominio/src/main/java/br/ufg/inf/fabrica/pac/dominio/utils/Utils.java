<<<<<<< HEAD:pacDominio/src/main/java/br/ufg/inf/fabrica/pac/dominio/utils/Utils.java
package br.ufg.inf.fabrica.pac.dominio.utils;

/**
 *
 * @author Danillo
 */
public class Utils {

    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.util.Date convertSqlDateToUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }
    
    //auf
    public static boolean stringVaziaOuNula(String value) {
        return value == null || value.isEmpty();
    }
}
=======
package br.ufg.inf.fabrica.pac.dominio.utils;

/**
 *
 * @author Danillo
 */
public class Utils {

    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static java.util.Date convertSqlDateToUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }
    
    //auf
    public static boolean stringVaziaOuNula(String value) {
        return value == null || value.isEmpty();
    }
}
>>>>>>> d77ba0f622a74685e9519f29068bd70b23c771f4:pacDominio/src/main/java/br/ufg/inf/fabrica/pac/dominio/utils/Utils.java
