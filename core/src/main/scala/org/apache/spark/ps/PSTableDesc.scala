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

import scala.reflect.ClassTag

/**
 * PSTableDesc
 */
class PSTableDesc[V: ClassTag](val tbName: String) extends Serializable {

  var rowType = PSTableDataType.STRING
  var colType = PSTableDataType.DOUBLE

  var agg: (V, V) => V = _
  var applyFunc: (V, V) => V = _

  def setFunc(agg: (V, V) => V, applyFunc: (V, V) => V): Unit = {
    this.agg = agg
    this.applyFunc = applyFunc
  }

  def registerRowType(rowType: PSTableDataType.PSTableDataType): Unit = {
    this.rowType = rowType
  }

  def registerColType(colType: PSTableDataType.PSTableDataType): Unit = {
    this.colType = colType
  }
}

object PSTableDesc {
}

object PSTableDataType extends Enumeration {
  val INTEGER, DOUBLE, FLOAT, LONG, STRING = Value

  type PSTableDataType = Value
}
