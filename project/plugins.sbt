resolvers += "Sonatype Repository" at "https://oss.sonatype.org/content/groups/public"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

// to generate dependency graph of the libraries
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")

// check latest updates form maven
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.0")

// kotlin plugin
addSbtPlugin("com.hanhuy.sbt" % "kotlin-plugin" % "1.0.7")

// groovy support
addSbtPlugin("org.softnetwork.sbt.plugins" % "sbt-groovy" % "0.1.3")
