/*
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.acme.insurance.policyquote;

import static org.switchyard.policy.SecurityPolicy.CLIENT_AUTHENTICATION;
import static org.switchyard.policy.SecurityPolicy.CONFIDENTIALITY;
import static org.switchyard.policy.SecurityPolicy.AUTHORIZATION;

import javax.inject.Inject;

import org.acme.insurance.policyquote.domain.PolicyQuote;
import org.apache.log4j.Logger;
import org.switchyard.annotations.Requires;
import org.switchyard.component.bean.Reference;
import org.switchyard.component.bean.Service;

/**
 * Implementation of policy quote entity service.
 */
@Service(PolicyQuoteEntityService.class)
public class PolicyQuoteEntityServiceImpl implements PolicyQuoteEntityService {

    private Logger _logger = Logger.getLogger(PolicyQuoteEntityServiceImpl.class);
    
    @Inject
    @Reference("StoreReference")
    private StoreService _store;
    
    public String createPolicyQuote(PolicyQuote quote) {
    	
	    _logger.info("Sending policy quote to JPA store: " + quote.getDriverName());
	    _store.storePolicyQuote(quote);
	            	
        return "Success";
    }
    

    public void deletePolicyQuote(PolicyQuote quote) {
    	
    }

    public String getPolicyQuote(PolicyQuote quote) {
    	return null;
    }

    
}
