/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.web.api.entity;

import com.wordnik.swagger.annotations.ApiModelProperty;
import org.apache.nifi.web.api.dto.AccessPolicyDTO;
import org.apache.nifi.web.api.dto.ControllerConfigurationDTO;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.util.TimeAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * A serialized representation of this class can be placed in the entity body of a request or response to or from the API. This particular entity holds a reference to a ControllerConfigurationDTO.
 */
@XmlRootElement(name = "controllerConfigurationEntity")
public class ControllerConfigurationEntity extends Entity {

    private Date currentTime;
    private ControllerConfigurationDTO controllerConfiguration;
    private RevisionDTO revision;
    private AccessPolicyDTO accessPolicy;

    /**
     * @return revision for this request/response
     */
    @ApiModelProperty(
        value = "The revision for this request/response. The revision is required for any mutable flow requests and is included in all responses."
    )
    public RevisionDTO getRevision() {
        if (revision == null) {
            return new RevisionDTO();
        } else {
            return revision;
        }
    }

    public void setRevision(RevisionDTO revision) {
        this.revision = revision;
    }

    /**
     * The ControllerConfigurationDTO that is being serialized.
     *
     * @return The ControllerConfigurationDTO object
     */
    @ApiModelProperty(
        value = "The controller configuration."
    )
    public ControllerConfigurationDTO getControllerConfiguration() {
        return controllerConfiguration;
    }

    public void setControllerConfiguration(ControllerConfigurationDTO controllerConfiguration) {
        this.controllerConfiguration = controllerConfiguration;
    }

    /**
     * The access policy for this component.
     *
     * @return The access policy
     */
    @ApiModelProperty(
            value = "The access policy for the controller."
    )
    public AccessPolicyDTO getAccessPolicy() {
        return accessPolicy;
    }

    public void setAccessPolicy(AccessPolicyDTO accessPolicy) {
        this.accessPolicy = accessPolicy;
    }

    /**
     * @return current time on the server
     */
    @XmlJavaTypeAdapter(TimeAdapter.class)
    @ApiModelProperty(
            value = "The current time on the system."
    )
    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }
}
