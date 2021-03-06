/*
 * This file is part of CoAnSys project.
 * Copyright (c) 2012-2014 ICM-UW
 *
 * CoAnSys is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CoAnSys is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with CoAnSys. If not, see <http://www.gnu.org/licenses/>.
 */

package pl.edu.icm.coansys.citations.reducers

import collection.JavaConversions._
import org.apache.hadoop.io.{Text, BytesWritable}
import org.apache.hadoop.mapreduce.Reducer
import pl.edu.icm.coansys.citations.data.{MarkedBytesWritable, MarkedText}
import scala.collection.mutable.ListBuffer


/**
 * @author Mateusz Fedoryszak (m.fedoryszak@icm.edu.pl)
 */
class HashJoiner extends Reducer[MarkedText, MarkedText, Text, Text] {
  type Context = Reducer[MarkedText, MarkedText, Text, Text]#Context

  val outValue = new Text()

  var maxDocuments = 0

  override def setup(context: Context) {
    maxDocuments = context.getConfiguration.getInt("max.documents.per.bucket", 0)
  }
  
  override def reduce(key: MarkedText, values: java.lang.Iterable[MarkedText], context: Context) {
    val docs = new ListBuffer[String]
    for (value <- values) {
      if (value.isMarked.get()) {
        docs.append(value.text.toString)
      } else {
        if (maxDocuments > 0 && docs.size > maxDocuments)
          return
        for (doc <- docs) {
          outValue.set(doc)
          context.write(value.text, outValue)
        }
      }
    }
  }
}
