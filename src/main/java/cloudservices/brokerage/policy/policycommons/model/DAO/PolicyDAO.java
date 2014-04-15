/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Policy;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class PolicyDAO extends BaseDAO {

    public Policy getServiceById(Long id) throws DAOException {
        Object o = super.getById(id, Policy.class);
        if (o instanceof Policy) {
            return (Policy) o;
        } else {
            return null;
        }
    }
}
