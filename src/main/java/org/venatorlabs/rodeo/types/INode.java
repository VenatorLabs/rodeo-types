/*
 * Copyright (c) 2023 Venator Labs, LLC. All Rights Reserved.
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

    public void setId(String id);

    public String[] getLabels();

    public void setLabels(String[] labels);

    public Map<String, Object> getAttributes();

    public void setAttributes(Map<String, Object> attributes);

    public String[] getMergeOnLabels();

    public void setMergeOnLabels(String[] mergeOnLabels);

    public Map<String, Object> getMergeOnAttributes();

    public void setMergeOnAttributes(Map<String, Object> mergeOnAttributes);

    public Object[] getIteratorValues();

    public void setIteratorValues(Object[] iteratorValues);

    public String getIteratorId();

    public void setIteratorId(String iteratorId);

    public boolean isIterator();

    public void setIterator(boolean isIterator);

    public boolean isMerge();

    public void setMerge(boolean isMerge);
}
