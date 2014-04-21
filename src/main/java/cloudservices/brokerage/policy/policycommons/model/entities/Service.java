/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cloudservices.brokerage.policy.policycommons.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * A service which can be a part of a plan or complete composition plan
 *
 * @author Arash Khodadadi http://www.arashkhodadadi.com/
 */
@Entity
public class Service implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String WSDLURL;
    @Column
    private String servicesStr;
    @Column
    private int numberOfServiceLevels;
    @Column
    private String inputPropositions;
    @Column
    private int numberOfInputs;
    @Column
    private String outputPropositions;
    @Column
    private int numberOfOutputs;
    @OneToMany(mappedBy = "service")
    private Set<ServiceProposition> servicePropositions;
    @OneToMany(mappedBy = "service")
    private Set<PolicyService> policyServices;

    public Service() {
        this.servicePropositions = new HashSet<>();
        this.policyServices = new HashSet<>();
        servicesStr = "";
        numberOfServiceLevels = 0;
        inputPropositions = "";
        outputPropositions = "";
        numberOfInputs = 0;
        numberOfOutputs = 0;
    }

    protected boolean addInput(Proposition prop) {
        String inputStr = prop.getName() + "-" + prop.getId();
        if (inputPropositions.contains(inputStr)) {
            return false;
        }
        if (numberOfInputs > 0) {
            inputPropositions += ",";
        }
        inputPropositions += inputStr;
        numberOfInputs++;
        return true;
    }

    protected boolean addOutput(Proposition prop) {
        String outputStr = prop.getName() + "-" + prop.getId();
        if (outputPropositions.contains(outputStr)) {
            return false;
        }
        if (numberOfOutputs > 0) {
            outputPropositions += ",";
        }
        outputPropositions += outputStr;
        numberOfOutputs++;
        return true;
    }

    public boolean addServiceLevel(Set<Service> serviceLevel) {
        String levelStr = getServicesStr(serviceLevel);
//        if (servicesStr.contains(levelStr)) {
//            return false;
//        }
        if (numberOfServiceLevels > 0) {
            servicesStr += "-";
        }
        servicesStr += levelStr;
        numberOfServiceLevels++;
        return true;
    }

    public boolean isComposite() {
        return numberOfServiceLevels > 1 ? true : false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWSDLURL() {
        return WSDLURL;
    }

    public void setWSDLURL(String WSDLURL) {
        this.WSDLURL = WSDLURL;
    }

    public Set<ServiceProposition> getServicePropositions() {
        return servicePropositions;
    }

    public String getServicesStr() {
        return servicesStr;
    }

    public void setServicesStr(String servicesStr) {
        this.servicesStr = servicesStr;
        String[] serviceLevels = servicesStr.split("-");
        this.numberOfServiceLevels = serviceLevels.length;
    }

    public Set<PolicyService> getPolicyServices() {
        return policyServices;
    }

    public String getInputPropositions() {
        return inputPropositions;
    }

    public String getOutputPropositions() {
        return outputPropositions;
    }

    public int getNumberOfInputs() {
        return numberOfInputs;
    }

    public int getNumberOfOutputs() {
        return numberOfOutputs;
    }

    public int getNumberOfServiceLevels() {
        return numberOfServiceLevels;
    }

    private String getServicesStr(Set<Service> services) {
        String str = "";
        for (Service service : services) {
            str += service.getId().toString();
            str += ",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (Service.class.isAssignableFrom(o.getClass())) {
            Service testService = (Service) o;
            return testService.getId().compareTo(this.getId()) == 0
                    && testService.getName().compareTo(this.getName()) == 0;
        } else {
            return this.toString().equals(o);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        if (this.id != null) {
            hash = 89 * hash + Objects.hashCode(this.id);
        }
        if (this.name != null) {
            hash = 89 * hash + Objects.hashCode(this.name);
        }
        return hash;
    }
}