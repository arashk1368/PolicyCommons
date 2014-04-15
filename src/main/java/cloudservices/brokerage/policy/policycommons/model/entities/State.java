/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
public class State extends UniObject {

    private int number;
    private Set<Proposition> propositions;
    private HashMap<String,Object> params;

    public State() {
        super.setUniId((long) number);
        super.setUniName("state");
        this.propositions = new HashSet<>();
        this.params=new HashMap<>();
    }

    public boolean addProposition(Proposition prop) {
        return this.propositions.add(prop);
    }

    public boolean removeProposition(Proposition prop) {
        return this.propositions.remove(prop);
    }
    
    public Object addParam(String key,Object value){
        return this.params.put(key, value);
    }
    
    public Object removeParam(String key){
        return this.params.remove(key);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        super.setUniId((long) number);
    }

    public Set<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(Set<Proposition> propositions) {
        this.propositions = propositions;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }
    
}
