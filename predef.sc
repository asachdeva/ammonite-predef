interp.load.ivy( 
    "com.lihaoyi" %    
    s"ammonite-shell_${scala.util.Properties.versionNumberString}" %    
    ammonite.Constants.version    
  )    
  @    
  val shellSession = ammonite.shell.ShellSession()    
  import shellSession._    
  import ammonite.ops._    
  import ammonite.shell._    
     
  // Uncomment the below line if you are using Scala < 2.13    
  // interp.configureCompiler(_.settings.YpartialUnification.value = true)    

  import $ivy.`org.typelevel::cats-core:2.0.0`, cats._, cats.implicits._    
  import $ivy.`org.scalatest::scalatest:3.0.8`,org.scalatest._    
  import $ivy.`org.scalacheck::scalacheck:1.14.1`    
  import $ivy.`dev.zio::zio:1.0.0-RC16`    
  import $ivy.`org.typelevel::cats-effect:2.0.0`    
  import $ivy.`com.github.chocpanda::scalacheck-magnolia:0.3.1`    
  import $ivy.`io.chrisdavenport::cats-scalacheck:0.2.0`
  import $ivy.`com.github.pureconfig::pureconfig:0.12.1`
  import scala.concurrent.ExecutionContext.Implicits.global    
  import scala.concurrent.duration._   
  import scala.concurrent.{ Future, Await }    
  import scala.util.{Failure, Success}    
  import org.scalacheck.{Arbitrary, Gen}    
  import org.scalacheck.magnolia._          
                                                                                                           
  ammonite.shell.Configure(interp, repl, wd)
