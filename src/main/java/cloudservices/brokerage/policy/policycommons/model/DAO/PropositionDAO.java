/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Proposition;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

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
            return prop;
        } else {
            String msg = "Problem in reading proposition from Database";
            LOGGER.log(Level.SEVERE, msg);
            throw new DAOException(msg);
        }
    }

    public Proposition getByName(String name) throws DAOException {
        Query query = super.getSession().createQuery("from Proposition where name = :para1 ");
        query.setParameter("para1", name);
        List list = query.list();
        if (list.isEmpty()) {
            return null;
        } else {
            return (Proposition) list.get(0);
        }

    }
}
