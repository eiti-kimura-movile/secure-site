package com.movile.project.filters;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Web application listener
 */
@Service
public class AppContextListener implements ServletContextListener {

	private static Logger log = LoggerFactory.getLogger(AppContextListener.class);
	
    /*
     * (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
     * ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent context) {
    	stop();
        log.info("Finished Context");
    }

    /*
     * (non-Javadoc)
     * @see
     * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
     * .ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent context) {
    	 load();
         log.info("Starting context...");
    }
    
    /**
     * Starts a JMX over http interface if and opendmk.jar is in the classpath.
     * @return true if successfully loaded.
     */
    public static Boolean load() {
        Boolean loaded = Boolean.FALSE;

        try {
            log.debug("Will try to load opendmk now, if it's in the classpath");
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

            Class<?> httpAdaptorClass = Class.forName("com.sun.jdmk.comm.HtmlAdaptorServer");
            Object httpAdaptor = httpAdaptorClass.newInstance();
            httpAdaptorClass.getMethod("setPort", Integer.TYPE).invoke(httpAdaptor, 9001);

            ObjectName httpName = new ObjectName("system:name=http");
            mbs.registerMBean(httpAdaptor, httpName);
            httpAdaptorClass.getMethod("start").invoke(httpAdaptor);
            log.info("OpenMDK HtmlAdaptor successfuly loaded on port: {}", 9001);
            loaded = Boolean.TRUE;

        } catch (ClassNotFoundException e) {
            log.debug("Will not load html adaptor, opendmk.jar is not in the classpath");
        } catch (Exception e) {
            log.warn("Could not start register mbean in JMX", e);
        }

        return loaded;
    }
    

    /**
     * Starts a JMX over http interface if and opendmk.jar is in the classpath.
     * @return true if successfully loaded.
     */
    public static Boolean stop() {
        Boolean stopped = Boolean.FALSE;

        try {
            log.debug("Will try to stop opendmk HtmlAdaptor");
            //MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

            Class<?> httpAdaptorClass = Class.forName("com.sun.jdmk.comm.HtmlAdaptorServer");
            Object httpAdaptor = httpAdaptorClass.newInstance();

            httpAdaptorClass.getMethod("stop").invoke(httpAdaptor);
            log.info("OpenMDK HtmlAdaptor port: {} stopped", 9001);
            stopped = Boolean.TRUE;

        } catch (ClassNotFoundException e) {
            log.debug("Will not stop html adaptor it was not loaded");
        } catch (Exception e) {
            log.warn("Could not start register mbean in JMX", e);
        }

        return stopped;
    }

}
