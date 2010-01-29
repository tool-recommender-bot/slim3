/*
 * Copyright 2004-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.slim3.datastore;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

/**
 * @author higa
 * 
 */
public class GlobalTransactionTest extends AppEngineTestCase {

    private GlobalTransaction gtx;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        gtx = new GlobalTransaction();
    }

    /**
     * @throws Exception
     */
    @Test
    public void exists() throws Exception {
        Key key = Datastore.put(new Entity(GlobalTransaction.KIND));
        assertThat(GlobalTransaction.exists(key), is(true));
        assertThat(GlobalTransaction.exists(Datastore
            .allocateId(GlobalTransaction.KIND)), is(false));
        assertThat(DatastoreServiceFactory
            .getDatastoreService()
            .getActiveTransactions()
            .size(), is(0));
    }

    /**
     * @throws Exception
     */
    @Test
    public void getId() throws Exception {
        assertThat(gtx.getId(), is(not(0L)));
    }
}