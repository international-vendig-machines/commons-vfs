/*
 * Copyright 2002, 2003,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.vfs.impl;

import org.apache.commons.vfs.FileContent;
import org.apache.commons.vfs.FileContentInfo;
import org.apache.commons.vfs.FileContentInfoFactory;

import java.net.FileNameMap;
import java.net.URLConnection;

/**
 * The FileContentInfoFilenameFactory.<br>
 * Uses the filename extension to determine the content-type.<br>
 * The content-encoding is not resolved.
 * 
 * @author <a href="mailto:imario@apache.org">Mario Ivanovits</a>
 * @version $Revision: 1.1 $ $Date: 2004/05/21 20:43:28 $
 */
public class FileContentInfoFilenameFactory implements FileContentInfoFactory
{
    public FileContentInfo create(FileContent fileContent)
    {
        String contentType = null;

        String name = fileContent.getFile().getName().getBaseName();
        if (name != null)
        {
            FileNameMap fileNameMap = URLConnection.getFileNameMap();
            contentType = fileNameMap.getContentTypeFor(name);
        }

        return new DefaultFileContentInfo(contentType, null);
    }
}