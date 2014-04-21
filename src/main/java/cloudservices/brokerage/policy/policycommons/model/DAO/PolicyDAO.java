/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Policy;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

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
    
    public Policy getByName(String name) throws DAOException {
        Query query = super.getSession().createQuery("from Policy where name = :para1 ");
        query.setParameter("para1", name);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else {
            return (Policy) list.get(0);
        }

    }
}
