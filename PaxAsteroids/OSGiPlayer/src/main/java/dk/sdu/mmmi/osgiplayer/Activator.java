package dk.sdu.mmmi.osgiplayer;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    
    private ServiceRegistration pluginService;
    private ServiceRegistration processingService;

    @Override
    public void start(BundleContext context) throws Exception {
        pluginService = context.registerService(IGamePluginService.class.getName(), new PlayerPlugin(),null);
        processingService = context.registerService(IEntityProcessingService.class.getName(), new PlayerProcessor(),null);
        
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        pluginService.unregister();
        processingService.unregister();
    }

}
