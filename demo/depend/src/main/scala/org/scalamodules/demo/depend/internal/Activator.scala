/**
 * Copyright 2009 Heiko Seeberger and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalamodules.demo.depend.internal

import org.osgi.framework.{BundleActivator, BundleContext}
import org.scalamodules.core.RichBundleContext.fromBundleContext
import org.scalamodules.demo.Greeting

class Activator extends BundleActivator {

  override def start(context: BundleContext) {
    context registerAs classOf[String] dependOn classOf[Greeting] theService {
      greeting => greeting.welcome + "/" + greeting.goodbye
    }
  }
  
  override def stop(context: BundleContext) { // Nothing!
  }
}
