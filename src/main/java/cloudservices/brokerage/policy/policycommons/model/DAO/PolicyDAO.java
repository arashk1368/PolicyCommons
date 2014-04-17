/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Policy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class PolicyDAO extends BaseDAO {

    private final static Logger LOGGER = Logger.getLogger(PolicyDAO.class
            .getName());

    public Policy getById(Long id) throws DAOException {
        Object o = super.getById(id, Policy.class);
        if (o instanceof Policy) {
            Policy policy = (Policy) o;
            return policy;
        } else {
            String msg = "Problem in reading policy from Database";
            LOGGER.log(Level.SEVERE, msg);
            throw new DAOException(msg);
        }
    }
}
