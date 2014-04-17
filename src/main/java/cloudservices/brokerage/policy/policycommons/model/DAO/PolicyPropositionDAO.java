/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.PolicyProposition;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class PolicyPropositionDAO extends BaseDAO {

    private final static Logger LOGGER = Logger.getLogger(PolicyPropositionDAO.class
            .getName());

    public PolicyProposition getById(Long id) throws DAOException {
        Object o = super.getById(id, PolicyProposition.class);
        if (o instanceof PolicyProposition) {
            return (PolicyProposition) o;
        } else {
            String msg = "Problem in reading PolicyProposition from Database";
            LOGGER.log(Level.SEVERE, msg);
            throw new DAOException(msg);
        }
    }

}
