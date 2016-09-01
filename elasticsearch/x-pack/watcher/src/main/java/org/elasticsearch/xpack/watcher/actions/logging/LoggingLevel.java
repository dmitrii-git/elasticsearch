/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.xpack.watcher.actions.logging;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.SuppressLoggerChecks;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.Locale;

/**
 *
 */
public enum LoggingLevel implements ToXContent {

    ERROR() {
        @Override
        @SuppressLoggerChecks(reason = "logger delegation")
        void log(Logger logger, String text) {
            logger.error(text);
        }
    },
    WARN() {
        @Override
        @SuppressLoggerChecks(reason = "logger delegation")
        void log(Logger logger, String text) {
            logger.warn(text);
        }
    },
    INFO() {
        @Override
        @SuppressLoggerChecks(reason = "logger delegation")
        void log(Logger logger, String text) {
            logger.info(text);
        }
    },
    DEBUG() {
        @Override
        @SuppressLoggerChecks(reason = "logger delegation")
        void log(Logger logger, String text) {
            logger.debug(text);
        }
    },
    TRACE() {
        @Override
        @SuppressLoggerChecks(reason = "logger delegation")
        void log(Logger logger, String text) {
            logger.trace(text);
        }
    };

    abstract void log(Logger logger, String text);


    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return builder.value(name().toLowerCase(Locale.ROOT));
    }
}
