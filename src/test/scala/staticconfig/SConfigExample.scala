package staticconfig
import com.typesafe.config.{Config, ConfigFactory}


object SConfigExample extends SConfig {

  override def config: Config = ConfigFactory.load()

  object `static-config` extends LocalSConfigNode {

    val intEntry = configEntry(_.getInt)

    val stringEntry = configEntry(_.getString)

    object group extends LocalSConfigNode {

      val listEntry = configEntry(_.getStringList)

      val durationEntry = configEntry(_.getDuration)

    }
  }

  val `other-config` = configEntry(_.getInt)

}
