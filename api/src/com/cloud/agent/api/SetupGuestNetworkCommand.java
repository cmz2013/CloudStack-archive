// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.agent.api;

import com.cloud.agent.api.routing.NetworkElementCommand;

/**
 * @author Alena Prokharchyk
 */
public class SetupGuestNetworkCommand extends NetworkElementCommand{
    String dhcpRange;
    String networkDomain;
    String defaultDns1 = null;
    String defaultDns2 = null;
    boolean isRedundant = false;
    Integer priority;
    boolean add = true;
    
    @Override
    public boolean executeInSequence() {
        return true;
    }
    
    protected SetupGuestNetworkCommand() {
    }
    
    
    public SetupGuestNetworkCommand(String dhcpRange, String networkDomain, boolean isRedundant, Integer priority, 
            String defaultDns1, String defaultDns2, boolean add) {
        this.dhcpRange = dhcpRange;
        this.networkDomain = networkDomain;
        this.defaultDns1 = defaultDns1;
        this.defaultDns2 = defaultDns2;
        this.isRedundant = isRedundant;
        this.priority = priority;
        this.add = add;
    }
}