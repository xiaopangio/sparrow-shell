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
package com.sparrow.container;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private final SimpleBeanDefinitionRegistry registry;

    protected AbstractBeanDefinitionReader(SimpleBeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    @Override
    public final SimpleBeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public void loadBeanDefinitions(String... resources) throws Exception {
        for (String resource : resources) {
            loadBeanDefinitions(resource);
        }
    }
}
