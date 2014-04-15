/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Proposition;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class PropositionDAO extends BaseDAO {

    public Proposition getServiceById(Long id) throws DAOException {
        Object o = super.getById(id, Proposition.class);
        if (o instanceof Proposition) {
            return (Proposition) o;
        } else {
            return null;
        }
    }
}
