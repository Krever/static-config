package staticconfig

import com.typesafe.config.Config


trait SConfig {

  def config: Config

  def configEntry[T](extractor: Config => String => T)(implicit valName: sourcecode.Name): T = extractor(config)(valName.value)

}

abstract class SConfigNode(parentConfig: Config)(implicit objName: sourcecode.Name) extends SConfig {

  def config: Config = parentConfig.getConfig(objName.value)

}
