/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.logging.log4j.mongodb;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.appender.nosql.NoSqlProvider;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginBuilderFactory;
import org.apache.logging.log4j.mongodb4.MongoDb4Connection;
import org.apache.logging.log4j.mongodb4.MongoDb4Provider;
import org.apache.logging.log4j.mongodb4.MongoDb4Provider.Builder;

/**
 * Delegates to {@link MongoDb4Provider} under the name {@code MongoDb}.
 */
/*
 * TODO: Currently the
 *   {@link org.apache.logging.log4j.core.config.plugins.processor.PluginProcessor}
 *   assumes that the class generated by the plugin is the same as the annotated class.
 *   To work around this we declare this class abstract and let it implement
 *   {@link NoSqlProvider}.
 */
@Plugin(name = "MongoDb", category = Core.CATEGORY_NAME, printObject = true)
public abstract class MongoDbProvider implements NoSqlProvider<MongoDb4Connection> {

    private MongoDbProvider() {}

    @PluginBuilderFactory
    public static <B extends Builder<B>> B newBuilder() {
        return MongoDb4Provider.newBuilder();
    }
}