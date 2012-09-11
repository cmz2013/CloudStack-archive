package com.cloud.baremetal.networkservice;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.cloud.baremetal.manager.BaremetalManager;
import com.cloud.dc.DataCenter.NetworkType;
import com.cloud.deploy.DeployDestination;
import com.cloud.exception.ConcurrentOperationException;
import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.network.Network;
import com.cloud.network.Network.Capability;
import com.cloud.network.Network.GuestType;
import com.cloud.network.Network.Provider;
import com.cloud.network.Network.Service;
import com.cloud.network.Networks.TrafficType;
import com.cloud.network.PhysicalNetworkServiceProvider;
import com.cloud.network.element.NetworkElement;
import com.cloud.network.element.UserDataServiceProvider;
import com.cloud.offering.NetworkOffering;
import com.cloud.uservm.UserVm;
import com.cloud.utils.component.AdapterBase;
import com.cloud.utils.component.Inject;
import com.cloud.vm.NicProfile;
import com.cloud.vm.ReservationContext;
import com.cloud.vm.VirtualMachine;
import com.cloud.vm.VirtualMachineProfile;

@Local(value = NetworkElement.class)
public class BaremetalUserdataElement extends AdapterBase implements NetworkElement, UserDataServiceProvider {
    private static Map<Service, Map<Capability, String>> capabilities;
    
    @Inject
    private BaremetalPxeManager pxeMgr;
    
    static {
        capabilities = new HashMap<Service, Map<Capability, String>>();
        capabilities.put(Service.UserData, null);
    }
    
    private boolean canHandle(DeployDestination dest)  {
        if (dest.getDataCenter().getNetworkType() == NetworkType.Basic && dest.getHost().getHypervisorType() == HypervisorType.BareMetal) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean addPasswordAndUserdata(Network network, NicProfile nic, VirtualMachineProfile<? extends VirtualMachine> vm, DeployDestination dest,
            ReservationContext context) throws ConcurrentOperationException, InsufficientCapacityException, ResourceUnavailableException {
        if (!canHandle(dest)) {
            return false;
        }
        
        if (vm.getType() != VirtualMachine.Type.User) {
            return false;
        }
        
        return pxeMgr.addUserData(nic, (VirtualMachineProfile<UserVm>) vm);
    }

    @Override
    public boolean savePassword(Network network, NicProfile nic, VirtualMachineProfile<? extends VirtualMachine> vm) throws ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Map<Service, Map<Capability, String>> getCapabilities() {
        return capabilities;
    }

    @Override
    public Provider getProvider() {
        return BaremetalPxeManager.BAREMETAL_USERDATA_PROVIDER;
    }

    @Override
    public boolean implement(Network network, NetworkOffering offering, DeployDestination dest, ReservationContext context)
            throws ConcurrentOperationException, ResourceUnavailableException, InsufficientCapacityException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean prepare(Network network, NicProfile nic, VirtualMachineProfile<? extends VirtualMachine> vm, DeployDestination dest,
            ReservationContext context) throws ConcurrentOperationException, ResourceUnavailableException, InsufficientCapacityException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean release(Network network, NicProfile nic, VirtualMachineProfile<? extends VirtualMachine> vm, ReservationContext context)
            throws ConcurrentOperationException, ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean shutdown(Network network, ReservationContext context, boolean cleanup) throws ConcurrentOperationException, ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean destroy(Network network) throws ConcurrentOperationException, ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isReady(PhysicalNetworkServiceProvider provider) {
        return true;
    }

    @Override
    public boolean shutdownProviderInstances(PhysicalNetworkServiceProvider provider, ReservationContext context) throws ConcurrentOperationException,
            ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canEnableIndividualServices() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean verifyServicesCombination(List<String> services) {
        return true;
    }

}