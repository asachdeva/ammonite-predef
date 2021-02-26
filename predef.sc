interp.load.ivy(   
      "com.lihaoyi" %   
      s"ammonite-shell_${scala.util.Properties.versionNumberString}" %   
      ammonite.Constants.version   
    )   
     
     
  if (!repl.compiler.settings.isScala213) {   
    repl.load.apply("interp.configureCompiler(_.settings.YpartialUnification.     value = true)")   
    repl.load.apply("interp.configureCompiler(_.settings.YpartialUnification.     value = true)")   
  }   
     
  interp.configureCompiler(_.settings.Ydelambdafy.tryToSetColon(List("inline")))  
  object load {
    def fs2Version(version: String) = {
      repl.load.apply(s"""
        import $$ivy.`co.fs2::fs2-io:$version`, fs2._, fs2.concurrent._, cats.    _, cats.implicits._, cats.effect._, cats.effect.implicits._, scala.concurrent.  duration._
  
        import $$ivy.`org.scalatest::scalatest:3.2.5`,org.scalatest._
        import $$ivy.`org.scalacheck::scalacheck:1.15.2`
        import $$ivy.`dev.zio::zio:1.0.4-2`
        import $$ivy.`com.github.pureconfig::pureconfig:0.14.0`
        import $$ivy.`io.chrisdavenport::cats-scalacheck:0.3.0`   
  
        implicit val ioContextShift: ContextShift[IO] = IO.contextShift(scala.    concurrent.ExecutionContext.Implicits.global)
        implicit val ioTimer: Timer[IO] = IO.timer(scala.concurrent.              ExecutionContext.Implicits.global)
      """)
      if (!version.startsWith("1")) repl.load.apply("""
        val globalBlocker: Blocker = cats.effect.Blocker.                         liftExecutionContext(scala.concurrent.ExecutionContext.Implicits.global)
      """)
    }
  
    def fs2 = fs2Version("2.5.3")
}
