import okio.FileSystem
import okio.Path.Companion.toPath

fun main() {
    val currentPath = ".".toPath()
    FileSystem.SYSTEM.list(currentPath)
        .filter { it.name.contains("""\.png""".toRegex()) }
        .forEach { FileSystem.SYSTEM.atomicMove(it, it.name.replace(".png", "xD.png").toPath()) }
}
