package fr.ecp.sio.filrougeapi.auth;

import fr.ecp.sio.filrougeapi.data.DataUtils;
import fr.ecp.sio.filrougeapi.endpoints.UsersServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A filter, declared in web.xml, that will intercept requests to our API and check for valid credentials before the request reaches the servlet. -->
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Nothing to do when the filter is initialized (at server's startup or first request).
    }

    // All requests and responses are forwarded to the doFilter() method.
    // It is your responsibility to call filterChain.doFilter() somewhere in the implementation for the request to continue to the servlet.
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Let's inspect HTTP headers of the request.
        String auth = ((HttpServletRequest) servletRequest).getHeader("key");
        if (!auth.equals(DataUtils.getToken())) {
            //If authentication or authorization fails, send an HTTP error response and do NOT call filterChain.doFilter().
            ((HttpServletResponse) servletResponse).sendError(401, "You have not authorization!");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() { }

}
/*
if(servletRequest instanceof UsersServlet){
        filterChain.doFilter(servletRequest, servletResponse);

        }else {*/