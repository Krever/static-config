# static-config
It is a tiny library allowing to scrap some boilerplate when working with typsafehub/config. It contains less then 10 relevant
lines of code, but is still quite usefull.

## Install

`"com.github.krever" %% "static-config" % "1.1.0"`


## Usage

###### application.conf
```
static-config {
  intEntry = 1
  stringEntry = "String"
  group {
    listEntry = ["val1", "val2"]
    durationEntry = 6h
  }
}
other-config = 2
```
###### SConfigExample.scala
```scala
import com.typesafe.config.{Config, ConfigFactory}
import staticconfig._

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
```

## Motivation
It can be found [here](http://w.pitula.me/2016/static-config/).

## Why not to go further?
We could take one more step and make an sbt-plugin that will generate such code directly from `application.conf`.
Although it might be possible, I'm not a big fan of code generation. Some arguments against it can be found [here](http://www.codethinked.com/code-generation-should-be-the-nuclear-option).
