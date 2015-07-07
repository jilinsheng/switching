/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.md.util;

import java.io.File;

/**
 *
 * @author Administrator
 */
public class FileUtil {

    public static File buildFile(String fileName, boolean isDirectory) {

        File target = new File(fileName);

        if (isDirectory) {

            target.mkdirs();

        } else {

            if (!target.getParentFile().exists()) {

                target.getParentFile().mkdirs();

                target = new File(target.getAbsolutePath());

            }

        }

        return target;

    }
}
