package com.greenlightdigital.analyzer.interfaces;

import java.util.Map;

import org.apache.commons.collections.buffer.CircularFifoBuffer;

/**
 * @author Vladislav Naydenov
 *
 */
public interface IntrusionDetectorManual {

	void clean(Map<Integer, CircularFifoBuffer> loginsMap);
}
