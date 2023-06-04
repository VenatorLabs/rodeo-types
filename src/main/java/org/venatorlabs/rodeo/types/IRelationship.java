/*
 * Copyright (c) 2023 Venator Labs, Inc. All Rights Reserved.
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

    public Object getSource();

    public Object getDestination();

    public Directionality getDirectionality();

    public boolean isMerge();

    public Map<String, Object> getAttributes();

    public Map<String, Object> getMergeOnAttributes();

    /**
     * Directionality enum used to change direction of relationship.
     */
    public enum Directionality {
        LEFT,
        RIGHT,
        NONE
    }
}
