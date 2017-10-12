/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diegogaulke.jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;

import com.diegogaulke.jaxrs.endpoint.StatusEndpoint;
import com.diegogaulke.jaxrs.endpoint.UserEndpoint;

public class TestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		final Set<Class<?>> clazzes = new HashSet<Class<?>>();

		clazzes.add(ResteasyJackson2Provider.class);
		clazzes.add(StatusEndpoint.class);
		clazzes.add(UserEndpoint.class);

		return clazzes;
	}

}
