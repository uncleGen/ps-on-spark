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

package org.apache.spark.ps

/**
 * CoarseGrainedParameterServerMessage
 */
private[spark] sealed trait CoarseGrainedParameterServerMessage extends Serializable

private[spark] object CoarseGrainedParameterServerMessage {

  case class RegisterPSTable(psTable: PSTableDesc[_])
    extends CoarseGrainedParameterServerMessage

  case class SetParameter(tbName: String, key: Array[Byte], value: Array[Byte], clock: Int)
    extends CoarseGrainedParameterServerMessage

  case class SetParameters(tbName: String, keys: Array[Byte], values: Array[Byte], clock: Int)
    extends CoarseGrainedParameterServerMessage

  case class GetParameter(tbName: String, key: Array[Byte], clock: Int)
    extends CoarseGrainedParameterServerMessage

  case class GetParameters(tbName: String, keys: Array[Byte], clock: Int)
    extends CoarseGrainedParameterServerMessage

  case class UpdateParameter(tbName: String, key: Array[Byte], value: Array[Byte], numOpts: Int, clock: Int)
    extends CoarseGrainedParameterServerMessage

  case class UpdateParameters(tbName: String, keys: Array[Byte], values: Array[Byte], numOpts: Array[Int], clock: Int)
    extends CoarseGrainedParameterServerMessage

  case class Parameter(success: Boolean, value: Array[Byte])
    extends CoarseGrainedParameterServerMessage

  case class Parameters(values: Array[(Boolean, Array[Byte])])
    extends CoarseGrainedParameterServerMessage

  case class UpdateClock(clientId: String, clock: Int)
    extends CoarseGrainedParameterServerMessage

  case class NotifyServer(executorUrl: String)
    extends CoarseGrainedParameterServerMessage

  case class NotifyClient(serverID: Long, message: String)
    extends CoarseGrainedParameterServerMessage

  case class InitPSClient(clientId: String, clientClock: Int, initGlobalClock: Int)
    extends CoarseGrainedParameterServerMessage

  case class SetKeyMapFunc(mapFunc: String => Long)
    extends CoarseGrainedParameterServerMessage
}
