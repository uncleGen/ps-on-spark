/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 *  Parameter server backend
 */
package org.apache.spark.ps

import java.net.URL
import java.nio.ByteBuffer

import akka.actor.Actor

import org.apache.spark.TaskState.TaskState
import org.apache.spark.{Logging, SparkEnv}
import org.apache.spark.executor.ExecutorBackend
import org.apache.spark.util.ActorLogReceive

private[spark] class CoarseGrainedParameterServerBackend(
    driverUrl: String,
    executorId: String,
    hostPort: String,
    executorVCores: Int,
    userClassPath: Seq[URL],
    env: SparkEnv)
  extends Actor with ActorLogReceive with ExecutorBackend with Logging {
  override def receiveWithLogging: Receive = ???

  override def statusUpdate(taskId: Long, state: TaskState, data: ByteBuffer): Unit = ???
}

object CoarseGrainedParameterServerBackend extends Logging {

  def main(args: Array[String]): Unit = {

  }
}
