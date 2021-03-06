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
package org.apache.nifi.web.api.dto;

import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.xml.bind.annotation.XmlType;

/**
 * A description of a property.
 */
@XmlType(name = "propertyDescriptor")
public class PropertyDescriptorDTO {

    private String name;
    private String displayName;
    private String description;
    private String defaultValue;
    private List<AllowableValueDTO> allowableValues;
    private boolean required;
    private boolean sensitive;
    private boolean dynamic;
    private boolean supportsEl;
    private String identifiesControllerService;

    /**
     * @return set of allowable values for this property. If empty then the allowable values are not constrained
     */
    @ApiModelProperty(
            value = "Allowable values for the property. If empty then the allowed values are not constrained."
    )
    public List<AllowableValueDTO> getAllowableValues() {
        return allowableValues;
    }

    public void setAllowableValues(List<AllowableValueDTO> allowableValues) {
        this.allowableValues = allowableValues;
    }

    /**
     * @return default value for this property
     */
    @ApiModelProperty(
            value = "The default value for the property."
    )
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @return An explanation of the meaning of the given property. This description is meant to be displayed to a user or simply provide a mechanism of documenting intent
     */
    @ApiModelProperty(
            value = "The descriptoin for the property. Used to relay additional details to a user or provide a mechanism of documenting intent."
    )
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return property name
     */
    @ApiModelProperty(
            value = "The name for the property."
    )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return human-readable name to display to users
     */
    @ApiModelProperty(
            value = "The human readable name for the property."
    )
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return whether the property is required for this processor
     */
    @ApiModelProperty(
            value = "Whether the property is required."
    )
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @return indicates that the value for this property should be considered sensitive and protected whenever stored or represented
     */
    @ApiModelProperty(
            value = "Whether the property is sensitive and protected whenever stored or represented."
    )
    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    /**
     * @return indicates whether this property is dynamic
     */
    @ApiModelProperty(
            value = "Whether the property is dynamic (user-defined)."
    )
    public boolean isDynamic() {
        return dynamic;
    }

    public void setDynamic(boolean dynamic) {
        this.dynamic = dynamic;
    }

    /**
     * @return specifies whether or not this property support expression language
     */
    @ApiModelProperty(
            value = "Whether the property supports expression language."
    )
    public boolean getSupportsEl() {
        return supportsEl;
    }

    public void setSupportsEl(boolean supportsEl) {
        this.supportsEl = supportsEl;
    }

    /**
     * @return if this property identifies a controller service, this returns the fully qualified type, null otherwise
     */
    @ApiModelProperty(
            value = "If the property identifies a controller service, this returns the fully qualified type."
    )
    public String getIdentifiesControllerService() {
        return identifiesControllerService;
    }

    public void setIdentifiesControllerService(String identifiesControllerService) {
        this.identifiesControllerService = identifiesControllerService;
    }

    /**
     * The allowable values for a property with a constrained set of options.
     */
    @XmlType(name = "allowableValue")
    public static class AllowableValueDTO {

        private String displayName;
        private String value;
        private String description;

        /**
         * @return the human-readable value that is allowed for this PropertyDescriptor
         */
        @ApiModelProperty(
                value = "A human readable value that is allowed for the property descriptor."
        )
        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        /**
         * @return the value for this allowable value
         */
        @ApiModelProperty(
                value = "A value that is allowed for the property descriptor."
        )
        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        /**
         * @return a description of this Allowable Value, or <code>null</code> if no description is given
         */
        @ApiModelProperty(
                value = "A description for this allowable value."
        )
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof AllowableValueDTO)) {
                return false;
            }

            final AllowableValueDTO other = (AllowableValueDTO) obj;
            return (this.value.equals(other.getValue()));
        }

        @Override
        public int hashCode() {
            return 23984731 + 17 * value.hashCode();
        }
    }
}
