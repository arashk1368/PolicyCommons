/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.ServiceProposition;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class ServicePropositionDAO extends BaseDAO {

    private final static Logger LOGGER = Logger.getLogger(ServicePropositionDAO.class
            .getName());

    public ServiceProposition getById(Long id) throws DAOException {
        Object o = super.getById(id, ServiceProposition.class);
        if (o instanceof ServiceProposition) {
            return (ServiceProposition) o;
        } else {
            String msg = "Problem in reading ServiceProposition from Database";
            LOGGER.log(Level.SEVERE, msg);
            throw new DAOException(msg);
        }
    }

    public Serializable save(ServiceProposition entity) throws DAOException {
        return super.save(entity);
    }
}
