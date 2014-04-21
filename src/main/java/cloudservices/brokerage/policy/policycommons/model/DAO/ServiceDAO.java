/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class ServiceDAO extends BaseDAO {

    private final static Logger LOGGER = Logger.getLogger(ServiceDAO.class
            .getName());

    public Service getById(Long id) throws DAOException {
        Object o = super.getById(id, Service.class);
        if (o instanceof Service) {
            Service service = (Service) o;
            return service;
        } else {
            String msg = "Problem in reading service from Database";
            LOGGER.log(Level.SEVERE, msg);
            throw new DAOException(msg);
        }
    }

    public Service getByName(String name) throws DAOException {
        Query query = super.getSession().createQuery("from Service where name = :para1 ");
        query.setParameter("para1", name);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else {
            return (Service) list.get(0);
        }

    }
}
