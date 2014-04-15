/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cloudservices.brokerage.policy.policycommons.model.DAO;

import cloudservices.brokerage.policy.policycommons.model.entities.Service;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/  
 */
public class ServiceDAO extends BaseDAO{
    public Service getServiceById(Long id) throws DAOException{
        Object o= super.getById(id, Service.class);
        if(o instanceof Service){
            return (Service)o;
        }
        else{
            return null;
        }
    }
}
