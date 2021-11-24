/**
 * This file is part of the pl.wrzasq.parent.
 *
 * @license http://mit-license.org/ The MIT license
 * @copyright 2021 © by Rafał Wrzeszcz - Wrzasq.pl.
 */

package pl.wrzasq.parent.nativelambda.plugin

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream
import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.project.MavenProject
import java.io.File
import java.io.FileOutputStream

/**
 * Maven goal for creating native Lambda package.
 */
@Mojo(name = "package", defaultPhase = LifecyclePhase.PACKAGE)
class PackageMojo : AbstractMojo() {
    /**
     * Maven project.
     */
    @Parameter(defaultValue = "\${project}", required = true, readonly = true)
    lateinit var project: MavenProject

    /**
     * Target package name.
     */
    @Parameter(defaultValue = "\${project.build.finalName}.zip", required = true, readonly = true)
    lateinit var packageName: String

    /**
     * Executable name.
     */
    @Parameter(defaultValue = "\${project.build.finalName}.bin", required = true, readonly = true)
    lateinit var executableName: String

    /**
     * UPX executable path.
     */
    @Parameter(defaultValue = "/usr/bin/upx", property = "native.upxExecutable", required = true, readonly = true)
    lateinit var upxExecutable: String

    override fun execute() {
        compressExecutable()
        createPackageArchive()
    }

    private fun compressExecutable() {
        val builder = ProcessBuilder(upxExecutable, "${project.build.directory}/${executableName}")
        val process = builder.start()

        process.inputStream.transferTo(System.out)
        process.errorStream.transferTo(System.err)

        val exitCode = process.waitFor()
        check(exitCode == 0) { "$upxExecutable exited with $exitCode" }
    }

    private fun createPackageArchive() {
        ZipArchiveOutputStream(FileOutputStream("${project.build.directory}/${packageName}")).use {
            it.putArchiveEntry(
                ZipArchiveEntry(executableName).also { entry -> entry.unixMode = 755 }
            )
            File("${project.build.directory}/${executableName}").inputStream().use { input -> input.copyTo(it) }
            it.closeArchiveEntry()

            // add bootstrap file - needs to be executable
            it.putArchiveEntry(
                ZipArchiveEntry("bootstrap").also { entry -> entry.unixMode = 755 }
            )
            it.write(buildBootstrap().toByteArray())
            it.closeArchiveEntry()
        }
    }

    private fun buildBootstrap() = "#!/bin/bash\n" +
        "\n" +
        "set -euo pipefail\n" +
        "\n" +
        "./$executableName\n"
}
