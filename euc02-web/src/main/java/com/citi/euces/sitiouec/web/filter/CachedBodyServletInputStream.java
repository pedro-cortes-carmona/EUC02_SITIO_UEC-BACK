/**
 * 
 */
package com.citi.euces.sitiouec.web.filter;

import javax.servlet.ServletInputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ReadListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 
 *
 */
public class CachedBodyServletInputStream extends ServletInputStream  {

	private static final Logger LOGGER = LogManager.getLogger(CachedBodyServletInputStream.class);
	private InputStream cachedBodyInputStream;

    public CachedBodyServletInputStream(byte[] cachedBody) {
        this.cachedBodyInputStream = new ByteArrayInputStream(cachedBody);
    }

    @Override
    public boolean isFinished() {
        try {
            return cachedBodyInputStream.available() == 0;
        } catch (IOException e) {
        	LOGGER.error(e);
        }
        return false;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener readListener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int read() throws IOException {
        return cachedBodyInputStream.read();
    }
    
}
