/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Proposition;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class PropositionDAO extends BaseDAO {

    private final static Logger LOGGER = Logger.getLogger(PropositionDAO.class
            .getName());

    public Proposition getById(Long id) throws DAOException {
        Object o = super.getById(id, Proposition.class);
        if (o instanceof Proposition) {
            Proposition prop = (Proposition) o;
            prop.setUniId(id);
            return prop;
        } else {
            String msg = "Problem in reading proposition from Database";
            LOGGER.log(Level.SEVERE, msg);
            throw new DAOException(msg);
        }
    }
}
