/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.PolicyService;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class PolicyServiceDAO extends BaseDAO {

    private final static Logger LOGGER = Logger.getLogger(PolicyServiceDAO.class
            .getName());
    
    public PolicyService getById(Long id) throws DAOException {
        Object o = super.getById(id, PolicyService.class);
        if (o instanceof PolicyService) {
            return (PolicyService) o;
        } else {
            String msg = "Problem in reading PolicyService from Database";
            LOGGER.log(Level.SEVERE, msg);
            throw new DAOException(msg);
        }
    }

}
