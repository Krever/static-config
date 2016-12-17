package staticconfig

import org.scalatest.{FlatSpec, Matchers}
import java.time.Duration
import scala.collection.JavaConverters._


class SConfigExampleTest extends FlatSpec with Matchers {

  "The SConfigExample" should "contain values from application.conf" in {

    SConfigExample.`static-config`.intEntry should be (1)
    SConfigExample.`static-config`.stringEntry should be ("String")

    SConfigExample.`static-config`.group.durationEntry should be (Duration.ofHours(6))
    SConfigExample.`static-config`.group.listEntry should be (List("val1", "val2").asJava)

    SConfigExample.`other-config` should be (2)

  }

}