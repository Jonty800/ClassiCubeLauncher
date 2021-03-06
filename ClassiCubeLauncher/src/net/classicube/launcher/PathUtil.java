package net.classicube.launcher;

import java.io.*;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class PathUtil {

    private static final String MacSuffix = "/Library/Application Support";
    public static final String ClientDirName = "net.classicube.client",
            ClientJar = "ClassiCubeClient.jar",
            ClientTempJar = "ClassiCubeClient.jar.tmp",
            LauncherDirName = "net.classicube.launcher",
            LogFileName = "launcher.log",
            LibsDirName = "libs";

    public static File getClientDir() {
        if (clientPath == null) {
            clientPath = new File(getAppDataDir(), ClientDirName);
        }
        if (!clientPath.exists() && !clientPath.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + clientPath);
        }
        return clientPath;
    }

    public static File getAppDataDir() {
        if (appDataPath == null) {
            final String home = System.getProperty("user.home", ".");
            final OperatingSystem os = OperatingSystem.detect();

            switch (os) {
                case Windows:
                    String appData = System.getenv("APPDATA");
                    if (appData != null) {
                        appDataPath = new File(appData);
                    } else {
                        appDataPath = new File(home);
                    }
                    break;

                case MacOS:
                    appDataPath = new File(home, MacSuffix);
                    break;

                default:
                    appDataPath = new File(home);
            }
        }
        return appDataPath;
    }

    public static File getLauncherDir() {
        if (launcherPath == null) {
            final File userDir = getAppDataDir();
            launcherPath = new File(userDir, LauncherDirName);
            if (launcherPath.exists()) {
                launcherPath.mkdir();
            }
        }
        return launcherPath;
    }

    public static File getLogFile() {
        if (logFilePath == null) {
            logFilePath = new File(PathUtil.getLauncherDir(), PathUtil.LogFileName);
        }
        return logFilePath;
    }

    // Safely replace contents of destFile with sourceFile
    static void replaceFile(File sourceFile, File destFile)
            throws IOException {
        Path sourcePath = Paths.get(sourceFile.getAbsolutePath());
        Path destPath = Paths.get(destFile.getAbsolutePath());
        Files.move(sourcePath, destPath, FileReplaceOptions);
    }
    private static final CopyOption[] FileReplaceOptions = new CopyOption[]{
        StandardCopyOption.ATOMIC_MOVE,
        StandardCopyOption.REPLACE_EXISTING
    };

    // Deletes a directory and all of its children
    public boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    //Copies a directory, creates dir if needed
    public static void copyDir(File sourceDir, File destDir)
            throws FileNotFoundException, IOException {
        if (sourceDir == null) {
            throw new NullPointerException("sourceDir");
        }
        if (destDir == null) {
            throw new NullPointerException("destDir");
        }
        if (sourceDir.isDirectory()) {
            if (!destDir.exists()) {
                destDir.mkdir();
            }
            String files[] = sourceDir.list();
            for (String file : files) {
                File srcFile = new File(sourceDir, file);
                File destFile = new File(destDir, file);
                copyDir(srcFile, destFile);
            }
        } else {
            copyFile(sourceDir, destDir);
        }
    }

    // Copies a file
    public static void copyFile(File sourceFile, File destFile)
            throws FileNotFoundException, IOException {
        if (sourceFile == null) {
            throw new NullPointerException("sourceFile");
        }
        if (destFile == null) {
            throw new NullPointerException("destFile");
        }
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        try (FileChannel source = new FileInputStream(sourceFile).getChannel()) {
            try (FileChannel destination = new FileOutputStream(destFile).getChannel()) {
                destination.transferFrom(source, 0, source.size());
            }
        }
    }
    
    
    public static File removeExtension(File fileName) {
        final String oldName = fileName.getPath();
        final String newName = oldName.substring(0, oldName.lastIndexOf('.'));
        return new File(newName);
    }
    private static File clientJar,
            clientPath,
            launcherPath,
            logFilePath,
            appDataPath;
}
