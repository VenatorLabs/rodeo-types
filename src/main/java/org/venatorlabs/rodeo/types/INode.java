/*
 * Copyright (c) 2023 Venator Labs, Inc. All Rights Reserved.
 * This code is licensed under the MIT License.
 *
 * For license terms, see LICENSE
 */

package org.venatorlabs.rodeo.types;

import java.util.Map;

/**
 * Object Interface representing a Neo4j Node.
 */
public interface INode {
    public String getId();

    public String[] getLabels();

    public Map<String, Object> getAttributes();

    public String[] getMergeOnLabels();

    public Map<String, Object> getMergeOnAttributes();

    public Object[] getIteratorValues();

    public String getIteratorId();

    public boolean isIterator();

    public boolean isMerge();
}
