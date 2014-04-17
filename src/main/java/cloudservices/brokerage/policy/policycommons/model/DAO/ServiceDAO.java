/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Service;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            return (Service) o;
        } else {
            String msg = "Problem in reading service from Database";
            LOGGER.log(Level.SEVERE, msg);
            throw new DAOException(msg);
        }
    }
    
}
