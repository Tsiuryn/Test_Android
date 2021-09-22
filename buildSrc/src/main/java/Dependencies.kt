import java.net.URI

object Dependencies {
    const val kotlinVersion = "1.5.10"
    object Main{
        const val GRADLE = "com.android.tools.build:gradle:4.2.2"
        const val GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        val mavenUri = URI("https://jitpack.io")
    }

    object App{

    }
}