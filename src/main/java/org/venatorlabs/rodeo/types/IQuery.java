/*
 * Copyright (c) 2023 Venator Labs, Inc. All Rights Reserved.
 * This code is licensed under the MIT License.
 *
 * For license terms, see LICENSE
 */

package org.venatorlabs.rodeo.types;

import java.util.List;
import java.util.Map;

/**
 * Object Interface representing a Neo4j Node Query.
 */
public interface IQuery {
    public String[] getLabels();

    public void setLabels(String[] labels);

    public List<Map<String, Object>> getComparisons();

    public void setComparisons(List<Map<String, Object>> comparisons);
}
