/*
Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify,
merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.amazonaws.mobile.samples.awsomenotes.services.mock

import android.util.Log
import com.amazonaws.mobile.samples.awsomenotes.TAG
import com.amazonaws.mobile.samples.awsomenotes.services.AnalyticsService

/**
 * Implementation of the AnalyticsService interface that logs to the
 * Android console log (or logcat)
 */
class MockAnalyticsService : AnalyticsService {
    /**
     * Records a start session event into the analytics stream
     */
    override fun startSession() {
        Log.v(TAG, "startSession()")
    }

    /**
     * Records a stop session event into the analytics stream
     */
    override fun stopSession() {
        Log.v(TAG, "stopSession()")
    }

    /**
     * Record a custom event into the analytics stream
     *
     * @param eventName the custom event name
     * @param attributes a list of key-value pairs for recording string attributes
     * @param metrics a list of key-value pairs for recording numeric metrics
     */
    override fun recordEvent(eventName: String, attributes: Map<String,String>?, metrics: Map<String,Double>?) {
        val event = StringBuilder("")
        attributes?.let {
            for ((k, v) in it) {
                event.append(", $k=\"$v\"")
            }
        }
        metrics?.let {
            for ((k, v) in it) {
                event.append(", $k=${String.format("$.2f",v)}")
            }
        }
        if (event.isNotEmpty())
            event[0] = ':'
        Log.v(TAG, "recordEvent($eventName)$event")
    }
}