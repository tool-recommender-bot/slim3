/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
package org.slim3.gae.jdo;

import javax.jdo.PersistenceManager;

/**
 * A helper class for PersistenceManager.
 * 
 * @author higa
 * @since 3.0
 * 
 */
public final class PM {

    private static ThreadLocal<PersistenceManager> persistenceManagers = new ThreadLocal<PersistenceManager>();

    /**
     * Returns the persistence manager attached to the current thread.
     * 
     * @return the persistence manager
     */
    public static PersistenceManager getCurrent() {
        return persistenceManagers.get();
    }

    /**
     * Attaches the persistence manager to the current thread.
     * 
     * @param pm
     *            the persistence manager
     */
    public static void setCurrent(PersistenceManager pm) {
        persistenceManagers.set(pm);
    }

    /**
     * Constructor.
     */
    private PM() {
    }
}