/*
 * Copyright (c) 2023 Venator Labs, LLC. All Rights Reserved.
 * This code is licensed under the MIT License.
 *
 * For license terms, see LICENSE
 */

package org.venatorlabs.rodeo.types;

import java.util.Map;

/**
 * Object Interface representing a relationship between two nodes.
 */
public interface IRelationship {
    public String getType();

    public void setType(String type);

    public Object getSource();

    public void setSource(Object source);

    public Object getDestination();

    public void setDestination(Object destination);

    public Directionality getDirectionality();

    public void setDirectionality(Directionality directionality);

    public boolean isMerge();

    public void setMerge(boolean isMerge);

    public Map<String, Object> getAttributes();

    public void setAttributes(Map<String, Object> attributes);

    public Map<String, Object> getMergeOnAttributes();

    public void setMergeOnAttributes(Map<String, Object> mergeOnAttributes);

    /**
     * Directionality enum used to change direction of relationship.
     */
    public enum Directionality {
        LEFT,
        RIGHT,
        NONE
    }
}
