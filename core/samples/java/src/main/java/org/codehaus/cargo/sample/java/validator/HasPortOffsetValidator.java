/*
 * ========================================================================
 *
 * Codehaus CARGO, copyright 2004-2011 Vincent Massol, 2012-2018 Ali Tokmen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package org.codehaus.cargo.sample.java.validator;

import org.codehaus.cargo.container.ContainerType;
import org.codehaus.cargo.container.configuration.ConfigurationType;
import org.codehaus.cargo.container.property.GeneralPropertySet;
import org.codehaus.cargo.generic.configuration.ConfigurationCapabilityFactory;
import org.codehaus.cargo.generic.configuration.DefaultConfigurationCapabilityFactory;

/**
 * Validator, that check if the container supports port offset.
 */
public class HasPortOffsetValidator implements Validator
{
    /**
     * Configuration capability factory.
     */
    private final ConfigurationCapabilityFactory factory;

    /**
     * Configuration type.
     */
    private final ConfigurationType configurationType;

    /**
     * Check if the container supports port offset.
     * @param configurationType Configuration type.
     */
    public HasPortOffsetValidator(ConfigurationType configurationType)
    {
        factory = new DefaultConfigurationCapabilityFactory();
        this.configurationType = configurationType;
    }

    @Override
    public boolean validate(String containerId, ContainerType type)
    {
        return this.factory.createConfigurationCapability(containerId, type,
                configurationType).supportsProperty(GeneralPropertySet.PORT_OFFSET);
    }
}
