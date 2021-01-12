package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


public class WebAppIni implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//Se crea un root context, con tenedor de configuraciones de spring
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		
		//Se registra la clase de @Configuracion
		appContext.register(AppContextConfig.class);
		
		//Se le indica al listener que cargue el contexto de spring en el servlet context al comenzar
		//la aplicacion
		ContextLoaderListener contextLoadListener = new ContextLoaderListener(appContext);
		
		
		//Se añade el listener al servlet context ()contexto de la app web en general
		servletContext.addListener(contextLoadListener);
		
//		FilterRegistration.Dynamic filter = servletContext.addFilter(
//                "StrutsDispatcher", new StrutsPrepareAndExecuteFilter());
//        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),
//                true, "/*");
		
	}

}
